/*
查询至少有一门课与学号" 922221324 "同学所学相同的学生信息
*/
-- 学号" 922221324 "同学所学的课
select courseno
from studentscore
where studentno = '922221324';

-- 至少有一门课与学号" 922221324 "同学所学相同的学生编号
select distinct studentno
from studentscore
where courseno in (select courseno
from studentscore
where studentno = '922221324');

-- 查询至少有一门课与学号" 922221324 "同学所学相同的学生信息
select studentno, sname
from student
where studentno in (select distinct studentno
from studentscore
where courseno in (select courseno
from studentscore
where studentno = '922221324'));

