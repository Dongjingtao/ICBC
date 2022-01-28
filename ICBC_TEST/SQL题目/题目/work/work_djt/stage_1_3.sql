/*
查询选了" C语言 "但可能没选" 电子技术 "的学生信息及课程分数，
显示如下：
学生编号，姓名，c语言课程编号，c语言成绩，电子技术课程编号，电子技术成绩
*/

select a.studentno, a.sname, b.courseno, b.score
from student a join studentscore b on a.studentno = b.studentno
where b.studentno in (select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C语言'))

-- 选了C语言的学生编号和C语言课程信息
select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C语言')
-- 选了C语言的学生信息和C语言课程信息
select a.studentno, a.sname, b.courseno, b.score
from student a join (select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = 'C语言')) b on a.studentno = b.studentno
-- 选了电子技术的学生编号和电子技术课程信息
select studentno, courseno, score
from studentscore
where courseno = (select courseno from course where cname = '电子技术')
-- 选了C语言的学生信息和C语言课程信息和电子技术课程信息
select c.*, d.courseno, d.score
  from (select a.studentno, a.sname, b.courseno, b.score
          from student a
          join (select studentno, courseno, score
                 from studentscore
                where courseno =
                      (select courseno from course where cname = 'C语言')) b
            on a.studentno = b.studentno) c
  left join (select studentno, courseno, score
               from studentscore
              where courseno =
                    (select courseno from course where cname = '电子技术')) d
    on c.studentno = d.studentno
 order by c.studentno;
