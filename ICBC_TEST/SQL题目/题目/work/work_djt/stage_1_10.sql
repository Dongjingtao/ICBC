/*
查询获得少于3门课程成绩的学生信息
*/
select studentno, sname
  from student
 where studentno in (select studentno
                       from studentscore
                      group by studentno
                     having count(*) < 3);


/* 方法2
select a.*
from student a left join (select studentno
from studentscore
group by studentno
having count(*)<3) b on a.studentno = b.studentno;
*/



