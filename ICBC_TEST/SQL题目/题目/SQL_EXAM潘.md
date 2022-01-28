# 数据库基础测试

## 选择(2*10=20)

### 单选

关于索引(index)的说法哪些是错误? (             A        )

创建索引能提高数据插入的性能

索引应该根据具体的检索需求来创建，在选择性好的列上创建索引

索引并非越多越好

建立索引可使检索操作更迅速

 

###  单选

语句GRANT、REVOKE实现了结构化查询语言的哪类功能（      C             ）

A   DDL   B    DML  C    DCL   D DTL

 

### 单选

数据库可以对数据上锁 ，通常分为 shared lock  s锁 和  exclusive lock X锁 ，若事务 T 对数据对象 A 加上 S 锁，则（  A            ）。C

A   事务T可以读A和修改A，其它事务只能再对A加S锁，而不能加X 锁。

B   事务T可以读A但不能修改A，其它事务能对A加S锁和X锁。

C   事务T可以读A但不能修改A，其它事务只能再对A加S锁，而不能加X 锁。

D   事务T可以读A和修改A，其它事务能对A加S锁和X锁。

 

 

### 单选

设有关系模式EMP（职工号，姓名，年龄，技能）。假设职工号唯一，每个职工有多项技能，则EMP表的主键是（       D            ）

A   职工号       B   姓名           C  姓名，技能   D    职工号，技能

 



### 单选

一个学生可以同时借阅多本书，一本书只能由一个学生借阅，学生和图书之间为 (           D       ) 联系。B

A    一对一    B   一对多    C    多对多    D   多对一

 



### 单选

以下语句能实现从oracle数据库orcl中导出表users的数据的是 (         D           )B

A  exp user/password@orcl file=users.dmp table=users buffer=40960000 ignore=y

B  exp user/password@orcl file=users.dmp tables=users buffer=40960000 ignore=n

C  exp users/password@orcl data=users.dmp table=users buffer=40960000 ignore=y

D  exp users/password@orcl data=users.dmp tables=users buffer=40960000 ignore=n

 



### 单选

Mysql中表student_table(id,name,birth,sex)，插入如下记录：

('1003' , NULL , '2002-05-20' , '男');

('1004' , '张三' , '2000-09-06' , '男');

('1005' , '李四' , '2001-12-01' , '女');

('1006' , NULL , '2001-12-02' , '女');

修改name字段为NULL的记录，是男生时设置name='男生姓名'，是女生时设置name='女生姓名'，如下SQL正确的是（      D           ）？



A    update student_table set name  = ( case when sex = '男' then '男生姓名' when sex = '女' then '女生姓名' end) if name is null ;

B    update student_table when name is null set name  = ( case when sex = '男' then '男生姓名' when sex = '女' then '女生姓名') ;

C    update student_table set name  = ( when sex = '男' then '男生姓名' when sex = '女' then '女生姓名') where name is null ;

D    update student_table set name  = ( case when sex = '男' then '男生姓名' when sex = '女' then '女生姓名' end) where name is null ;

 



### 单选

查找 student表中所有电话号码(列名：telephone)的第一位为1，第三位为6的电话号码(          C     )



A   SELECT telephone FROM student WHERE telephone LIKE ‘1%6*’

B   SELECT telephone FROM student WHERE telephone LIKE ‘1*6%’

C   SELECT telephone FROM student WHERE telephone LIKE ‘1_6%’

D   SELECT telephone FROM student WHERE telephone LIKE ‘1_6*’





### 单选

如果系统现在需要在一个很大的表上创建一个索引，哪个动作无法优化性能/减少影响?(    C         )D

A    调大一些系统资源使用限制，例如增大sort_area_size（8i）/pga_aggregate_target（Arrayi）值

B    如果表有分区（一般大表都要用到分区的），按分区逐个建索引，如果是本地索引的话

C     系统空闲的时候建。

D    把日志文件放到另一个地方

 

### 单选

下面关于数据库锁的描述正确的是（    D     ）C

A     只有支持事务的引擎才有锁（以前的数据库有锁，但是不支持事务，不支持事务可以支持锁）

B     在可以用行锁的情况下，都应该使用行锁而不要使用表锁

C     在高并发的在做更新操作时，应该先尝试申请共享锁，成功后再申请排他锁

D     线上事务中，几乎无法避免锁等待或死锁的产生（生产上是不允许的）





## SQL开发(3*15=45)

### 请编写语句创建数据表空间tbs_user_data，大小为100M，数据文件存放在/oradata/orcl/tbs_icbc_user01.dbf，并关闭自动增长。

```sql
--sql please 
SQL> create tablespace  tbs_user_data 
datafile '/oradata/orcl/tbs_icbc_user01.dbf'
size 100M 
autoextend off;
```



 

### 请编写语句在表空间tbs_user_data上创建用户icbc_user，并赋予resource和connect权限。

```sql
--sql please 
--在表空间创建用户
SQL> create user icbc_user identified by “icbc_user” default tablespace tbs_user_data;
--赋予用户权限
SQL> grant connect,resource to icbc_user;
```

 

### 请编写语句创建索引表空间tbs_user_idx，大小为50M，数据文件存放在/oradata/orcl/tbs_user_idx01.dbf，并关闭自动增长。

```sql
--sql please 
SQL> create tablespace  tbs_user_idx
datafile '/oradata/orcl/tbs_user_idx01.dbf
size 50M 
autoextend off;
```

 

### 请编写语句创建表user_profile，包含字段id【不可为空，整数类型，范围越大越好】，设备id（device_id）【不可为空】，性别（gender），年龄（age）【整数类型，最大不超过200】，大学（university），省份/直辖市（province）

```sql
--sql please 
create table user_profile(
id   bigint not null,
device_id not null  int ,
gender  char(4) ,
age int check(age<=200),
university varchar(100),
province  varchar(50),
constraint age maxvalue 200
);

-- Add comments to the table（为表增加注释）
comment on table user_profile
  is '用户信息表';
-- Add comments to the columns
comment on column user_profile.id
  is '字段id，不能为空，整数类型';
comment on column user_profile.device_id
  is '设备id，不能为空';
comment on column user_profile.gender
  is '性别';
comment on column user_profile.age
  is '年龄，整数类型，最大不超过200';
comment on column user_profile.university
  is '大学信息';
comment on column user_profile.province
  is '省份/直辖市';

```

 

### 请编写语句在索引表空间上为用户信息表user_profile创建主键id约束。

```sql
--sql please 
alter table user_profile modify id(primary key)
table space tbs_user_idx;
```





### Oracle 中通常使用sequence来生成唯一并且自增的编号，请编写语句创建序列user_id_seq，从1开始，每次增长1，最大为100000000000

```sql
--sql please 
 create sequence user_id_seq
   minvalue 1
   maxvalue 100000000000
   start with 1
   increment by 1
   cache 5
   cycle
   order;
```





### 请编写语句向用户信息表中插入数据，如下图所示：

![image-20211223105609409](SQL_EXAM.assets/image-20211223105609409.png)



其中id字段的值通过user_id_seq的序列生成,写两条数据即可.

```sql
--sql please 
insert all into user_profile(id) values(select lpad(user_id_seq.nextval, 5, 0) from dual);
insert all into user_profile(device_id,gender,age,university,province) values(2138,'male',21,'北京大学','beijing')
into user_profile(device_id,gender,age,university,province) values(3214,'male',null,'复旦大学','shanghai')
into user_profile(device_id,gender,age,university,province) values(6543,'female',20,'北京大学','beijing')
into user_profile(device_id,gender,age,university,province) values(2315,'female',23,'浙江大学','zhejiang')
into user_profile(device_id,gender,age,university,province) values(5432,'male',25,'山东大学','shandong');

```



### 题目：请编写语句创建用户信息备份表user_profile_bak_20211231，并且将user_profile表中的所有数据都存入备份表

 ```sql
--sql please 
create table user_profile_bak_20211231(
id   bigint not null,
device_id not null  int ,
gender  char(4) ,
age int ,
university varchar(100),
province  varchar(50),
constraint age maxvalue 200
);

-- Add comments to the table（为表增加注释）
comment on table user_profile_bak_20211231
  is '用户信息备份表，具体表字段请参考表user_profile';
  
  insert into user_profile_bak_20211231 values(select * from user_profile);
 ```

### 题目：按照id排序，查看前2个用户设备ID数据，请你从用户信息表 user_profile 中取出相应结果。

 

```sql
--sql please 
select device_id from(
select device_id
from  user_profile
order by id )t 
where rownum<3;

```

### 题目：查询用户信息表user_profile中所有的明细数据，并先按照gpa、年龄降序排序输出，请取出相应数据。

```sql
--sql please 
select *
from user_profile
order by gpa desc , age desc;
```

### 题目：请编写语句取出所有年龄值不为空的用户明细数据。

```sql
--sql please 
select *
from user_profile
where age is not null;
```

### 题目：请编写语句在索引表空间上为年龄创建索引idx_user_age。

接下题，一张有index，另一张没有index，两张表的执行计划是不一样的

```sql
--sql please 
create index idx_user_age on user_profile(age)
tablespace  tbs_user_idx;
```

### 题目：请编写语句查询年龄小于24岁且学校不是北京大学的用户明细数据。请在用户信息备份表上也执行本查询语句，并分别查看两句SQL的执行计划（截图）。

执行计划是：

```sql
--sql please 
select *
from user_profile
where age<24 and university<>'北京大学';
```

 

### 题目：现在想要将用户划分为25岁以下和25岁及以上两个年龄段，分别查看这两个年龄段用户数量（***\*age为null 也记为 25岁以下\****）

 ```sql
--sql please 
select age_type,count(*) as user_amout
from (
select  case when new_age<25 then '25岁以下' else '25岁及以上' end as age_type
from(
select coalesce(age,0) as new_age
from user_profile) t) t1
group by age_type;

 ```

 

### 题目：请编写语句统计设备id的第一位数字相同的用户数量

```sql
--sql please 

select device_id1,count(*) as user_amout
from (
select substr(to_char(device_id),1,1) as device_id1,id,device_id
from user_profile) t
group by device_id1
having count(*)>1;

```





***<u>注意以下题目的user_profile表结构有所变化</u>***



## SQL开发2 (6*4+11=35)



### 题目：现在想要对每个学校不同性别的用户活跃情况和发帖数量进行分析，请分别计算出每个学校每种性别的用户数、30天内平均活跃天数和平均发帖数量。

增补字段含义如下：

30天内活跃天数字段（active_days_within_30）

发帖数量字段（question_cnt）

回答数量字段（answer_cnt）	



![image-20211223132409885](SQL_EXAM.assets/image-20211223132409885.png)

查询结果示例如下：

![image-20211223132421370](SQL_EXAM.assets/image-20211223132421370.png)

```sql
drop table if exists user_profile1;
CREATE TABLE user_profile1 (
id int NOT NULL,
device_id int NOT NULL,
gender varchar(14) NOT NULL,
age int ,
university varchar(32) NOT NULL,
gpa float,
active_days_within_30 float,
question_cnt float,
answer_cnt float
);
INSERT INTO user_profile1 VALUES(1,2138,'male',21,'北京大学',3.4,7,2,12);
INSERT INTO user_profile1 VALUES(2,3214,'male',null,'复旦大学',4.0,15,5,25);
INSERT INTO user_profile1 VALUES(3,6543,'female',20,'北京大学',3.2,12,3,30);
INSERT INTO user_profile1 VALUES(4,2315,'female',23,'浙江大学',3.6,5,1,2);
INSERT INTO user_profile1 VALUES(5,5432,'male',25,'山东大学',3.8,20,15,70);
INSERT INTO user_profile1 VALUES(6,2131,'male',28,'山东大学',3.3,15,7,13);
INSERT INTO user_profile1 VALUES(7,4321,'male',28,'复旦大学',3.6,9,6,52);
commit;
```



```sql
--your sql please...
select  gender,  university ,count(id) as user_num,
round(avg(active_days_within_30),1) as avg_active_day,
round(avg(question_cnt),1)  as  avg_question_cnt
from user_profile1
group by  gender , university;
```



### 题目：接上题数据，查询山东大学的用户在不同难度下的平均答题题目数。

题目难度表question_detail答题明细表***\*question_practice_detail\****

![image-20211223133021512](SQL_EXAM.assets/image-20211223133021512.png)

![image-20211223133027574](SQL_EXAM.assets/image-20211223133027574.png)



结果示例

![image-20211223133007679](SQL_EXAM.assets/image-20211223133007679.png)

测试数据：

```sql
CREATE TABLE question_practice_detail (
id int NOT NULL,
device_id int NOT NULL,
question_id int NOT NULL,
result varchar(32) NOT NULL
);
CREATE TABLE question_detail (
id int NOT NULL,
question_id int NOT NULL,
difficult_level varchar(32) NOT NULL
);

INSERT INTO question_practice_detail VALUES(1,2138,111,'wrong');
INSERT INTO question_practice_detail VALUES(2,3214,112,'wrong');
INSERT INTO question_practice_detail VALUES(3,3214,113,'wrong');
INSERT INTO question_practice_detail VALUES(4,6543,111,'right');
INSERT INTO question_practice_detail VALUES(5,2315,115,'right');
INSERT INTO question_practice_detail VALUES(6,2315,116,'right');
INSERT INTO question_practice_detail VALUES(7,2315,117,'wrong');
INSERT INTO question_practice_detail VALUES(8,5432,117,'wrong');
INSERT INTO question_practice_detail VALUES(9,5432,112,'wrong');
INSERT INTO question_practice_detail VALUES(10,2131,113,'right');
INSERT INTO question_practice_detail VALUES(11,5432,113,'wrong');
INSERT INTO question_practice_detail VALUES(12,2315,115,'right');
INSERT INTO question_practice_detail VALUES(13,2315,116,'right');
INSERT INTO question_practice_detail VALUES(14,2315,117,'wrong');
INSERT INTO question_practice_detail VALUES(15,5432,117,'wrong');
INSERT INTO question_practice_detail VALUES(16,5432,112,'wrong');
INSERT INTO question_practice_detail VALUES(17,2131,113,'right');
INSERT INTO question_practice_detail VALUES(18,5432,113,'wrong');
INSERT INTO question_practice_detail VALUES(19,2315,117,'wrong');
INSERT INTO question_practice_detail VALUES(20,5432,117,'wrong');
INSERT INTO question_practice_detail VALUES(21,5432,112,'wrong');
INSERT INTO question_practice_detail VALUES(22,2131,113,'right');
INSERT INTO question_practice_detail VALUES(23,5432,113,'wrong');
INSERT INTO question_detail VALUES(1,111,'hard');
INSERT INTO question_detail VALUES(2,112,'medium');
INSERT INTO question_detail VALUES(3,113,'easy');
INSERT INTO question_detail VALUES(4,115,'easy');
INSERT INTO question_detail VALUES(5,116,'medium');
INSERT INTO question_detail VALUES(6,117,'easy');
commit;
```



```sql
--answer here 
select university,difficult_level,count(*)/count(distinct device_id) as avg_answer_cnt
from (
select t.university,t.device_id,t2.difficult_level
from   user_profile1  t  left  join  question_practice_detail  t1
on t.device_id=t1.device_id 
left  join question_detail t2
on t1.question_id =t2.question_id
where t.university='山东大学') t
group by university,difficult_level;
```



### 题目：接上题，现在想要了解复旦大学的每个用户在8月份练习的总题目数和回答正确的题目数情况，请取出相应明细数据，对于在8月份没有练习过的用户，答题数结果返回0。

答题明细表***\*question_practice_detail\****



![image-20211223133513858](SQL_EXAM.assets/image-20211223133513858.png)

结果示例

![image-20211223133527610](SQL_EXAM.assets/image-20211223133527610.png)

```sql
drop table question_practice_detail;
CREATE TABLE question_practice_detail (
id int NOT NULL,
device_id int NOT NULL,
question_id int NOT NULL,
result varchar(32) NOT NULL,
workdate varchar(10) NOT NULL
);

INSERT INTO question_practice_detail VALUES(1,2138,111,'wrong','2021-05-03');
INSERT INTO question_practice_detail VALUES(2,3214,112,'wrong','2021-05-09');
INSERT INTO question_practice_detail VALUES(3,3214,113,'wrong','2021-06-15');
INSERT INTO question_practice_detail VALUES(4,6543,111,'right','2021-08-13');
INSERT INTO question_practice_detail VALUES(5,2315,115,'right','2021-08-13');
INSERT INTO question_practice_detail VALUES(6,2315,116,'right','2021-08-14');
INSERT INTO question_practice_detail VALUES(7,2315,117,'wrong','2021-08-15');
INSERT INTO question_practice_detail VALUES(8,3214,112,'wrong','2021-05-09');
INSERT INTO question_practice_detail VALUES(9,3214,113,'wrong','2021-08-15');
INSERT INTO question_practice_detail VALUES(10,6543,111,'right','2021-08-13');
INSERT INTO question_practice_detail VALUES(11,2315,115,'right','2021-08-13');
INSERT INTO question_practice_detail VALUES(12,2315,116,'right','2021-08-14');
INSERT INTO question_practice_detail VALUES(13,2315,117,'wrong','2021-08-15');
INSERT INTO question_practice_detail VALUES(14,3214,112,'wrong','2021-08-16');
INSERT INTO question_practice_detail VALUES(15,3214,113,'wrong','2021-08-18');
INSERT INTO question_practice_detail VALUES(16,6543,111,'right','2021-08-13');
commit;

```



```sql
--your sql
select  u.university,u.device_id,count(t1.result) as question_cnt,
sum(case when t1.result='right' then 1 else 0 end ) as right_question_cnt
from  user_profile1  u  left  join(
select *
from(
select   device_id,result,question_id,
substr(workdate,7,1) as month
from 
question_practice_detail ) t 
where month='8')  t1
on u.device_id=t1.device_id
where u.university='复旦大学'
group by u.university,u.device_id;

```





### 题目：查询每个学校GPA最低的学生信息

用户信息表user_profile2

![image-20211223135854978](SQL_EXAM.assets/image-20211223135854978.png)

结果样例

![image-20211223135859576](SQL_EXAM.assets/image-20211223135859576.png)



```sql
--your sql
select university,device_id,round(gpa,3)
from(
select  university,device_id,gpa,
dense_rank()  over(partition by university order by gpa ) as rn
 from user_profile1) t 
where rn=1;
```



### 有一份数据status.csv，请建表将它导入到数据库中，假设要在web页面上作查询，客户要查询这些数据中2021年6月份的失败记录(通常status为0表示成功)，每页显示5条数据，请写出查询显示第301页数据的SQL。并截图显示你查询到的数据。按照事件发生的先后时间排序

```sql
--your sql
select *
from(
select *
from  status1
where substr(startdate,6,1)='6' and batchstatus<>0 
order by startdate starttime)t 
where rownum>1500 and rownum<1506;
应该是1506-1510这些记录

```

结果数据：

