/*
��ѯûѡ" ���Ӽ��� "�γ̵�����" C���� "�γ̵�ѧ����Ϣ(ѧ����ţ���������ͬ)
*/
-- ѡ��" C���� "�γ̵�ѧ�����
select studentno
from studentscore
where courseno = (select courseno from course where cname = 'C����')
-- ѡ��" ���Ӽ��� "�γ̵�ѧ�����
select distinct a.studentno
from studentscore a, course b
where a.courseno = b.courseno
and b.courseno = (select courseno from course where cname = '���Ӽ���')
-- ûѡ" ���Ӽ��� "�γ̵�����" C���� "�γ̵�ѧ�����
select studentno, sname
from student
where studentno in (select studentno
from studentscore
where courseno = (select courseno from course where cname = 'C����'))
and studentno not in (select distinct a.studentno
from studentscore a, course b
where a.courseno = b.courseno
and b.courseno = (select courseno from course where cname = '���Ӽ���'));
