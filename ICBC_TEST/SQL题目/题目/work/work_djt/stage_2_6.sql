/*
��ѯѧ�����ܳɼ����������������ܷ��ظ�ʱ�ϲ����Σ���ʾ���£�ѧ����š��ܷ֡�����
*/
-- zyq
select studentno, sum(score) as sumscore, dense_rank()over(order by sum(score) desc) as ranking
          from STUDENTSCORE
         group by studentno
-- jyz ͬ
SELECT studentno, SUM(score) AS sum_sco, dense_rank () over (ORDER BY SUM(score) DESC) AS rank
FROM STUDENTSCORE
GROUP BY studentno;
