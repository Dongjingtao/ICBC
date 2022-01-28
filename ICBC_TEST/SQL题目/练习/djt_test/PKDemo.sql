use mydb1;
create table if not exists emp1(
	eid int primary key,
    name varchar(20),
    deptId int,
    salary double 
);
create table if not exists emp2(
	eid int ,
    name varchar(20),
    deptId int,
    salary double,
    primary key(eid)
);
alter table emp2 drop primary key;