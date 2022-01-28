/*
按各科成绩进行排序，并显示排名， Score 重复时合并名次，显示如下：课程编号、学生编号、成绩、排名
*/
-- zyq
select courseno, studentno, score, rank()over(partition by courseno order by score desc) as ranking
from studentscore
-- jyz
SELECT s.courseno, s.studentno, s.score,COUNT(s1.score) + 1 rank
FROM STUDENTSCORE s LEFT JOIN STUDENTSCORE s1
ON s.courseno = s1.courseno
AND(s.score < s1.score OR (s.score = s1.score AND s.studentno > s1.studentno))
GROUP BY s.courseno, s.studentno, s.score
ORDER BY s.courseno, COUNT(s1.score);
