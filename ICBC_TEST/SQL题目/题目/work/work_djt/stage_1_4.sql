/*
查询没选" 电子技术 "课程但存在" C语言 "课程的学生信息(学生编号，姓名，下同)
*/
-- 选了" C语言 "课程的学生编号
select studentno
from studentscore
where courseno = (select courseno from course where cname = 'C语言')
-- 选了" 电子技术 "课程的学生编号
select distinct a.studentno
from studentscore a, course b
where a.courseno = b.courseno
and b.courseno = (select courseno from course where cname = '电子技术')
-- 没选" 电子技术 "课程但存在" C语言 "课程的学生编号
select studentno, sname
from student
where studentno in (select studentno
from studentscore
where courseno = (select courseno from course where cname = 'C语言'))
and studentno not in (select distinct a.studentno
from studentscore a, course b
where a.courseno = b.courseno
and b.courseno = (select courseno from course where cname = '电子技术'));
