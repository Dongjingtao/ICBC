/*
-- 查询" 机械制图"比" C语言 "成绩高的学生的信息及课程分数

-- Student：
-- cname - 机械制图, couseno - c06108
-- cname - C语言, couseno - c05109
-- Studentscore：
-- score - , couseno - c06108, studentno - 
-- score - , couseno - c05109, studentno - 
-- cname - C语言, couseno - c05109

-- 比较同一个学生的" 机械制图"比" C语言 "成绩，如果大于，返回学生信息
-- 1.同一个学生的所有课程和分数信息
-- join两张表on两列相等：以两列的相等值作为连续行，返回两张表的所有列信息
-- 2.分别取出两门课的courseno
-- select courseno from course where cname = "C语言"
-- select courseno from course where cname = "机械制图"
-- 3.比较两门课程courseno的成绩
-- 
*/

select *
from (select * 
from student s
where s.studentno in( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '机械制图')
                      and b.courseno = (select courseno from course where cname = 'C语言')
                      and a.score > b.score
);

-- 方法1
select *
from (select *
from student s 
where s.studentno in ( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '机械制图')
                      and b.courseno = (select courseno from course where cname = 'C语言')
                      and a.score > b.score
)) aa join studentscore bb on aa.studentno = bb.studentno join studentscore cc on aa.studentno = cc.studentno 
and bb.courseno = (select courseno from course where cname = '机械制图') 
and cc.courseno = (select courseno from course where cname = 'C语言');


/*
select *
from student s 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '机械制图')
                      and b.courseno = (select courseno from course where cname = 'C语言')
                      and a.score > b.score
)

select aa.*,bb.score,cc.score
from (select *
from student s 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '机械制图')
                      and b.courseno = (select courseno from course where cname = 'C语言')
                      and a.score > b.score
)) aa inner join studentscore bb on aa.studentno = bb.studentno inner join studentscore cc on aa.studentno = cc.studentno
and bb.courseno = (select courseno from course where cname = '机械制图')
and cc.courseno = (select courseno from course where cname = 'C语言')


select distinct s.*, sc1.courseno,sc1.score, sc2.courseno,sc2.score
select distinct *
from (student s left join studentscore sc1 on s.studentno = sc1.studentno )left join studentscore sc2 on sc1.studentno = sc2.studentno 
where s.studentno = any( select a.studentno
                      from Studentscore a join Studentscore b on a.studentno = b.studentno 
                      where a.courseno = (select courseno from course where cname = '机械制图')
                      and b.courseno = (select courseno from course where cname = 'C语言')
                      and a.score > b.score
)
group by s.studentno;
*/

/*方法2
select a.studentno,a.courseno,a.score,b.courseno,b.score,c.sname,c.SEX,c.BIRTHDAY,c.CLASSNO,c.PHONE,c.EMAIL
from Studentscore a join Studentscore b on a.studentno = b.studentno, student c
where a.courseno = (select courseno from course where cname = '机械制图')
and b.courseno = (select courseno from course where cname = 'C语言')
and a.score > b.score
and a.studentno = c.studentno;
*/

/* 方法3
select a.studentno, a.courseno, a.score, b.courseno, b.score, c.sname,c.SEX,c.BIRTHDAY,c.CLASSNO,c.PHONE,c.EMAIL
from Studentscore a join Studentscore b on a.studentno = b.studentno join student c on a.studentno = c.studentno
where a.courseno = (select courseno from course where cname = '机械制图')
and b.courseno = (select courseno from course where cname = 'C语言')
and a.score > b.score ;
-- 小写：lower
-- 大写：upper
-- 字段的别名：字段+空格+别名
-- 字段中消除重复行：distinct+对应字段
-- ???建立索引：对字段内容排序，create uinique index 字段名 on 表名(字段名1 asc, 字段名2 desc) 
*/


