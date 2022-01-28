# SQL STAGE 2



## 按学生平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(学生编号、课程编号、课程成绩，平均成绩)

```sql
SELECT * 
FROM STUDENTSCORE INNER JOIN (SELECT studentno,avg(score) AS avg_sco
                              FROM STUDENTSCORE
                              GROUP BY studentno) s ON s.studentno= STUDENTSCORE.studentno
ORDER BY s.avg_sco DESC;

```

## 查询各科成绩最高分、最低分和平均分以如下形式显示

课程 ID，课程 name，选修人数，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
   及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
   要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列

```sql
SELECT COURSE.courseno,COURSE.cname,COUNT(STUDENTSCORE.studentno) AS 选修人数 ,
MAX(STUDENTSCORE.score) AS 最大值,
MIN(STUDENTSCORE.score) AS 最小值,
AVG(STUDENTSCORE.score) AS 平均分,
SUM(case when STUDENTSCORE.score>=60 then 1 else 0 end)/count(STUDENTSCORE.studentno) AS 及格率,
SUM(case when STUDENTSCORE.score>=70 and STUDENTSCORE.score<80 then 1 else 0 end) / COUNT(STUDENTSCORE.studentno) AS 中等率,
SUM(case when STUDENTSCORE.score>=80 and STUDENTSCORE.score<90 then 1 else 0 end) / COUNT(STUDENTSCORE.studentno) AS 优良率,
SUM(case when STUDENTSCORE.score>=90 then 1 else 0 end) / COUNT(STUDENTSCORE.studentno) AS 优秀率
FROM COURSE LEFT JOIN STUDENTSCORE
ON COURSE.courseno = STUDENTSCORE.courseno
GROUP BY COURSE.courseno,COURSE.cname;
```





## 按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺，显示如下：课程编号、学生编号、成绩、排名

```sql
SELECT s.courseno,s.studentno,s.score, count(s1.score) + 1 rank
FROM STUDENTSCORE s LEFT JOIN STUDENTSCORE s1
ON s.courseno = s1.courseno
AND s.score < s1.score
GROUP BY s.courseno, s.studentno,s.score
ORDER BY s.courseno, rank;

```

## 按各科成绩进行排序，并显示排名， Score 重复时合并名次，显示如下：课程编号、学生编号、成绩、排名

```sql
SELECT s.courseno, s.studentno, s.score,COUNT(s1.score) + 1 rank
FROM STUDENTSCORE s LEFT JOIN STUDENTSCORE s1
ON s.courseno = s1.courseno
AND(s.score < s1.score OR (s.score = s1.score AND s.studentno > s1.studentno))
GROUP BY s.courseno, s.studentno, s.score
ORDER BY s.courseno, COUNT(s1.score);
```
## 查询学生的总成绩，并进行排名，总分重复时保留名次空缺，显示如下：学生编号、总分、排名

```sql
SELECT studentno, SUM(score) AS sum_sco,rank() over(ORDER BY SUM(score) DESC) AS rank
FROM STUDENTSCORE
GROUP BY studentno;

```
## 查询学生的总成绩，并进行排名，总分重复时合并名次，显示如下：学生编号、总分、排名

```sql
SELECT studentno, SUM(score) AS sum_sco, dense_rank () over (ORDER BY SUM(score) DESC) AS rank
FROM STUDENTSCORE
GROUP BY studentno;

```
## 查询各科成绩前三名的记录

```sql
SELECT s.*
FROM STUDENTSCORE s
WHERE ( SELECT COUNT(*)
        FROM STUDENTSCORE s1
        WHERE s1.courseno = s.courseno
        AND s1.score > s.score) < 3
ORDER BY s.courseno, s.studentno;
```
## 查询每门课程被选修的学生数 

```sql
SELECT courseno, COUNT(studentno) AS stu_no
FROM STUDENTSCORE
GROUP BY courseno;

```
## 查询出只选修两门课程的学生学号和姓名 

```sql
SELECT STUDENTSCORE.studentno, STUDENT.sname
FROM STUDENT
LEFT JOIN STUDENTSCORE ON STUDENTSCORE.studentno = STUDENT.studentno
WHERE STUDENTSCORE.studentno IN(SELECT STUDENTSCORE.studentno
                                FROM STUDENTSCORE
                                GROUP BY STUDENTSCORE.studentno
                                HAVING COUNT(STUDENTSCORE.studentno) = 2)
GROUP BY STUDENTSCORE.studentno, STUDENT.sname;
```
## 查询男生、女生人数

```sql
SELECT STUDENT.sex,count(*) 
FROM STUDENT
GROUP BY STUDENT.sex;
```
## 查询名字中含有「海」字的学生信息

```sql
SELECT *
FROM STUDENT
WHERE sname LIKE '%海%';

```
## 查询同名同姓学生名单，并统计同名人数

```sql
SELECT STUDENT.sname,count(*)
FROM STUDENT
GROUP BY STUDENT.sname
HAVING COUNT(*) > 1;
```
## 查询 1990 年出生的学生名单

```sql
SELECT sname 
FROM STUDENT
WHERE STUDENT.birthday like '1990%';
```
## 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

```sql
SELECT courseno,AVG(score) AS avg_score 
FROM STUDENTSCORE
GROUP BY courseno
ORDER BY avg_score DESC,courseno;

```
## 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩 

```sql
SELECT STUDENT.studentno,STUDENT.sname,AVG(STUDENTSCORE.score)
FROM STUDENT LEFT JOIN STUDENTSCORE 
ON STUDENT.studentno = STUDENTSCORE.studentno
GROUP BY STUDENT.studentno,STUDENT.sname
HAVING AVG(STUDENTSCORE.score) >= 85;

```