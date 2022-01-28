/*
查询各科成绩前三名的记录
*/
-- zyq
select *
  from (select courseno,
               studentno,
               score,
               rank() over(partition by courseno order by score desc) as ranking
          from STUDENTSCORE)
 where ranking <= 3

/*-- jyz
SELECT s.*
FROM STUDENTSCORE s
WHERE ( SELECT COUNT(*)
        FROM STUDENTSCORE s1
        WHERE s1.courseno = s.courseno
        AND s1.score > s.score) < 3
ORDER BY s.courseno, s.studentno;*/
