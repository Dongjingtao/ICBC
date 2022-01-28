/*
查询男生、女生人数
*/
select sex, count(*)
from student
group by sex
