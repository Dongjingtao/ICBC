/*
查询没学过"韩晋升"老师讲授的任一门课程的学生编号和姓名
*/
-- "韩晋升"老师的no
select teacherno
from teacher
where tname = '韩晋升'
-- "韩晋升"老师讲授的所有课程 c05109  c05127
select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '韩晋升')
-- 查询学过"韩晋升"老师讲授的任一门课程的学生编号
select distinct studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '韩晋升'))
-- 查询没学过"韩晋升"老师讲授的任一门课程的学生编号
select distinct studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno = (select teacherno
from teacher
where tname = '韩晋升')))
-- 查询没学过"韩晋升"老师讲授的任一门课程的学生编号和姓名
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
where tname = '韩晋升'))))

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
                             where d.tname = '韩晋升'));
*/




