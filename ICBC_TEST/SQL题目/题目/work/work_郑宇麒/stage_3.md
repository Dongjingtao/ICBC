# SQL_STAGE_3



##  查询课程名称为「C语言」，且分数低于 80 的学生姓名和分数 

```sql
select c.sname, a.score
  from student_grade a
  left outer join course b on a.courseno = b.courseno
  left outer join student c on a.studentno = c.studentno
 where b.cname = 'C语言'
   and a.score < 80;
```



## 查询所有学生的课程及分数情况（包括班级课表学生没选课没成绩的情况），显示学生编号，学生姓名，课程编号，课程名，成绩（可为空），按学生编号排序

```sql
select a.studentno, c.sname, a.courseno, d.cname, nvl(b.score,0)
  from ((select studentno, courseno from student_grade) union
        (select studentno, courseno
           from schedule a
           left outer join student b on a.classno = b.classno)) a
  left outer join student_grade b on (a.studentno = b.studentno and
                                     a.courseno = b.courseno)
  left outer join student c on a.studentno = c.studentno
  left outer join course d on a.courseno = d.courseno
 order by a.studentno
```

## 查询选修「韩晋升」老师所授课程的学生中，成绩排名第2的学生信息及其成绩

```sql
select d.sname, a.score
  from (select courseno,
               studentno,
               score,
               rank() over(partition by courseno order by score desc) as ranking
          from student_grade) a
  left outer join schedule b on a.courseno = b.courseno
  left outer join teacher c on c.teacherno = b.teacherno
  left outer join student d on d.studentno = a.studentno
 where c.tname = '韩晋升'
   and ranking = 2
```

## 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 

```sql
select a.studentno, a.courseno, b.courseno, a.score
  from student_grade a, student_grade b
 where a.score = b.score
   and a.studentno = b.studentno
   and a.courseno <> b.courseno
```

## 查询各学生的年龄，只按年份来算 

```sql
select studentno,
       sname,
       extract(year from sysdate) - to_number(SUBSTR(birthday, 1, 4)) as age
  from student;
```



## 询各学生的年龄，按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一 

```sql
select studentno,
       sname,
       (case
         when ((select to_char(sysdate, 'yyyymm') from dual) >
              SUBSTR(birthday, 5, 4)) then
          extract(year from sysdate) - to_number(SUBSTR(birthday, 1, 4))
         else
          extract(year from sysdate) - to_number(SUBSTR(birthday, 1, 4)) - 1
       end) as age
  from student;
```



## 询本周过生日的学生

```sql
select studentno, sname
  from student
 where SUBSTR(birthday, 5, 4) >= to_char(trunc(sysdate, 'd') + 1, 'mmdd')
   and SUBSTR(birthday, 5, 4) <= to_char(trunc(sysdate, 'd') + 7, 'mmdd')
```



## 查询下周过生日的学生

```sql
select studentno, sname
  from student
 where SUBSTR(birthday, 5, 4) >= to_char(trunc(sysdate, 'd') + 8, 'mmdd')
   and SUBSTR(birthday, 5, 4) <= to_char(trunc(sysdate, 'd') + 14, 'mmdd')
```



## 查询本月过生日的学生

```sql
select studentno, sname
  from student
 where to_number(SUBSTR(birthday, 5, 2)) =
       extract(month from sysdate)
```



## 查询下月过生日的学生

```sql
select studentno, sname
  from student
 where (case when extract(month from sysdate)= 12 then 1
       else (extract(month from sysdate)+1) end )=
       (SUBSTR(birthday, 5, 2))
```



## 求每个学生所选课程的平均成绩，并用查询结果来创建一个新的数据表，学号，姓名，平均分；

```sql
-- author：zhengyuqi
-- studentno: students's number
-- sname: students's name
-- avgscore: students's average score

create table student_avg  
as
(select a.studentno, a.sname, b.avgscore
from student a left outer join 
(select studentno, avg(score) as avgscore
from student_grade
group by studentno) b on a.studentno = b.studentno);
```



## 查询所有低于课程平均成绩的学生情况

```sql
select *
  from student
 where studentno in
       (select studentno
          from student_grade a
          left outer join (select courseno, avg(score) as avgscore
                            from student_grade
                           group by courseno) b on a.courseno = b.courseno
         where a.score < b.avgscore);
```

