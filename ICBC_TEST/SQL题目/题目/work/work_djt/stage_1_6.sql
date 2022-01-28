/*
查询在课程成绩表存在成绩的学生信息
*/
-- 查询在课程成绩表存在成绩的学生编号
select studentno
from studentscore
group by studentno
having count(score)!=0;
-- 查询在课程成绩表存在成绩的学生信息
select studentno,sname
from student
where studentno in (select studentno
from studentscore
group by studentno
having count(score)!=0);
