/*
��ѯÿ�ſγ̵�ƽ���ɼ��������ƽ���ɼ��������У�ƽ���ɼ���ͬʱ�����γ̱����������
*/
select courseno, round(avg(score), 2) avg
from studentscore
group by courseno
order by avg desc,courseno
