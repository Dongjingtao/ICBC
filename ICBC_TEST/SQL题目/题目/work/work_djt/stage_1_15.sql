/*
����"c05103"�γ̷���С�� 90���������������е�ѧ����Ϣ(��š�����������)
*/
-- ����"c05103"�γ̷���С�� 90
select *
from studentscore
where courseno = 'c05103'
-- ����"c05103"�γ̷���С�� 90���������������е�ѧ����Ϣ(��š�����������)
select a.studentno, a.sname, b.score
from student a join (select *
from studentscore
where courseno = 'c05103'
) b on a.studentno = b.studentno
order by b.score desc
