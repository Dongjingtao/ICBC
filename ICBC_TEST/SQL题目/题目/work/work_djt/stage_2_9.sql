/*
查询出只选修两门课程的学生学号和姓名
*/

select studentno, sname
from student
where studentno in (select studentno
from studentscore
group by studentno
having count(*) = 2)
