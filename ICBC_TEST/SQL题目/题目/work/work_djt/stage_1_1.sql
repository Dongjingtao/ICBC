/*
-- ��ѯ" ��е��ͼ"��" C���� "�ɼ��ߵ�ѧ������Ϣ���γ̷���

-- Student��
-- cname - ��е��ͼ, couseno - c06108
-- cname - C����, couseno - c05109
-- Studentscore��
-- score - , couseno - c06108, studentno - 
-- score - , couseno - c05109, studentno - 
-- cname - C����, couseno - c05109

-- �Ƚ�ͬһ��ѧ����" ��е��ͼ"��" C���� "�ɼ���������ڣ�����ѧ����Ϣ
-- 1.ͬһ��ѧ�������пγ̺ͷ�����Ϣ
-- join���ű�on������ȣ������е����ֵ��Ϊ�����У��������ű����������Ϣ
-- 2.�ֱ�ȡ�����ſε�courseno
-- select courseno from course where cname = "C����"
-- select courseno from course where cname = "��е��ͼ"
-- 3.�Ƚ����ſγ�courseno�ĳɼ�
-- 
*/

select *
from (select * 
from student s
where s.studentno in( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '��е��ͼ')
                      and b.courseno = (select courseno from course where cname = 'C����')
                      and a.score > b.score
);

-- ����1
select *
from (select *
from student s 
where s.studentno in ( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '��е��ͼ')
                      and b.courseno = (select courseno from course where cname = 'C����')
                      and a.score > b.score
)) aa join studentscore bb on aa.studentno = bb.studentno join studentscore cc on aa.studentno = cc.studentno 
and bb.courseno = (select courseno from course where cname = '��е��ͼ') 
and cc.courseno = (select courseno from course where cname = 'C����');


/*
select *
from student s 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '��е��ͼ')
                      and b.courseno = (select courseno from course where cname = 'C����')
                      and a.score > b.score
)

select aa.*,bb.score,cc.score
from (select *
from student s 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '��е��ͼ')
                      and b.courseno = (select courseno from course where cname = 'C����')
                      and a.score > b.score
)) aa inner join studentscore bb on aa.studentno = bb.studentno inner join studentscore cc on aa.studentno = cc.studentno
and bb.courseno = (select courseno from course where cname = '��е��ͼ')
and cc.courseno = (select courseno from course where cname = 'C����')


select distinct s.*, sc1.courseno,sc1.score, sc2.courseno,sc2.score
select distinct *
from (student s left join studentscore sc1 on s.studentno = sc1.studentno )left join studentscore sc2 on sc1.studentno = sc2.studentno 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '��е��ͼ')
                      and b.courseno = (select courseno from course where cname = 'C����')
                      and a.score > b.score
)
group by s.studentno;
*/

/*����2
select a.studentno,a.courseno,a.score,b.courseno,b.score,c.sname,c.SEX,c.BIRTHDAY,c.CLASSNO,c.PHONE,c.EMAIL
from Studentscore a join Studentscore b on a.studentno = b.studentno, student c
where a.courseno = (select courseno from course where cname = '��е��ͼ')
and b.courseno = (select courseno from course where cname = 'C����')
and a.score > b.score
and a.studentno = c.studentno;
*/

/* ����3
select a.studentno, a.courseno, a.score, b.courseno, b.score, c.sname,c.SEX,c.BIRTHDAY,c.CLASSNO,c.PHONE,c.EMAIL
from Studentscore a join Studentscore b on a.studentno = b.studentno join student c on a.studentno = c.studentno
where a.courseno = (select courseno from course where cname = '��е��ͼ')
and b.courseno = (select courseno from course where cname = 'C����')
and a.score > b.score ;
-- Сд��lower
-- ��д��upper
-- �ֶεı������ֶ�+�ո�+����
-- �ֶ��������ظ��У�distinct+��Ӧ�ֶ�
-- ???�������������ֶ���������create uinique index �ֶ��� on ����(�ֶ���1 asc, �ֶ���2 desc) 
*/


