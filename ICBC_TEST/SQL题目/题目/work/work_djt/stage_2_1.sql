/*
��ѧ��ƽ���ɼ��Ӹߵ�����ʾ����ѧ�������пγ̵ĳɼ��Լ�ƽ���ɼ�(ѧ����š��γ̱�š��γ̳ɼ���ƽ���ɼ�)
*/
-- ѧ��ƽ���ɼ��Ӹߵ���
select studentno, round(avg(score), 2) avg
from studentscore
group by studentno
-- ��ѧ��ƽ���ɼ��Ӹߵ�����ʾ����ѧ�������пγ̵ĳɼ��Լ�ƽ���ɼ�(ѧ����š��γ̱�š��γ̳ɼ���ƽ���ɼ�)
select a.studentno, b.courseno, b.score, a.avg
from (select studentno, round(avg(score), 2) avg
from studentscore
group by studentno) a left join studentscore b on a.studentno = b.studentno
order by a.avg desc
