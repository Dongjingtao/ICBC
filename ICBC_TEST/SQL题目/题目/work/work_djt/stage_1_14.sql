/*
查询两门及其以上低于80分的同学的学号，姓名及其平均成绩
*/
-- 查询两门及其以上低于80分的同学的学号
select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2
-- 查询两门及其以上低于80分的同学的学号，姓名
select a.studentno, a.sname 
from student a join (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2) b on a.studentno = b.studentno
-- 查询两门及其以上低于80分的同学的学号对应的平均成绩
select studentno, round(avg(score), 2) avg
from studentscore
where studentno in (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2)
group by studentno
-- 联合两张表
select a.studentno, a.sname, b.avg
from (select a.studentno, a.sname 
from student a join (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2) b on a.studentno = b.studentno) a join (select studentno, round(avg(score), 2) avg
from studentscore
where studentno in (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2)
group by studentno) b on a.studentno = b.studentno;

