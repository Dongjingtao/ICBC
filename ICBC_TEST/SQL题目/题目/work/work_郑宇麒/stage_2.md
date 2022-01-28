# SQL STAGE 2



## 按学生平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(学生编号、课程编号、课程成绩，平均成绩)

```sql
select a.studentno, a.courseno, a.score, b.avgscore
  from student_grade a
  left outer join (select studentno, round(avg(score), 2) as avgscore
                     from student_grade
                    group by studentno) b on a.studentno = b.studentno
 order by b.avgscore desc
```

## 查询各科成绩最高分、最低分和平均分以如下形式显示

课程 ID，课程 name，选修人数，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
   及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
   要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列

```sql
select a.courseno,
       b.cname,
       a.student_num,
       a.highest_score,
       a.lowest_score,
       a.avg_score,
       a.pass_rate,
       a.mid_rate,
       a.good_rate,
       a.excellent_rate
  from (select courseno,
               count(score) as student_num,
               max(score) as highest_score,
               min(score) as lowest_score,
               avg(score) as avg_score,
               sum(case
                     when score >= 60 then
                      1
                     else
                      0
                   end) / count(score) as pass_rate,
               sum(case
                     when score between 70 and 80 then
                      1
                     else
                      0
                   end) / count(score) as mid_rate,
               sum(case
                     when score between 80 and 90 then
                      1
                     else
                      0
                   end) / count(score) as good_rate,
               sum(case
                     when score >= 90 then
                      1
                     else
                      0
                   end) / count(score) as excellent_rate
          from student_grade
         group by courseno) a
  left join course b on a.courseno = b.courseno
  select a.courseno,
       b.cname,
       a.student_num,
       a.highest_score,
       a.lowest_score,
       a.avg_score,
       a.pass_rate,
       a.mid_rate,
       a.good_rate,
       a.excellent_rate
  from (select courseno,
               count(score) as student_num,
               max(score) as highest_score,
               min(score) as lowest_score,
               avg(score) as avg_score,
               sum(case
                     when score >= 60 then
                      1
                     else
                      0
                   end) / count(score) as pass_rate,
               sum(case
                     when score between 70 and 80 then
                      1
                     else
                      0
                   end) / count(score) as mid_rate,
               sum(case
                     when score between 80 and 90 then
                      1
                     else
                      0
                   end) / count(score) as good_rate,
               sum(case
                     when score >= 90 then
                      1
                     else
                      0
                   end) / count(score) as excellent_rate
          from student_grade
         group by courseno) a
  left join course b on a.courseno = b.courseno
 order by a.student_num desc, a.courseno
```





## 按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺，显示如下：课程编号、学生编号、成绩、排名

```sql
select courseno, studentno, score, rank()over(partition by courseno order by score desc) as ranking
from student_grade
```

## 按各科成绩进行排序，并显示排名， Score 重复时合并名次，显示如下：课程编号、学生编号、成绩、排名

```sql
select courseno, studentno, score, dense_rank()over(partition by courseno order by score desc) as ranking
from student_grade
```
## 查询学生的总成绩，并进行排名，总分重复时保留名次空缺，显示如下：学生编号、总分、排名

```sql
select studentno, sum(score) as sumscore, rank()over(order by sum(score) desc) as ranking
          from student_grade
         group by studentno
```
## 查询学生的总成绩，并进行排名，总分重复时合并名次，显示如下：学生编号、总分、排名

```sql
select studentno, sum(score) as sumscore, dense_rank()over(order by sum(score) desc) as ranking
          from student_grade
         group by studentno
```
## 查询各科成绩前三名的记录

```sql
select *
  from (select courseno,
               studentno,
               score,
               rank() over(partition by courseno order by score desc) as ranking
          from student_grade)
 where ranking <= 3
```
## 查询每门课程被选修的学生数 

```sql
select courseno,count(*)
from student_grade
group by courseno
```
## 查询出只选修两门课程的学生学号和姓名 

```sql
select studentno, sname
  from student
 where studentno in (select studentno
                       from student_grade
                      group by studentno
                     having count(*) = 2)
```
## 查询男生、女生人数

```sql
select sex,count(*)
from student
group by sex
```
## 查询名字中含有「海」字的学生信息

```sql
select studentno,sname
from student
where sname like '%海%'
```
## 查询同名同姓学生名单，并统计同名人数

```sql
select sname, count(*)
from student
group by sname
having count(*)>=2
```
## 查询 1990 年出生的学生名单

```sql
select studentno,sname
from student
where birthday like '1990%'
```
## 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

```sql
select courseno,avg(score)
from student_grade
group by courseno
order by avg(score) desc, courseno
```
## 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩 

```sql
select a.studentno, b.sname, a.avgscore
  from (select studentno, avg(score) as avgscore
          from student_grade
         group by studentno) a
  left outer join student b on a.studentno = b.studentno
 where a.avgscore >= 85
```