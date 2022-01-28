/*
查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
*/
-- 查询所有学生的学号和平均成绩
select studentno, round(avg(score), 2) avg
from studentscore
group by studentno
-- 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
select a.studentno, b.sname, a.avg
from (select studentno, round(avg(score), 2) avg
from studentscore
group by studentno) a, student b
where a.studentno = b.studentno
and a.avg >= '85'
