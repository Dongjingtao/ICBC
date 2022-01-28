/*
查询平均成绩大于等于80分的同学的学生编号、学生姓名和平均成绩(成绩保留2位小数，下同) 
*/
-- 查询平均成绩大于等于80分的同学的学生编号
select studentno, round(avg(score), 2) avgscore
from studentscore
group by studentno
having avg(score) > 80;
-- 查询平均成绩大于等于80分的同学的学生编号、学生姓名和平均成绩
select a.studentno, a.sname, b.avgscore
from student a, (select studentno, round(avg(score), 2) avgscore
from studentscore
group by studentno
having avg(score) > 80) b
where a.studentno = b.studentno;


