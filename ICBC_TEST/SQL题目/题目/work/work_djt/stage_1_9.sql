/*
��ѯ�༶�γ̱��С���Ԫ������ʦ�γ̵�ͬѧ��ź�����
*/
-- ��Ԫ������ʦ��teacherno
select teacherno
from teacher
where tname = '��Ԫ��';
-- ��ѯ�༶�γ̱���Ԫ������ʦ��teacherno��courseno
select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '��Ԫ��');
-- ��ѯ�༶�γ̱��С���Ԫ������ʦ�γ̵�ͬѧ���
select studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '��Ԫ��'));
-- ��ѯ�༶�γ̱��С���Ԫ������ʦ�γ̵�ͬѧ��ź�����
select studentno, sname
from student
where studentno in (select studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '��Ԫ��')));
