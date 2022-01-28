-- 查询同时选了" 机械制图"和" C语言 "的学生信息

-- Student：
-- cname - 机械制图, couseno - c06108
-- cname - C语言, couseno - c05109
-- Studentscore：
-- score - , couseno - c06108, studentno - 
-- score - , couseno - c05109, studentno - 
-- cname - C语言, couseno - c05109

-- 1.同一个学生的所有课程
-- join
-- 2.分别取出两门课的courseno
-- select courseno from course where cname = "C语言"
-- select courseno from course where cname = "机械制图"
-- 3.同时选两门课程courseno
select *
from student
where studentno in (select studentno
from Studentscore
where courseno = (select courseno from course where cname = '机械制图')
and studentno in (select studentno
from Studentscore
where courseno = (select courseno from course where cname = 'C语言')));



/* 

*/
