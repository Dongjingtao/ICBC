/*
��ѯ�ڿγ̳ɼ�����ڳɼ���ѧ����Ϣ
*/
-- ��ѯ�ڿγ̳ɼ�����ڳɼ���ѧ�����
select studentno
from studentscore
group by studentno
having count(score)!=0;
-- ��ѯ�ڿγ̳ɼ�����ڳɼ���ѧ����Ϣ
select studentno,sname
from student
where studentno in (select studentno
from studentscore
group by studentno
having count(score)!=0);
