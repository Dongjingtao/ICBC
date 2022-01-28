/*
查询每门课程被选修的学生数 
*/
select courseno, count(*)
from studentscore
group by courseno
