/*
��ѯѧ�����ܳɼ����������������ܷ��ظ�ʱ�������ο�ȱ����ʾ���£�ѧ����š��ܷ֡�����
*/
-- zyq
select studentno, sum(score) as sumscore, rank()over(order by sum(score) desc) as ranking
          from STUDENTSCORE
         group by studentno
-- jyz ͬ
SELECT studentno, SUM(score) AS sum_sco,rank() over(ORDER BY SUM(score) DESC) AS rank
FROM STUDENTSCORE
GROUP BY studentno;
