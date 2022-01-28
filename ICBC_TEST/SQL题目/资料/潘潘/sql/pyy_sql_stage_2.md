# stage 1

## 查询" 机械制图"比" C语言 "成绩高的学生的信息及课程分数

一张表自己跟自己join

```sql
--你的sql
select studentno, cpro_score, machine_score
  from (select studentno,
               max(cpro_score) as cpro_score,
               max(machine_score) as machine_score
          from (select studentno,
                       case
                         when cname = 'C语言' then
                          score
                         else
                          0
                       end as cpro_score,
                       case
                         when cname = '机械制图' then
                          score
                         else
                          0
                       end as machine_score
                  from (select g.*, c.cname
                          from grade g
                         inner join course c
                            on g.courseno = c.courseno
                         where c.cname in ('C语言', '机械制图')) t) t1
         group by studentno
        having count(*) = 2) t2
 where machine_score > cpro_score;
```

## 查询同时选了" 机械制图"和" C语言 "的学生信息

```sql
--你的sql
select studentno
  from (select g.studentno, c.cname
          from grade g
         inner join course c
            on g.courseno = c.courseno
         where c.cname in ('C语言', '机械制图')) t
 group by studentno
having count(*) = 2;
```

## 查询选了" C语言 "但可能没选" 电子技术 "的学生信息及课程分数，显示如下：学生编号，姓名，c语言课程编号，c语言成绩，电子技术课程编号，电子技术成绩

```sql
--你的sql
select studentno,
       sname,
       sum(cpro_grade) as c_lan_score,
       sum(electro_grade) as electro_score
  from (select studentno,
               sname,
               courseno,
               cname,
               case
                 when cname = 'C语言' then
                  score
                 else
                  0
               end as cpro_grade,
               case
                 when cname = '电子技术' then
                  score
                 else
                  null
               end as electro_grade
          from (select g.*, s.sname, c.cname
                  from grade g
                 inner join student s
                    on g.studentno = s.studentno
                    inner join course c
                    on g.courseno = c.courseno
                 where g.studentno in (select g.studentno
                                         from grade g
                                         left join course c
                                           on g.courseno = c.courseno
                                        where c.cname = 'C语言')
                 ) t) t1
 group by studentno, sname;
```

## 查询没选" 电子技术 "课程但存在" C语言 "课程的学生信息(学生编号，姓名，下同)

subtract

```sql
--你的sql
select t1.studentno, s.sname
  from (select studentno
          from (select g.studentno
                  from grade g
                  left join course c
                    on g.courseno = c.courseno
                 where c.cname = 'C语言') t
         where not exists (select g.studentno
                  from grade g
                  left join course c
                    on g.courseno = c.courseno
                 where c.cname = '电子技术')) t1
 inner join student s
    on t1.studentno = s.studentno;
```

## 查询平均成绩大于等于80分的同学的学生编号、学生姓名和平均成绩(成绩保留2位小数，下同) 

```sql
--你的sql
select s.studentno, s.sname, t.avg_score
  from student s
 inner join (select studentno, round(avg(score), 2) as avg_score
               from grade
              group by studentno
             having avg(score) >= 80) t
    on s.studentno = t.studentno;

```

## 查询在课程成绩表存在成绩的学生信息

```sql
--你的sql
select studentno,sname
from student 
where exists(select * from grade group by studentno);
```

## 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )

```sql
--你的sql
select s.studentno, s.sname, t.course_cnt, t.score_sum
  from student s
  left join (select studentno,
                    count(courseno) as course_cnt,
                    sum(score) as score_sum
               from grade
              group by studentno) t
    on s.studentno = t.studentno;

```

## 查询「刘」姓老师的数量 

```sql
--你的sql
select count(teacherno)
from teacher
where tname like '刘%';
```

## 查询班级课程表有「刘元朝」老师课程的同学编号和姓名

```sql
--你的sql
/*select s.studentno, s.sname
from student s inner join(
select studentno
from grade
where  exists(
select courseno
from tea_course
where teacherno in (
select teacherno 
from teacher 
where tname='刘元朝'))) t 
on s.studentno=t.studentno*/

select studentno, sname
  from student
 where classno in
       (select classno
          from tea_course
         where teacherno in
               (select teacherno from teacher where tname = '刘元朝'));
```

## 查询获得少于3门课程成绩的学生信息

```sql
--你的sql
select studentno, sname
  from student
 where studentno in (select studentno
                       from grade
                      group by studentno
                     having count(score) < 3);
```

## 查询至少有一门课与学号" 922221324 "同学所学相同的学生信息

```sql
--你的sql
select t.studentno, s.sname
  from (select distinct studentno
          from grade
         where exists
         (select courseno from grade where studentno = '922221324')) t
 inner join student s
    on t.studentno = s.studentno;

```

## 查询和学号" 922221324 "同学学习的课程完全相同的其他同学的信息 

```sql
--你的sql
select studentno
  from (select g.studentno, g.courseno
          from grade g
         inner join (select courseno from grade where studentno = '922221324') t
            on g.courseno = t.courseno) t1
 where studentno <> '922221324'
 group by studentno
having count(courseno) = (select count(courseno)
                            from grade
                           where studentno = '922221324');
```

## 查询没学过"韩晋升"老师讲授的任一门课程的学生编号和姓名

```sql
--你的sql
select s.studentno, s.sname
  from student s
 inner join (select studentno
               from grade
              where not exists
              (select courseno
                       from tea_course
                      where teacherno in (select teacherno
                                            from teacher
                                           where tname = '韩晋升'))) t
    on s.studentno = t.studentno;
```

## 查询两门及其以上低于80分的同学的学号，姓名及其平均成绩 

```sql
--你的sql
select t2.*, s.sname
  from (select g.studentno, avg(g.score) as avg_score
          from grade g
         inner join (select studentno
                      from (select g.*,
                                   case
                                     when score < 80 then
                                      1
                                     else
                                      0
                                   end as lesseighty
                              from grade g) t
                     group by studentno
                    having count(lesseighty) >= 2) t1
            on g.studentno = t1.studentno
         group by g.studentno) t2
 inner join student s
    on t2.studentno = s.studentno;

```

## 检索"c05103"课程分数小于 90，按分数降序排列的学生信息(编号、姓名，分数)

```sql
--你的sql
select t.*, s.sname
  from (select studentno, score
          from grade
         where courseno = 'c05103'
           and score < 90) t
 inner join student s
    on t.studentno = s.studentno
 order by t.score desc;
```

