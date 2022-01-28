/*
检索"c05103"课程分数小于 90，按分数降序排列的学生信息(编号、姓名，分数)
*/
-- 检索"c05103"课程分数小于 90
select *
from studentscore
where courseno = 'c05103'
-- 检索"c05103"课程分数小于 90，按分数降序排列的学生信息(编号、姓名，分数)
select a.studentno, a.sname, b.score
from student a join (select *
from studentscore
where courseno = 'c05103'
) b on a.studentno = b.studentno
order by b.score desc
