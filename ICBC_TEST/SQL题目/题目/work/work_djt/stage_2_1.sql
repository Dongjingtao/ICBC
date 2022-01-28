/*
按学生平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(学生编号、课程编号、课程成绩，平均成绩)
*/
-- 学生平均成绩从高到低
select studentno, round(avg(score), 2) avg
from studentscore
group by studentno
-- 按学生平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(学生编号、课程编号、课程成绩，平均成绩)
select a.studentno, b.courseno, b.score, a.avg
from (select studentno, round(avg(score), 2) avg
from studentscore
group by studentno) a left join studentscore b on a.studentno = b.studentno
order by a.avg desc
