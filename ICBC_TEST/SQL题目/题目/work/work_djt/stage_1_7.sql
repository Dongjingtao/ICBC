/*
��ѯ����ͬѧ��ѧ����š�ѧ��������ѡ�����������пγ̵��ܳɼ�(û�ɼ�����ʾΪ null )
*/
-- ��ѯ����ͬѧ��ѧ����š�ѡ�����������пγ̵��ܳɼ�
select studentno, count(courseno) ѡ������, sum(score) �ܳɼ�
from studentscore
group by studentno
-- ��ѯ����ͬѧ��ѧ����š�ѧ��������ѡ�����������пγ̵��ܳɼ�
select a.studentno, a.sname, b.ѡ������, b.�ܳɼ�
from student a left outer join (select studentno, count(courseno) ѡ������, sum(score) �ܳɼ�
from studentscore
group by studentno) b on a.studentno = b.studentno






