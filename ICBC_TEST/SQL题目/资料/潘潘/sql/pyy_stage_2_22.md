# SQL STAGE 2



## 按学生平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(学生编号、课程编号、课程成绩，平均成绩)

```sql
--sql please...
/*select studentno,avg(score) as avg_score
from grade
group by rollup(studentno); with crosstab()*/

select t.*, t1.score_avg
  from (select *
          from (select g.studentno, g.score, c.cname
                  from grade g
                  left join course c
                    on g.courseno = c.courseno)
        pivot(sum(score)
           for cname in('电子技术',
                       'C语言',
                       '机械制图',
                       '机械设计',
                       '经济法',
                       '金融学',
                       '会计软件'))) t
  left join (select studentno, round(avg(score), 2) as score_avg
               from grade
              group by studentno) t1
    on t.studentno = t1.studentno
 order by t1.score_avg;
```

## 查询各科成绩最高分、最低分和平均分以如下形式显示

课程 ID，课程 name，选修人数，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
   及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
   要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列

```sql
--sql please...
select courseno,
       cname,
       count(studentno) as 选修人数,
       max(score) as 最高分,
       min(score) as 最低分,
       avg(score) as 平均分,
       round(sum(jige) / count(studentno), 2) as 及格率,
       round(sum(middle) / count(studentno), 2) as 中等率,
       round(sum(youliang) / count(studentno), 2) as 优良率,
       round(sum(youxiu) / count(studentno), 2) as 优秀率
  from (select g.*,
               c.cname,
               case
                 when g.score >= 60 then
                  1
                 else
                  0
               end as jige,
               case
                 when g.score between 70 and 80 then
                  1
                 else
                  0
               end as middle,
               case
                 when g.score between 80 and 90 then
                  1
                 else
                  0
               end as youliang,
               case
                 when g.score >= 90 then
                  1
                 else
                  0
               end as youxiu
          from grade g
          left join course c
            on g.courseno = c.courseno) t
 group by courseno, cname
 order by 选修人数 desc, courseno;


```





## 按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺，显示如下：课程编号、学生编号、成绩、排名

```sql
--sql please...
select courseno,studentno,score,
rank() over(partition by courseno order by score desc) as rn
from grade;


```

## 按各科成绩进行排序，并显示排名， Score 重复时合并名次，显示如下：课程编号、学生编号、成绩、排名

```sql
--sql please...
select courseno,studentno,score,
dense_rank() over(partition by courseno order by score desc) as rn
from grade;

```
## 查询学生的总成绩，并进行排名，总分重复时保留名次空缺，显示如下：学生编号、总分、排名

```sql
--sql please...
select studentno, score_sum,rank() over(order by score_sum desc) as rn
  from (select studentno, sum(score) as score_sum
          from grade
         group by studentno) t;

```
## 查询学生的总成绩，并进行排名，总分重复时合并名次，显示如下：学生编号、总分、排名

```sql
--sql please...
select studentno, score_sum, dense_rank() over(order by score_sum desc) as rn
  from (select studentno, sum(score) as score_sum
          from grade
         group by studentno) t;

```
## 查询各科成绩前三名的记录

```sql
--sql please...
select *
  from (select g.*,
               dense_rank() over(partition by g.courseno order by g.score desc) as rn
          from grade g) t
 where rn <= 3;
 
```
## 查询每门课程被选修的学生数 

```sql
--sql please...
select courseno,count(studentno) as stu_cnt
from grade
group by courseno;

```
## 查询出只选修两门课程的学生学号和姓名 

```sql
--sql please...
select studentno, sname
  from (select s.studentno, s.sname, t.courseno
          from student s
          left join class c
            on s.classno = c.classno
          left join tea_course t
            on c.classno = t.classno) t
 group by studentno, sname
having count(distinct courseno) = 2;


```
## 查询男生、女生人数

```sql
--sql please...
select sex,count(studentno) as stu_cnt
from student
group by sex;

```
## 查询名字中含有「海」字的学生信息

```sql
--sql please...
select *
from student
where sname like '%海%';
```
## 查询同名同姓学生名单，并统计同名人数

```sql
--sql please...
select sname,count(sname) as stu_cnt
from  student
group by sname
having count(sname)>1;
```
## 查询 1990 年出生的学生名单

```sql
--sql please...
select studentno, sname, sex, birthday, classno, phone, email
  from (select s.*,
               extract(year from to_date(birthday, 'yyyy-mm-dd')) as bir_year
          from student s) t
 where bir_year = '1990';
```
## 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

```sql
--sql please...
select courseno,avg(score) as score_avg
from  grade
group by courseno
order by score_avg desc, courseno;
```
## 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩 

```sql
--sql please...
select t.*,s.sname
from(
select studentno,avg(score) as score_avg
from grade
group by studentno
having avg(score)>=85) t inner join student s
on t.studentno=s.studentno;
```