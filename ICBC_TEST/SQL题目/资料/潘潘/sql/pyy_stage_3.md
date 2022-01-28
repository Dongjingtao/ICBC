# SQL_STAGE_3



##  查询课程名称为「C语言」，且分数低于 80 的学生姓名和分数 

```sql
--sql here...
select g.*,s.sname,c.cname
from grade g left join course c
on g.courseno=c.courseno
left join student s 
on g.studentno=s.studentno
where c.cname='C语言' and g.score<80;
```



## 查询所有学生的课程及分数情况（包括班级课表学生没选课没成绩的情况），显示学生编号，学生姓名，课程编号，课程名，成绩（可为空），按学生编号排序

```sql
--sql here...
select t.studentno,t.sname,c.courseno,t.score
from course c left join(
select s.studentno,s.sname,g.score,g.courseno
from student s left join grade g 
on s.studentno=g.studentno)t
on c.courseno=t.courseno
order by t.studentno;

```

## 查询选修「韩晋升」老师所授课程的学生中，成绩排名第2的学生信息及其成绩

```sql
--sql here...
select t2.studentno,s.sname,t2.score
from(
select g.studentno,g.score,dense_rank() over(order by g.score desc) as rn
from 
(
select t1.classno ,t1.courseno
from teacher t inner join tea_course t1
on t.teacherno=t1.teacherno and t.tname='韩晋升') t 
inner join grade g
on g.courseno=t.courseno )t2 left join student s on t2.studentno=s.studentno
where rn=2;

```

## 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 

```sql
--sql here...
select * from grade g1
where exists(select * from grade g2 where g1.score=g2.score and g1.courseno <> g2.courseno)
```

## 查询各学生的年龄，只按年份来算 

```sql
--sql here...
select s.studentno,s.sname,extract(year from current_date)-to_number(substr(birthday,1,4)) as age
from student s 
```



## 询各学生的年龄，按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一 

```sql
--sql here...
select studentno,sname,age_tmp-tem as age from(
select studentno,sname,extract(year from current_date)-to_number(substr(birthday,1,4)) as age_tmp,
case when extract(month from current_date)<to_number(substr(birthday,5,2)) and extract(day from current_date)<to_number(substr(birthday,7,2)) then -1 else 0 end as tem
from student) t
```



## 询本周过生日的学生

```sql
--sql here...
select * 
from student
where to_date(substr(birthday,5,4),'mm-dd') between (select trunc( sysdate,'d')+1 from dual) and (select trunc( sysdate,'d')+7 from dual);
```



## 查询下周过生日的学生

```sql
--sql here...
select * 
from student
where to_date(substr(birthday,5,4),'mm-dd') between (select trunc( sysdate+7,'d')+1 from dual) and (select trunc( sysdate+7,'d')+7 from dual);
```



## 查询本月过生日的学生

```sql
--sql here...
select studentno,sname
from student
where extract(month from current_date)=to_number(substr(birthday,5,2));

```



## 查询下月过生日的学生

```sql
--sql here...
select studentno,sname
from(
select studentno,sname,to_number(substr(birthday,5,2)) as bir_month,
case  when extract(month from current_date)<12 then  extract(month from current_date)+1 else 1 end as cur_next_month
from student) t
where bir_month=cur_next_month;

```



## 求每个学生所选课程的平均成绩，并用查询结果来创建一个新的数据表，学号，姓名，平均分；

```sql
--sql here...

select g.studentno, s.sname,avg(g.score) as avg_score
from grade g left join student s
on g.studentno=s.studentno
group by g.studentno,s.sname
```



## 查询所有低于课程平均成绩的学生情况

```sql
--sql here...
select * from (
select s.*,t.avg_score
from score s left join (
select courseno,avg(score) as avg_score
from grade
group by courseno) t
on s.courseno=t.courseno) t1
where score<avg_score
```

