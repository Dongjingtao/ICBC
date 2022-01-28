/*
查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )
*/
-- 查询所有同学的学生编号、选课总数、所有课程的总成绩
select studentno, count(courseno) 选课总数, sum(score) 总成绩
from studentscore
group by studentno
-- 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
select a.studentno, a.sname, b.选课总数, b.总成绩
from student a left outer join (select studentno, count(courseno) 选课总数, sum(score) 总成绩
from studentscore
group by studentno) b on a.studentno = b.studentno






