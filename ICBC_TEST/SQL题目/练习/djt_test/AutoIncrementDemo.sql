use mydb1;
create table if not exists emp3(
	eid int primary key auto_increment,
    name varchar(20)
);
alter table emp3 change name name varchar(10) character set utf8;
insert into emp3(eid,name)
			values (101,'董京涛');
insert into emp3(name)
			values ('董京涛');