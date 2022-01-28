-- DDL操作
-- 查看所有数据库
show databases;
-- 创建数据库
create database if not exists mydb1;
-- 选择使用哪一个数据库
use mydb1;
-- 删除数据库
drop database if exists mydb1;

-- 修改数据库编码
alter database mydb1 character set utf8;

-- 创建表
-- 1、选择使用哪一个数据库
use mydb1;
-- 2、创建表
create table if not exists student(
	sid int,
    name varchar(20),
    gender varchar(10),
    age int,
    birth date,
    address varchar(20),
    score double
);

-- 3、查看当前数据库所有的表
show tables;

-- 4、查看指定表的创建语句
show create table student;

-- 5、查看表结构
desc student;

-- 6、删除表
drop table student;

-- 修改表结构
-- 1、添加列：alter table 表名 add 列名 类型(长度) [约束];
alter table student add dept varchar(20);

-- 2、修改列名和类型：alter table 表名 change 旧列名 新列名 类型(长度) [约束];
alter table student change dept department varchar(30);

-- 3、删除列：alter table 表名 drop department;
alter table student drop department;

-- 4、修改表名：rename table 表名 to 新表名;
-- rename table student to stu;
rename table stu to student;

-- DML操作
-- 1、数据插入
-- 格式1：insert into 表(列名1,列名2……) values (值1,值2……);
-- 格式2：insert into 表 values (值1,值2……);
insert into student(sid,name)
			values (101,'djt'),
				   (102,'jyz');
                   
-- 2、数据修改
-- 格式：update 表名 set 字段名=值, 字段名=值, …… where 条件;
-- set sql_safe_updates=0; 
-- alter table student character set utf8;
-- alter table student change address address varchar(10) character set utf8;
update student set address="上海" where sid=101;

                   
-- 3、数据删除
-- 格式1：delete from 表名 [where 条件];
-- 格式2：truncate 表名;
delete from student where sid > 101;


