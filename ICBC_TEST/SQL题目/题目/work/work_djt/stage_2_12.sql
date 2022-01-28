/*
查询同名同姓学生名单，并统计同名人数
*/
select sname, count(*)
from student
group by sname
having count(*)>1
