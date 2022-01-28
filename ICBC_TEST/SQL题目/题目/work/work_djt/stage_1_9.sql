/*
查询班级课程表有「刘元朝」老师课程的同学编号和姓名
*/
-- 刘元朝」老师的teacherno
select teacherno
from teacher
where tname = '刘元朝';
-- 查询班级课程表刘元朝」老师的teacherno的courseno
select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '刘元朝');
-- 查询班级课程表有「刘元朝」老师课程的同学编号
select studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '刘元朝'));
-- 查询班级课程表有「刘元朝」老师课程的同学编号和姓名
select studentno, sname
from student
where studentno in (select studentno
from studentscore
where courseno in (select courseno
from classcourse
where teacherno in (select teacherno
from teacher
where tname = '刘元朝')));
