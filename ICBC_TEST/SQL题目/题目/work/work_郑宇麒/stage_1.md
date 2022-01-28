# stage 1

## 查询" 机械制图"比" C语言 "成绩高的学生的信息及课程分数

```sql
select a.studentno, a.score, b.score
  from student_grade a join student_grade b on a.studentno = b.studentno
 where a.courseno = (select courseno from course where cname = '机械制图')
   and b.courseno = (select courseno from course where cname = 'C语言' )
   and a.score > b.score;
   
   
   
   
   
   
  
select a.studentinfo,a.score,b.score
  form student_grade a join student_grade b on a.studentinfo=b.studentinfo
  where a.courseno=(select courseno from course where coursename='jixiezhitu')
```



## 查询同时选了" 机械制图"和" C语言 "的学生信息

```sql
select a.studentno
  from student_grade a join student_grade b on a.studentno = b.studentno
 where a.courseno = (select courseno from course where cname = '机械制图')
   and b.courseno = (select courseno from course where cname = 'C语言' );
```

## 查询选了" C语言 "但可能没选" 电子技术 "的学生信息及课程分数，显示如下：学生编号，姓名，c语言课程编号，c语言成绩，电子技术课程编号，电子技术成绩

```sql
select a.studentno, c.sname, a.courseno, a.score, b.courseno, b.score
  from (select *
          from student_grade
         where courseno = (select courseno from course where cname = 'C语言')) a
  left outer join (select *
                     from student_grade
                    where courseno = (select courseno
                                        from course
                                       where cname = '电子技术')) b on a.studentno =
                                                                   b.studentno
  left outer join student c on c.studentno = a.studentno;
```

## 查询没选" 电子技术 "课程但存在" C语言 "课程的学生信息(学生编号，姓名，下同)

```sql
select studentno, sname
  from student
 where studentno in
       (select studentno
          from student_grade
         where courseno = (select courseno from course where cname = 'C语言')
           and studentno not in
               (select studentno
                  from student_grade
                 where courseno =
                       (select courseno from course where cname = '电子技术')));
```

## 查询平均成绩大于等于80分的同学的学生编号、学生姓名和平均成绩(成绩保留2位小数，下同) 

```sql
select a.studentno, a.sname, Round(b.avgscore, 2)
  from student a
  join (select studentno, avg(score) as avgscore
          from student_grade
         group by studentno
        having avg(score) > 80) b on a.studentno = b.studentno
```

## 查询在课程成绩表存在成绩的学生信息

```sql
 select studentno, sname 
 from student
 where studentno in (select distinct studentno from student_grade);
```

## 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )

```sql
 select a.studentno, a.sname，b.coursenum,b.sumscore
 from student a left outer join (select studentno, count(score) as coursenum, sum(score) as sumscore
          from student_grade
         group by studentno) b  
         on a.studentno = b.studentno;
```

## 查询「刘」姓老师的数量 

```sql
select count(*)
FROM teacher
WHERE tname LIKE '刘%'
```

## 查询班级课程表有「刘元朝」老师课程的同学编号和姓名

```sql
select d.studentno，d.sname
  from student_grade c left outer join student d on c.studentno = d.studentno
 where c.courseno in
       (select a.courseno
          from schedule a
          left outer join teacher b on a.teacherno = b.teacherno
         where b.tname = '刘元朝')
```

## 查询获得少于3门课程成绩的学生信息

```sql
select a.studentno, a.sname
  from student a
  left outer join (select studentno, count(score) 
          from student_grade
         group by studentno
        having count(score) < 3) b on a.studentno = b.studentno;
```

## 查询至少有一门课与学号" 922221324 "同学所学相同的学生信息

```sql
select studentno, sname
  from student
 where studentno in
       (select studentno
          from student_grade
         where courseno in (select courseno
                              from student_grade
                             where studentno = '922221324'))
   and studentno <> '922221324';
```

## 查询和学号" 922221324 "同学学习的课程完全相同的其他同学的信息 

```sql
select studentno, sname
  from student
 where studentno in
       (select studentno
          from student_grade
         where studentno not in
               (select studentno
                  from student_grade
                 where courseno not in
                       (select courseno
                          from student_grade
                         where studentno = '922221324'))
           and studentno <> '922221324'
         group by studentno
        having count(courseno) = (select count(courseno)
                                   from student_grade
                                  where studentno = '922221324'));
```

## 查询没学过"韩晋升"老师讲授的任一门课程的学生编号和姓名

```sql
select studentno, sname
  from student
 where studentno not in
       (select studentno
          from student_grade
         where courseno in
               (select c.courseno
                  from schedule c
                  left outer join teacher d on c.teacherno = d.teacherno
                 where d.tname = '韩晋升'));
```

## 查询两门及其以上低于80分的同学的学号，姓名及其平均成绩 

```sql
-- 外连接方法
select c.studentno, d.sname, Round(d.avgscore, 2)
  from (select studentno, count(score) as coursenum
          from student_grade
         where score < 80
         group by studentno) c
  left outer join (select a.studentno, a.sname，b.avgscore
                     from student a
                     left outer join (select studentno,
                                            avg(score) as avgscore
                                       from student_grade
                                      group by studentno) b on a.studentno =
                                                               b.studentno) d on c.studentno =
                                                                                 d.studentno
 where c.coursenum >= 2;
 
 -- case方法
 select a.studentno, sname, Round(avg(score),2) as avg_score
  from student_grade a
 inner join student b on a.studentno = b.studentno
 group by a.studentno, sname
having sum(case when score < 80 then 1 else 0 end) >= 2;

```

## 检索"c05103"课程分数小于 90，按分数降序排列的学生信息(编号、姓名，分数)

```sql
select b.studentno, b.sname, a.score 
from student_grade a left outer join student b on a.studentno = b.studentno
where a.courseno = 'c05103' and to_number(score) < 90
order by a.score desc
```

