/*
�����Ƴɼ��������򣬲���ʾ������ Score �ظ�ʱ�������ο�ȱ����ʾ���£��γ̱�š�ѧ����š��ɼ�������
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

/*�ܽ᣺
partition by ���ڸ���������飬���û��ָ����ô���������������Ϊһ�����顣
Rank ����ÿ�������ڲ����������ġ�
1�������������һ�����飬��a��������
SELECT a,b,c,rank () OVER (ORDER BY a) rank
FROM test
2����a,b���з��飬��ÿ��������b��������
SELECT a,b,c,rank () OVER (PARTITION BY a,b ORDER BY b) rank 
FROM test
*/
/*
-- �����Ʒ���
select courseno
from studentscore
group by courseno
-- �����Ƴɼ���������
select a.courseno, b.score
from (select courseno
from studentscore
group by courseno)a, studentscore b
*/
