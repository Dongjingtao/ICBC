## SQL
* [ ] 以2张机构表为操作对象，逐步熟悉SQL
* [ ] 掌握一些常用的sql

------

我们将在xiami用户上新建2张表，CD_ORGN_DIM机构维表、CD_ORGN_DISPLAY机构展现关系表，通过一系列CRUD操作来介绍开发工作中的一些注意事项以及一些可能比较常用的语句的写法。

1. CREATE TABLE
    注意4点
    一是通过tablespace指定表空间
    二是必须comment on table/column添加注释
  
    三是注意列定义的辅助属性，比如not null， default 
  
    四是如果数据量按日期大量增长，需要建分区表，默认按月分区

```sql
-- Create table
create table CD_ORGN_DIM
(
  zone_no      VARCHAR2(5),
  br_no        VARCHAR2(8),
  orgn_seq     NUMBER,
  orgn_code    VARCHAR2(10) not null,
  orgn_unicode VARCHAR2(10),
  orgn_name    VARCHAR2(100),
  orgn_level   VARCHAR2(1),
  orgn_type    VARCHAR2(5),
  sdate        VARCHAR2(8),
  edate        VARCHAR2(8) default '99991231',
  br_type      VARCHAR2(10),
  zone_type    VARCHAR2(10),
  block_type   VARCHAR2(10),
  status_type  VARCHAR2(10),
  prop_type    VARCHAR2(10)
)
tablespace XIAMI_DATA;

-- Add comments to the table
comment on table CD_ORGN_DIM
  is '机构维表，记录机构维的相关信息，如机构号、机构类型、机构层次等';
-- Add comments to the columns
comment on column CD_ORGN_DIM.zone_no
  is '地区号';
comment on column CD_ORGN_DIM.br_no
  is '网点号';
comment on column CD_ORGN_DIM.orgn_seq
  is '机构流水号';
comment on column CD_ORGN_DIM.orgn_code
  is '机构号';
comment on column CD_ORGN_DIM.orgn_unicode
  is '机构编码';
comment on column CD_ORGN_DIM.orgn_name
  is '机构名称';
comment on column CD_ORGN_DIM.orgn_level
  is '机构层次';
comment on column CD_ORGN_DIM.orgn_type
  is '机构类型';
comment on column CD_ORGN_DIM.sdate
  is '启用时间';
comment on column CD_ORGN_DIM.edate
  is '截止时间';
comment on column CD_ORGN_DIM.br_type
  is '网点类型';
comment on column CD_ORGN_DIM.zone_type
  is '区域类型';
comment on column CD_ORGN_DIM.block_type
  is '支行板块类型';
comment on column CD_ORGN_DIM.status_type
  is '网点业态类型';
comment on column CD_ORGN_DIM.prop_type
  is '网点特征类型';

-- Create table
create table CD_ORGN_DISPLAY
(
  orgn_code   VARCHAR2(6),
  f_orgn_code VARCHAR2(6),
  sdate       VARCHAR2(8),
  edate       VARCHAR2(8)
)
tablespace XIAMI_DATA;
-- Add comments to the table 
comment on table CD_ORGN_DISPLAY
  is '机构展现关系表，记录各个机构的下属（展现）机构号，以及展现关系的有效时间。';
-- Add comments to the columns 
comment on column CD_ORGN_DISPLAY.orgn_code
  is '机构流水号';
comment on column CD_ORGN_DISPLAY.f_orgn_code
  is '机构的上层机构';
comment on column CD_ORGN_DISPLAY.sdate
  is '启用时间';
comment on column CD_ORGN_DISPLAY.edate
  is '截止时间';
  
create table CD_ORGN_DISPLAY_BAK as 
select * from CD_ORGN_DISPLAY;
```

2. CREATE INDEX
    建索引的目的是为了获得比全表扫描更优的查询性能，所以数据量很小（几条、几十条记录）的表，不用建索引。

  索引基本原理和概念不多做解说，比如主键、唯一索引、非唯一索引、唯一约束、单行索引、复合索引、函数索引、B-tree索引、位图索引等请学习掌握。

  注意5点
  一是必须指定索引表空间，且与table的表空间分开。
  二是多列索引字段的选取。创建索引是为了提高查询性能，所以选取字段不仅要考虑字段是否会作为查询限定条件被用到（并不是where条件中字段要和索引字段完全一一对应），更要考虑字段的selectivity选择性（区分度），是否能快速缩小结果集，一般在建复合索引时，将区分度最高的字段放在前面。
  三是可能很多表并没有建主键，需要从业务上分析找到哪几列是逻辑上的主键。

  四是对于分区表是否要建分区索引需要根据查询场景来判断。

  五是索引列默认顺序排列。

  

  建索引的一般流程：

  分析表，哪些字段是经常作为where语句条件使用或者需要排序的；

  这些字段的区分度，一般主键或唯一索引的区分度为1最高，性能最佳；

  选择区分度较高的字段，建立索引。

  

  在使用过程中，有几种情况索引用不上：

  like的字符串中第一个字符是'%'时用不上

  <>用不上

  索引字段没加函数，但where条件对字段用了函数

  字段是字符串，但字段值是数字，没加单引号时用不上

```sql
-- Create/Recreate indexes
create index IND_CD_ORGN_DIM_1 on CD_ORGN_DIM (BR_NO, SDATE, EDATE)
  tablespace XIAMI_INDX;
```

3. 没有PLSQL Developer工具怎么查看表结构，以及计算区分度的方法
sqlplus登录xiami用户
```sql
select * from user_tables;

desc CD_ORGN_DIM;

select user_ind_columns.index_name,
       user_ind_columns.column_name,
       user_ind_columns.column_position,
       user_indexes.uniqueness
  from user_ind_columns, user_indexes
 where user_ind_columns.index_name = user_indexes.index_name
   and user_ind_columns.table_name = upper('CD_ORGN_DIM');
   
select count(1) as cnt from CD_ORGN_DIM;

select column_name, num_distinct, num_distinct/:cnt
from user_tab_columns where table_name = 'CD_ORGN_DIM';

```
4. INSERT
注意生产程序中SELECT或者INSERT尽量列出所有字段，避免表结构修改后程序报错
sqlplus登陆后，@file_name.sql方式批量执行sql语句

```sql
--insert into values
insert into CD_ORGN_DIM (ZONE_NO, BR_NO, ORGN_SEQ, ORGN_CODE,
ORGN_UNICODE, ORGN_NAME, ORGN_LEVEL, ORGN_TYPE, SDATE, EDATE, BR_TYPE,
ZONE_TYPE, BLOCK_TYPE, STATUS_TYPE, PROP_TYPE)
values (null, null, null, '200592', '0100100000', '上海市分行', '1',
'01', '20020101', '20991231', null, null, null, null, null);
insert into CD_ORGN_DIM (ZONE_NO, BR_NO, ORGN_SEQ, ORGN_CODE,
ORGN_UNICODE, ORGN_NAME, ORGN_LEVEL, ORGN_TYPE, SDATE, EDATE, BR_TYPE,
ZONE_TYPE, BLOCK_TYPE, STATUS_TYPE, PROP_TYPE)
values (null, null, null, '200593', '0100100011', '上海分行机构本部', '2',
'21', '20020101', '20991231', null, '05', null, null, null);
commit;

@cd_orgn_dim.sql

--insert into select 
insert into CD_ORGN_DIM
select * from CD_ORGN_DIM
where orgn_code = '200592';
commit;

@cd_orgn_display.sql
commit;
```

5. SELECT

```sql
--查看insert结果    to_char和sysdate
select * from cd_orgn_dim
where sdate <= to_char(sysdate,'yyyymmdd')
and edate >= to_char(sysdate,'yyyymmdd');

--查询记录数 注意null、decode、nvl和distinct的使用
select count(1) from cd_orgn_dim;

select count(*) from cd_orgn_dim;

select count(br_no) from cd_orgn_dim;

select count(1) from cd_orgn_dim c
where br_no is not null;

select sum(decode(br_no,'',0,1)) from cd_orgn_dim;

select count(nvl(br_no,'-')) from cd_orgn_dim;

select count(distinct br_no) from cd_orgn_dim;

--找重复记录
--group by和having子句
select orgn_code,sdate,edate,count(1) from cd_orgn_dim
group by orgn_code,sdate,edate
having count(1) > 1;

--partition by子句
select orgn_code, sdate, edate, count(1)
  from (select b.*,
               row_number() over(partition by orgn_code, sdate, edate order
by sdate desc) as rn
          from cd_orgn_dim b) a
 where a.rn = 1
 group by orgn_code, sdate, edate
 
--多表关联查询
select a.orgn_code,
       b.orgn_name || '[' || b.orgn_level || ']',
       a.f_orgn_code,
       c.orgn_name || '[' || c.orgn_level || ']'
  from cd_orgn_display a, cd_orgn_dim b, cd_orgn_dim c
 where a.orgn_code = b.orgn_code
   and a.f_orgn_code = c.orgn_code
   and a.sdate <= '20200111'
   and a.edate >= '20200111'
   and b.sdate <= '20200111'
   and b.edate >= '20200111'
   and c.sdate <= '20200111'
   and c.edate >= '20200111'
 order by c.orgn_name
 
 --左外关联
 --当前有效机构及其下辖一级机构数
 select a.orgn_code, a.orgn_name, count(b.orgn_code)
   from cd_orgn_dim a, cd_orgn_display b
 where a.orgn_code = b.f_orgn_code(+)
 group by a.orgn_code,a.orgn_name,a.orgn_level
 order by a.orgn_level, a.orgn_code

--爷爷找孙子
--exists子句
start with connect by子句
select level,
       f_orgn_code,
       (select distinct b.orgn_name || '[' || b.orgn_level || ']'
          from cd_orgn_dim b
         where a.f_orgn_code = b.orgn_code
           and b.sdate <= '20200111'
           and b.edate >= '20200111') as f_orgn_name,
       orgn_code,
       (select distinct b.orgn_name || '[' || b.orgn_level || ']'
          from cd_orgn_dim b
         where a.orgn_code = b.orgn_code
           and b.sdate <= '20200111'
           and b.edate >= '20200111') as orgn_name,
       sdate,edate
  from cd_orgn_display a
 where a.sdate <= '20200111'
   and a.edate >= '20200111'
   and exists (select 1
          from cd_orgn_dim c
         where a.orgn_code = c.orgn_code
           and c.sdate <= '20200111'
           and c.edate >= '20200111')
 start with f_orgn_code = '200592'
connect by prior orgn_code = f_orgn_code;

--孙子找爷爷
select level,
       f_orgn_code,
       (select distinct b.orgn_name || '[' || b.orgn_level || ']'
          from cd_orgn_dim b
         where a.f_orgn_code = b.orgn_code
           and b.sdate <= '20200111'
           and b.edate >= '20200111') as f_orgn_name,
       orgn_code,
       (select distinct b.orgn_name || '[' || b.orgn_level || ']'
          from cd_orgn_dim b
         where a.orgn_code = b.orgn_code
           and b.sdate <= '20200111'
           and b.edate >= '20200111') as orgn_name,
       sdate,
       edate
  from cd_orgn_display a
 where a.sdate <= '20200111'
   and a.edate >= '20200111'
   and exists (select 1
          from cd_orgn_dim c
         where a.orgn_code = c.orgn_code
           and c.sdate <= '20200111'
           and c.edate >= '20200111')
 start with orgn_code = '100169'
connect by  orgn_code = prior f_orgn_code;

```

6. UPDATE

可以用值、函数、子查询进行update
```sql
update cd_orgn_dim
   set orgn_seq  = to_char(trunc(dbms_random.value(0, 100))),
       br_type   = '1',
       zone_type =
       (select max(edate) from cd_orgn_display where f_orgn_code = '200592')
 where orgn_code = '200592';
```

7. DELETE和truncate

注意exists/not exists子句和in/not in子句的区别，in/not in不对null进行处理，因为驱动表大小的关系，一般情况下使用exists子句性能更优，但如果in的集合比较小，且exists子句无法用到区分度较高的索引时，可能in的效率会高一些。

```sql
delete from cd_orgn_dim a
 where not exists
 (select 1 from cd_orgn_display b where a.orgn_code = b.orgn_code)
   and not exists
 (select 1 from cd_orgn_display b where a.orgn_code = b.f_orgn_code);
 
 truncate table cd_orgn_lev;
```

8. COMMIT和ROLLBACK

   事务的概念

   要注意DDL语句会隐式提交，每次DDL语句执行时会自动提交当前事务。

   ```sql
   --删除重复记录
   delete cd_orgn_dim
    where rowid in (select rowid
                      from (select b.*,
                                   rowid,
                                   row_number() over(partition by orgn_code, sdate, edate order by sdate desc) as rn
                              from cd_orgn_dim b) a
                     where a.rn > 1
                       and orgn_code = '200592');
   rollback;                    
   ```

   

9. CREATE SEQUENCE

   ```sql
   -- Create sequence 
   create sequence SEQ_ORGN
   minvalue 1
   maxvalue 9999999999
   start with 1
   increment by 1
   cache 10
   cycle
   order;
   
   --使用
   select to_char(SYSDATE, 'YYYYMMDDHH24MISS')||lpad(SEQ_ORGN.nextval, 10, 0) from dual
   ```

   

10. 存储过程

    输入参数/输出参数

    变量申明和赋值

    函数的使用

    select into赋值

    if-else

    for-loop循环，这里开了个游标

    字符串拼接操作

    异常捕获

```sql
create or replace procedure proc_update_orgnseq(i_date    in varchar2,
                                                o_retcode out varchar2) is
  v_num  number := 0;
  v_date date;
begin
  --初始化返回值
  o_retcode := 'init';

  --粗糙版的日期验证
  v_date := to_date(i_date, 'YYYYMMDD');

  --如果日期i_date为空，将所有非网点机构的br_no字段更新为orgn_code
  if i_date is null then
    select count(1) into v_num from cd_orgn_dim where orgn_level <> '4';
    if v_num > 0 then
      update cd_orgn_dim set br_no = orgn_code where orgn_level <> '4';
    
    end if;
  
  else
  
    --如果日期i_date不为空，将有效期内所有非网点机构的br_no字段更新为orgn_code
    select count(1)
      into v_num
      from cd_orgn_dim
     where orgn_level <> '4'
       and sdate <= i_date
       and edate >= i_date;
  
    if v_num > 0 then
      for item in (select *
                     from cd_orgn_dim
                    where orgn_level <> '4'
                      and sdate <= i_date
                      and edate >= i_date) loop
        update cd_orgn_dim
           set br_no = item.orgn_code
         where orgn_code = item.orgn_code;
      end loop;
    
    end if;
  
  end if;
  o_retcode := 'update ' || v_num || ' orgn''s br_no';

  commit;

  return;

exception
  when others then
    o_retcode := 'error: ' || SQLCODE || SUBSTR(SQLERRM, 1, 200);
    rollback;
    return;
end proc_update_orgnseq;

```

sqlplus登录数据库后调用存储过程，注意'/'执行

```sql
SET TIME ON
SET TIMING ON
SET SERVEROUTPUT ON

DECLARE
  i_date  VARCHAR2(32767);
  o_retcode VARCHAR2(32767);

BEGIN
  i_date :=  '20150101';
  o_retcode := NULL;

  proc_update_orgnseq ( i_date,  o_retcode );
  COMMIT;
  dbms_output.put_line(o_retcode);
END;
/
```



***
扩展
1. drop table <table>和 drop table <table> purge的区别，从purge->recyclebin->flashback引申阅读。
2. 主键、唯一约束和唯一索引的关系和区别是什么？
3. 怎么查看sql语句的执行计划，以及怎么判断sql语句执行性能的优劣？
4. 怎么建分区表和分区索引，新增分区如何操作？
5. 了解oracle字典表dictionary、user_objects、user_tables、user_indexes、user_ind_columns，视图和存储过程从什么表里能找到？
6. 在update cd_orgn_dim之前，怎么通过partition by子句删除orgn_code='200592'的重复记录，仅保留一条？
7. 在做完cd_orgn_dim update操作后，对于orgn_code='200592'的4条记录，怎么通过group by子句仅保留orgn_seq最大的一条？
8. 列举至少3种开游标的方式
9. 用spool方式导出cd_orgn_dim所有记录，字段以半角逗号分隔。

