-- ��ѯͬʱѡ��" ��е��ͼ"��" C���� "��ѧ����Ϣ

-- Student��
-- cname - ��е��ͼ, couseno - c06108
-- cname - C����, couseno - c05109
-- Studentscore��
-- score - , couseno - c06108, studentno - 
-- score - , couseno - c05109, studentno - 
-- cname - C����, couseno - c05109

-- 1.ͬһ��ѧ�������пγ�
-- join
-- 2.�ֱ�ȡ�����ſε�courseno
-- select courseno from course where cname = "C����"
-- select courseno from course where cname = "��е��ͼ"
-- 3.ͬʱѡ���ſγ�courseno
select *
from student
where studentno in (select studentno
from Studentscore
where courseno = (select courseno from course where cname = '��е��ͼ')
and studentno in (select studentno
from Studentscore
where courseno = (select courseno from course where cname = 'C����')));



/* 

*/
