/*
��ѯƽ���ɼ����ڵ��� 85 ������ѧ����ѧ�š�������ƽ���ɼ�
*/
-- ��ѯ����ѧ����ѧ�ź�ƽ���ɼ�
select studentno, round(avg(score), 2) avg
from studentscore
group by studentno
-- ��ѯƽ���ɼ����ڵ��� 85 ������ѧ����ѧ�š�������ƽ���ɼ�
select a.studentno, b.sname, a.avg
from (select studentno, round(avg(score), 2) avg
from studentscore
group by studentno) a, student b
where a.studentno = b.studentno
and a.avg >= '85'
