# SQL_STAGE_3



##  查询课程名称为「C语言」，且分数低于 80 的学生姓名和分数 

```sql
SELECT s.sname,t.score
FROM STUDENT s LEFT JOIN STUDENTSCORE t
ON s.studentno = t.studentno
WHERE t.score < 80
AND t.courseno = (SELECT courseno
                  FROM course
                  WHERE cname = 'C语言');
```



## 查询所有学生的课程及分数情况（包括班级课表学生没选课没成绩的情况），显示学生编号，学生姓名，课程编号，课程名，成绩（可为空），按学生编号排序

```sql
SELECT s.studentno,s.sname,c.courseno,c.cname,t.score
FROM STUDENT s 
LEFT JOIN STUDENTSCORE t ON t.studentno = s.studentno
RIGHT JOIN COURSE c ON c.courseno = t.courseno
ORDER BY s.studentno DESC;
```

## 查询选修「韩晋升」老师所授课程的学生中，成绩排名第2的学生信息及其成绩

```sql
SELECT s3.*,t.score
FROM(SELECT courseno,studentno,score,rank() over(PARTITION BY courseno ORDER BY score DESC) AS ranking FROM STUDENTSCORE) t 
 LEFT OUTER JOIN SCHEDULE s1 ON t.courseno = s1.courseno
 LEFT OUTER JOIN TEACHER s2 ON s1.teacherno = s2.teacherno
 LEFT OUTER JOIN STUDENT s3 ON t.studentno = s3.studentno
WHERE s2.tname = '韩晋升' 
AND ranking = 2;
```

## 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 

```sql
SELECT t.studentno,t.courseno,t.score
FROM STUDENTSCORE t INNER JOIN STUDENTSCORE s on s.score = t.score
WHERE t.studentno <> s.studentno;
```

## 查询各学生的年龄，只按年份来算 

```sql
SELECT sname,FLOOR(MONTHS_BETWEEN(sysdate,to_date(birthday,'YYYY-MM-DD'))/12) AS sage
FROM STUDENT;
***另***

SELECT sname,TRUNC(to_char(sysdate,'YYYY') - substr(birthday,1,4)) AS sage
FROM STUDENT;
```



## 询各学生的年龄，按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一 

```sql
SELECT sname,CASE WHEN to_char(sysdate,'MMDD') < substr(birthday,5,4)
                  THEN TRUNC(to_char(sysdate,'YYYY') - substr(birthday,1,4) - 1)
                  ELSE TRUNC(to_char(sysdate,'YYYY') - substr(birthday,1,4))END AS sage 
FROM STUDENT;
```



## 询本周过生日的学生

```sql
SELECT sname
FROM STUDENT
WHERE to_char(trunc(sysdate,'d') + 1 ,'MMDD') <= substr(birthday,5,4) 
AND substr(birthday,5,4) <= to_char(trunc(sysdate,'d') + 7 ,'MMDD');

```



## 查询下周过生日的学生

```sql
SELECT sname
FROM STUDENT
WHERE to_char(trunc(sysdate,'d') + 8 ,'MMDD') <= substr(birthday,5,4) 
AND substr(birthday,5,4) <= to_char(trunc(sysdate,'d') + 14 ,'MMDD');
```



## 查询本月过生日的学生

```sql
SELECT sname
FROM STUDENT
WHERE substr(birthday,5,2) = to_char(sysdate,'MM');
```



## 查询下月过生日的学生

```sql
SELECT sname
FROM STUDENT
WHERE substr(birthday,5,2) = CASE WHEN to_char(sysdate ,'MM') = 12 
                              THEN 1 
                              ELSE to_char(sysdate ,'MM') + 1 END;
```



## 求每个学生所选课程的平均成绩，并用查询结果来创建一个新的数据表，学号，姓名，平均分；

```sql
CREATE TABLE AVGSCORE AS
(SELECT s.studentno,s.sname,t.avg_sco
                         FROM STUDENT s INNER JOIN (SELECT studentno,AVG(score) AS avg_sco
                                                    FROM STUDENTSCORE
                                                    GROUP BY studentno) t
                         ON s.studentno = t.studentno);
```



## 查询所有低于课程平均成绩的学生情况

```sql
SELECT *
FROM STUDENT
WHERE studentno IN(SELECT s.studentno 
                   FROM STUDENTSCORE s LEFT JOIN (SELECT courseno,AVG(score) AS avg_sco
                                                  FROM STUDENTSCORE
                                                  GROUP BY courseno) t
                   ON s.courseno = t.courseno
                   WHERE s.score < avg_sco
                   GROUP BY studentno);
```

