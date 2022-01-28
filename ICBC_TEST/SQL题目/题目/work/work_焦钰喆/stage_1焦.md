# stage 1

## 查询" 机械制图"比" C语言 "成绩高的学生的信息及课程分数

```sql
SELECT s.studentno
FROM STUDENTSCORE s JOIN STUDENTSCORE t ON s.studentno = t.studentno
WHERE s.courseno = (SELECT courseno
                    FROM course
                    WHERE cname = '机械制图')
AND t.courseno = (SELECT courseno
                  FROM course
                  WHERE cname = 'C语言' )
AND s.score > t.score;
```



## 查询同时选了" 机械制图"和" C语言 "的学生信息

```sql
SELECT *
FROM (SELECT * 
      FROM STUDENTSCORE
      WHERE courseno = (SELECT courseno 
                        FROM course
                        WHERE cname = 'C语言')) s,
     (SELECT *
      FROM STUDENTSCORE
      WHERE courseno = (SELECT courseno
                        FROM course
                        WHERE cname = '机械制图')) t
WHERE s.studentno =t.studentno;
```



## 查询选了" C语言 "但可能没选" 电子技术 "的学生信息及课程分数，显示如下：学生编号，姓名，c语言课程编号，c语言成绩，电子技术课程编号，电子技术成绩

```sql
SELECT *
FROM (SELECT * 
      FROM STUDENTSCORE
      WHERE courseno = (SELECT courseno 
                        FROM course
                        WHERE cname = 'C语言')) s LEFT JOIN
     (SELECT *
      FROM STUDENTSCORE
      WHERE courseno = (SELECT courseno
                        FROM course
                        WHERE cname = '电子技术')) t
ON s.studentno = t.studentno;
```

## 查询没选" 电子技术 "课程但存在" C语言 "课程的学生信息(学生编号，姓名，下同)

```sql
SELECT studentno
FROM STUDENTSCORE
WHERE courseno = (SELECT courseno FROM COURSE WHERE cname = 'C语言') AND studentno NOT IN 
 (SELECT studentno
  FROM STUDENTSCORE
  WHERE courseno = (SELECT courseno FROM course WHERE cname = '电子技术'));
```

## 查询平均成绩大于等于80分的同学的学生编号、学生姓名和平均成绩(成绩保留2位小数，下同) 

```sql
SELECT STUDENT.studentno,STUDENT.sname,AVG(STUDENTSCORE.score)
FROM STUDENT LEFT JOIN STUDENTSCORE 
ON STUDENT.studentno = STUDENTSCORE.studentno
GROUP BY STUDENT.studentno,STUDENT.sname
HAVING AVG(STUDENTSCORE.score) >= 80;

```

## 查询在课程成绩表存在成绩的学生信息

```sql
SELECT DISTINCT STUDENT.*
FROM STUDENT,STUDENTSCORE
WHERE STUDENT.studentno = STUDENTSCORE.studentno;
```

## 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )

```sql
SELECT STUDENT.studentno,STUDENT.sname,count_num,sum_score
FROM STUDENT LEFT JOIN(SELECT STUDENTSCORE.studentno,count(STUDENTSCORE.courseno) AS count_num,sum(STUDENTSCORE.score) AS sum_score 
                       FROM STUDENTSCORE
                       GROUP BY STUDENTSCORE.studentno) s
ON STUDENT.studentno = s.studentno;

```

## 查询「刘」姓老师的数量 

```sql
SELECT count (*)
FROM TEACHER
WHERE tname LIKE '刘%';

```

## 查询班级课程表有「刘元朝」老师课程的同学编号和姓名

```sql
SELECT studentno,sname
FROM STUDENT 
WHERE studentno IN (SELECT studentno
                    FROM STUDENTSCORE 
                    WHERE courseno IN (SELECT courseno
                                       FROM SCHEDULE
                                       WHERE teacherno IN (SELECT teacherno
                                                           FROM TEACHER
                                                           WHERE tname = '刘元朝' )));
```

## 查询获得少于3门课程成绩的学生信息

```sql
SELECT *
FROM student
WHERE studentno IN(SELECT studentno
                   FROM STUDENTSCORE
                   GROUP BY studentno
                   HAVING COUNT(score) < 3 );

```

## 查询至少有一门课与学号" 922221324 "同学所学相同的学生信息

```sql
SELECT *
FROM STUDENT
WHERE studentno IN (SELECT studentno
                    FROM STUDENTSCORE
                    WHERE courseno IN(SELECT courseno
                                      FROM STUDENTSCORE
                                      WHERE studentno = '922221324'))
AND studentno <> '922221324';
```

## 查询和学号" 922221324 "同学学习的课程完全相同的其他同学的信息 

```sql
SELECT s.studentno,s.sname,s.sex,s.birthday,s.phone,s.email,s.classno
FROM student s LEFT JOIN STUDENTSCORE t ON s.studentno= t.studentno
WHERE t.courseno IN (SELECT courseno
                     FROM STUDENTSCORE
                     WHERE studentno ='922221324')
GROUP BY s.studentno,s.sname,s.sex,s.birthday,s.phone,s.email,s.classno
HAVING COUNT(s.studentno) = (SELECT COUNT(courseno)
                             FROM STUDENTSCORE
                             WHERE studentno='922221324')
AND s.studentno !='922221324';

```

## 查询没学过"韩晋升"老师讲授的任一门课程的学生编号和姓名

```sql
SELECT sname,studentno
FROM STUDENT 
WHERE studentno NOT IN(SELECT studentno
                       FROM STUDENTSCORE
                       WHERE courseno IN(SELECT courseno
                                             FROM SCHEDULE
                                             WHERE teacherno IN (SELECT teacherno 
                                                                 FROM TEACHER
                                                                 WHERE tname='韩晋升')));
```

## 查询两门及其以上低于80分的同学的学号，姓名及其平均成绩 

```sql
SELECT s.studentno,sname,AVG(score) AS avg_score
FROM STUDENTSCORE s INNER JOIN STUDENT t 
ON s.studentno = t.studentno
GROUP BY s.studentno,sname
HAVING SUM(CASE WHEN score < 80 THEN 1 ELSE 0 END) >= 2;


```

## 检索"c05103"课程分数小于 90，按分数降序排列的学生信息(编号、姓名，分数)

```sql
SELECT t.*,s.sname
FROM(SELECT studentno,score
     FROM STUDENTSCORE
     WHERE courseno='c05103' AND score<90) t INNER JOIN STUDENT s
ON t.studentno=s.studentno
ORDER BY t.score DESC;

```

