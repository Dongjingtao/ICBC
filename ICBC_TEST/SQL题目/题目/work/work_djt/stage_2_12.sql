/*
��ѯͬ��ͬ��ѧ����������ͳ��ͬ������
*/
select sname, count(*)
from student
group by sname
having count(*)>1
