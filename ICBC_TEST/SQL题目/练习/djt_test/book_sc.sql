create database if not exists mydb0;
use mydb0;
alter database mydb0 character set utf8;
create table if not exists sc
(
  sno     VARCHAR(10),
  cno VARCHAR(30),
  grade  VARCHAR(10)
);
desc sc;
insert into sc
values ('201215121', '1', '92');
insert into sc
values ('201215121', '2', '85');
insert into sc
values ('201215121', '3', '88');
insert into sc
values ('201215122', '2', '90');
insert into sc
values ('201215122', '3', '80');
select * from sc;