/*
��ѯ������һ�ſ���ѧ��" 922221324 "ͬѧ��ѧ��ͬ��ѧ����Ϣ
*/
-- ѧ��" 922221324 "ͬѧ��ѧ�Ŀ�
select courseno
from studentscore
where studentno = '922221324';

-- ������һ�ſ���ѧ��" 922221324 "ͬѧ��ѧ��ͬ��ѧ�����
select distinct studentno
from studentscore
where courseno in (select courseno
from studentscore
where studentno = '922221324');

-- ��ѯ������һ�ſ���ѧ��" 922221324 "ͬѧ��ѧ��ͬ��ѧ����Ϣ
select studentno, sname
from student
where studentno in (select distinct studentno
from studentscore
where courseno in (select courseno
from studentscore
where studentno = '922221324'));

