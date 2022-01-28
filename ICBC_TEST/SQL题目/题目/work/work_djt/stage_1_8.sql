/*
查询「刘」姓老师的数量 
*/
select count(tname)
from teacher
where tname like '刘%';
