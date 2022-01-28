create database if not exists mydb0;
use mydb0;
alter database mydb0 character set utf8;
create table if not exists course
(
  cno     VARCHAR(10),
  cname VARCHAR(30),
  cpno  VARCHAR(10),
  ccredit    VARCHAR(60)
);
desc course;
insert into course
values ('1', '数据库', '5', '4');
insert into course
values ('2', '数学', null, '2');
insert into course
values ('3', '信息系统', '1', '4');
insert into course
values ('4', '操作系统', '6', '3');
insert into course
values ('5', '数据结构', '7', '4');
insert into course
values ('6', '数据处理', null, '2');
insert into course
values ('7', 'pascal语言', '6', '4');
select * from course;