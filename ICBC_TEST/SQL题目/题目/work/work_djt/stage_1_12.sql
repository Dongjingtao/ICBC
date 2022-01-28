/*
查询和学号" 922221324 "同学学习的课程完全相同的其他同学的信息 
*/
-- 学号" 922221324 "同学所学的课
select courseno
from studentscore
where studentno = '922221324'
-- 学号" 922221324 "同学所学的课的数量
select count(courseno)
from studentscore
where studentno = '922221324'
-- 选了学号" 922221324 "同学所学的课之外课的学生
select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324')
-- 去除 选了学号" 922221324 "同学所学的课之外课的学生
select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
-- 去除 选了学号" 922221324 "同学所学的课之外课的学生 , 并且除去本人，count所选课程数量,返回学生学号
select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
and studentno <> '922221324'
group by studentno
having count(*) = (select count(courseno)
from studentscore
where studentno = '922221324')
-- 根据学生学号返回学生信息
select *
from student
where studentno in (select studentno
from studentscore
where studentno not in (select distinct studentno
from studentscore
where courseno not in (select courseno
from studentscore
where studentno = '922221324'))
and studentno <> '922221324'
group by studentno
having count(*) = (select count(*)
from (select courseno
from studentscore
where studentno = '922221324')))
