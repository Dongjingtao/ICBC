/*
��ѯ���ż������ϵ���80�ֵ�ͬѧ��ѧ�ţ���������ƽ���ɼ�
*/
-- ��ѯ���ż������ϵ���80�ֵ�ͬѧ��ѧ��
select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2
-- ��ѯ���ż������ϵ���80�ֵ�ͬѧ��ѧ�ţ�����
select a.studentno, a.sname 
from student a join (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2) b on a.studentno = b.studentno
-- ��ѯ���ż������ϵ���80�ֵ�ͬѧ��ѧ�Ŷ�Ӧ��ƽ���ɼ�
select studentno, round(avg(score), 2) avg
from studentscore
where studentno in (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2)
group by studentno
-- �������ű�
select a.studentno, a.sname, b.avg
from (select a.studentno, a.sname 
from student a join (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2) b on a.studentno = b.studentno) a join (select studentno, round(avg(score), 2) avg
from studentscore
where studentno in (select studentno
from studentscore
where score < '80'
group by studentno
having count(*) >=2)
group by studentno) b on a.studentno = b.studentno;

