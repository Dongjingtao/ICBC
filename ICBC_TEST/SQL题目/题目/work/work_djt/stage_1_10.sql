/*
��ѯ�������3�ſγ̳ɼ���ѧ����Ϣ
*/
select studentno, sname
  from student
 where studentno in (select studentno
                       from studentscore
                      group by studentno
                     having count(*) < 3);


/* ����2
select a.*
from student a left join (select studentno
from studentscore
group by studentno
having count(*)<3) b on a.studentno = b.studentno;
*/



