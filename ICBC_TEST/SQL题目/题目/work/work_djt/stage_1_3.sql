/*
��ѯѡ��" C���� "������ûѡ" ���Ӽ��� "��ѧ����Ϣ���γ̷�����
��ʾ���£�
ѧ����ţ�������c���Կγ̱�ţ�c���Գɼ������Ӽ����γ̱�ţ����Ӽ����ɼ�
*/

select a.studentno, a.sname, b.courseno, b.score
from student a join studentscore b on a.studentno = b.studentno
where b.studentno in (select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C����'))

-- ѡ��C���Ե�ѧ����ź�C���Կγ���Ϣ
select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C����')
-- ѡ��C���Ե�ѧ����Ϣ��C���Կγ���Ϣ
select a.studentno, a.sname, b.courseno, b.score
from student a join (select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C����')) b on a.studentno = b.studentno
-- ѡ�˵��Ӽ�����ѧ����ź͵��Ӽ����γ���Ϣ
select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = '���Ӽ���')
-- ѡ��C���Ե�ѧ����Ϣ��C���Կγ���Ϣ�͵��Ӽ����γ���Ϣ
select c.*, d.courseno, d.score
  from (select a.studentno, a.sname, b.courseno, b.score
          from student a
          join (select studentno, courseno, score
                 from studentscore
                where courseno =
                      (select courseno from course where cname = 'C����')) b
            on a.studentno = b.studentno) c
  left join (select studentno, courseno, score
               from studentscore
              where courseno =
                    (select courseno from course where cname = '���Ӽ���')) d
    on c.studentno = d.studentno
 order by c.studentno;
