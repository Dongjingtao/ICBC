/*
��ѯ��ֻѡ�����ſγ̵�ѧ��ѧ�ź�����
*/

select studentno, sname
from student
where studentno in (select studentno
from studentscore
group by studentno
having count(*) = 2)
