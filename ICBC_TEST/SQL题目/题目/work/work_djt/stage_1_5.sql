/*
��ѯƽ���ɼ����ڵ���80�ֵ�ͬѧ��ѧ����š�ѧ��������ƽ���ɼ�(�ɼ�����2λС������ͬ) 
*/
-- ��ѯƽ���ɼ����ڵ���80�ֵ�ͬѧ��ѧ�����
select studentno, round(avg(score), 2) avgscore
from studentscore
group by studentno
having avg(score) > 80;
-- ��ѯƽ���ɼ����ڵ���80�ֵ�ͬѧ��ѧ����š�ѧ��������ƽ���ɼ�
select a.studentno, a.sname, b.avgscore
from student a, (select studentno, round(avg(score), 2) avgscore
from studentscore
group by studentno
having avg(score) > 80) b
where a.studentno = b.studentno;


