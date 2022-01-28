create database if not exists mydb0;
use mydb0;
alter database mydb0 character set utf8;
create table if not exists student
(
  sno     VARCHAR(10),
  sname VARCHAR(30),
  ssex  VARCHAR(10),
  sage    VARCHAR(60),
  sdept  VARCHAR(10)
);
desc student;
insert into student ( sno,sname,ssex,sage,sdept)
values ('201215121', '李勇', '男', '20', 'cs');
insert into student 
values ('201215122', '刘晨', '女', '19', 'cs');
insert into student 
values ('201215123', '王敏', '女', '18', 'ma');
insert into student 
values ('201215124', '张立', '男', '19', 'is');
select * from student;