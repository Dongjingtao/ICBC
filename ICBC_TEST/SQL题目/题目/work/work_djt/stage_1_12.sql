/*
��ѯ��ѧ��" 922221324 "ͬѧѧϰ�Ŀγ���ȫ��ͬ������ͬѧ����Ϣ 
*/
-- ѧ��" 922221324 "ͬѧ��ѧ�Ŀ�
select courseno
from studentscore
where studentno = '922221324'
-- ѧ��" 922221324 "ͬѧ��ѧ�Ŀε�����
select count(courseno)
from studentscore
where studentno = '922221324'
-- ѡ��ѧ��" 922221324 "ͬѧ��ѧ�Ŀ�֮��ε�ѧ��
select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324')
-- ȥ�� ѡ��ѧ��" 922221324 "ͬѧ��ѧ�Ŀ�֮��ε�ѧ��
select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
-- ȥ�� ѡ��ѧ��" 922221324 "ͬѧ��ѧ�Ŀ�֮��ε�ѧ�� , ���ҳ�ȥ���ˣ�count��ѡ�γ�����,����ѧ��ѧ��
select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
and studentno <> '922221324'
group by studentno
having count(*) = (select count(courseno)
from studentscore
where studentno = '922221324')
-- ����ѧ��ѧ�ŷ���ѧ����Ϣ
select *
from student
where studentno in (select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
and studentno <> '922221324'
group by studentno
having count(*) = (select count(*)
from (select courseno
from studentscore
where studentno = '922221324')))
