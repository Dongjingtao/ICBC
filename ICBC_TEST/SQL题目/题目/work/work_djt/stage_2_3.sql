/*
按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺，显示如下：课程编号、学生编号、成绩、排名
*/
-- zyq
select courseno, studentno, score, rank()over(partition by courseno order by score desc) as ranking
from studentscore
-- jyz
SELECT s.courseno,s.studentno,s.score, count(s1.score) + 1 rank
FROM STUDENTSCORE s LEFT JOIN STUDENTSCORE s1
ON s.courseno = s1.courseno
AND s.score < s1.score
GROUP BY s.courseno, s.studentno,s.score
ORDER BY s.courseno, rank;

/*总结：
partition by 用于给结果集分组，如果没有指定那么它把整个结果集作为一个分组。
Rank 是在每个分组内部进行排名的。
1、整个结果集是一个分组，以a进行排名
SELECT a,b,c,rank () OVER (ORDER BY a) rank
FROM test
2、以a,b进行分组，在每个组内以b进行排名
SELECT a,b,c,rank () OVER (PARTITION BY a,b ORDER BY b) rank 
FROM test
*/
/*
-- 按各科分组
select courseno
from studentscore
group by courseno
-- 按各科成绩进行排序
select a.courseno, b.score
from (select courseno
from studentscore
group by courseno)a, studentscore b
*/
