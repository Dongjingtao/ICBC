### 新建Oracle用户
* [ ] 新建Oracle用户XIAMI
* [ ] 在开发环境上配置Oracle客户端
------

一、新建Oracle用户XIAMI
选取一台正常运行且已配置实例的数据库作为本次学习的实验环境

1. 登录数据库服务器（Suse Linux）
telnet/ssh登录服务器（略）
用root用户或其他非oracle用户登录服务器后需要执行命令
```shell
su - oracle
```
注意su oracle和su - oracle的区别，前者仅切换用户，后者不仅切换用户，还设置环境变量

2. 确认当前数据库实例是否目标实例
执行命令
```shell
env或
echo $ORACLE_SID
```
因为一个数据库服务器可以启多个实例，所以需要确认当前实例是否是目标实例xxxx。如果不是，执行命令
```
export $ORACLE_SID=xxxx
```

修改环境变量
如果不清楚需要用哪个实例，再见！

3. 了解服务器存储空间是否满足需要
执行命令
```shell
df -h
```
一般数据库存储是放在单独的文件系统上，根据文件系统名大致能猜出用的是哪个文件系统，比如/data,/oradata之类，查看剩余空间是否满足需要。
同时cd进去看一下数据库管理员建表空间的风格，比如有的是按照实例名建子目录，有的是按应用名建子目录，有的是放在同一目录下，保持风格一致。


4. 创建数据库表空间
假设/oradata为表空间目录，表空间文件按应用名建子目录
先在服务器上以oracle用户建子目录
cd /oradata
mkdir xiami
建数据表空间XIAMI_DATA和索引表空间XIAMI_INDX
sqlplus登录数据库
```sql
sqlplus /nolog
connect / as sysdba
```
执行新建表空间语句，注意关闭自动扩展（AUTOEXTEND OFF）
```sql
CREATE TABLESPACE XIAMI_DATA DATAFILE 
  '/oradata/xiami/xiami_data_01.dbf' SIZE 256M AUTOEXTEND OFF;
CREATE TABLESPACE XIAMI_INDX DATAFILE 
  '/oradata/xiami/xiami_indx_01.dbf' SIZE 128M AUTOEXTEND OFF; 
```

5. 建用户并赋权限

```sql
CREATE USER XIAMI
  IDENTIFIED BY "PassWord..1"
  DEFAULT TABLESPACE XIAMI_DATA
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;
  -- 2 Roles for XIAMI 
  GRANT RESOURCE TO XIAMI;
  GRANT CONNECT TO XIAMI;
  ALTER USER XIAMI DEFAULT ROLE ALL;
  -- 3 System Privileges for XIAMI 
  GRANT CREATE ANY TABLE TO XIAMI;
  GRANT DEBUG CONNECT SESSION TO XIAMI;
  GRANT CREATE ANY VIEW TO XIAMI;
  GRANT DROP ANY VIEW TO XIAMI;
  GRANT DEBUG ANY PROCEDURE TO XIAMI;
  GRANT UNLIMITED TABLESPACE TO XIAMI;
  -- 4 Tablespace Quotas for XIAMI 
  ALTER USER XIAMI QUOTA UNLIMITED ON XIAMI_DATA;
  ALTER USER XIAMI QUOTA UNLIMITED ON XIAMI_INDX;
```
注意别把DBA权限授给应用用户
然后exit退出sqlplus

6. 测试
sqlplus xiami/PassWord..1
是否能登录用户

7. 生产环境注意事项
* 注意oracle用户密码复杂度要求
* 新建oracle用户后需ucm纳管
* 新增表空间变更前，先检查数据库服务器存储空间情况，预估使用率，若空间不足，请联系平台研发科
* 创建表空间语句执行需要一定时间，请耐心

* * *
二、Oracle开发环境搭建（Windows环境）
1. 安装Oracle 11g client
    总行下发了安装介质，可咨询技术管理科获取。
    如果找不到总行安装手册的话，可自行上网搜索资源。
    注意安装完后检查PATH路径是否包含oracle的bin目录。
2. 安装PLSQL Developer（略）
3. 配置tnsnames.ora
```shell
MSDB =
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 数据库服务器地址)(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE_NAME = msdb)
    )
  )
```

注意4点

* MSDB 自定义服务名
* 数据库服务器ip或域名
* 端口1521，但要注意有的数据库监听可能设置了非1521端口
* SERVICE_NAME = msdb

4. 使用PLSQL Developer登录xiami，注意'@msdb'参数

```shell
sqlplus xiami/PassWord..1@msdb
```



* * *
扩展
1. 查看dbf文件物理路径
sqlplus登录数据库
```sql
select t1.name,t2.name  from v$tablespace t1,v$datafile t2 where t1.ts# = t2.ts#;
```
可以看到所有表空间对应dbf文件的物理路径，比较一下df -h，就可以了解存储空间情况了。

2. lsnrctl命令
lsnrctl status命令可以了解数据库服务器启的实例及相应端口信息
lsnrctl start/stop命令可以启停监听程序
如果设置了密码如何操作？

3. 当测试环境存储空间不足且又无法扩充时，可以试着压榨一下

登录数据库服务器
```sql
sqlplus /nolog
connect / as sysdba
```
执行语句
```sql
SELECT /*+ ordered use_hash(a,c) */
          'alter database datafile '''
       || a.file_name
       || ''' resize '
       || ROUND (a.filesize - (a.filesize - c.hwmsize - 100) * 0.8)
       || 'M;'
  FROM (SELECT file_id, file_name, ROUND (BYTES / 1024 / 1024) filesize
          FROM dba_data_files) a,
       (SELECT   file_id, ROUND (MAX (block_id) * 8 / 1024) hwmsize
            FROM dba_extents
        GROUP BY file_id) c
 WHERE a.file_id = c.file_id AND a.filesize - c.hwmsize > 100;
```
返回结果如下：
```sql
alter database datafile '/data/oradata/dat/acas/acas_indx_01.dbf' resize 582M;
```
Ctrl-c Ctrl-v执行这些语句，会省出不少空间来。

相关原理请上网搜索HWM做进一步了解。

生产环境请遵照平台研发科相应规范要求执行。
