/*
��ѯûѧ��"������"��ʦ���ڵ���һ�ſγ̵�ѧ����ź�����
*/
-- "������"��ʦ��no
select teacherno
from teacher
where tname = '������'
-- "������"��ʦ���ڵ����пγ� c05109  c05127
select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '������')
-- ��ѯѧ��"������"��ʦ���ڵ���һ�ſγ̵�ѧ�����
select distinct studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '������'))
-- ��ѯûѧ��"������"��ʦ���ڵ���һ�ſγ̵�ѧ�����
select distinct studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '������')))
-- ��ѯûѧ��"������"��ʦ���ڵ���һ�ſγ̵�ѧ����ź�����
select studentno, sname
from student
where studentno in (select distinct studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '������'))))

/* zyq
select studentno, sname
  from student
 where studentno not in
       (select studentno
          from studentscore
         where courseno in (select c.courseno
                              from classcourse c
                              left outer join teacher d
                                on c.teacherno = d.teacherno
                             where d.tname = '������'));
*/




