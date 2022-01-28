/*
查询学生的总成绩，并进行排名，总分重复时合并名次，显示如下：学生编号、总分、排名
*/
-- zyq
select studentno, sum(score) as sumscore, dense_rank()over(order by sum(score) desc) as ranking
          from STUDENTSCORE
         group by studentno
-- jyz 同
SELECT studentno, SUM(score) AS sum_sco, dense_rank () over (ORDER BY SUM(score) DESC) AS rank
FROM STUDENTSCORE
GROUP BY studentno;
