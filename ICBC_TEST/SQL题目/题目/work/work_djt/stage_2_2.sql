/*
��ѯ���Ƴɼ���߷֡���ͷֺ�ƽ������������ʽ��ʾ
�γ� ID���γ� name��ѡ����������߷֣���ͷ֣�ƽ���֣������ʣ��е��ʣ������ʣ�������
   ����Ϊ>=60���е�Ϊ��70-80������Ϊ��80-90������Ϊ��>=90
   Ҫ������γ̺ź�ѡ����������ѯ����������������У���������ͬ�����γ̺���������
*/

-- ��ѯ���Ƴɼ���߷֡���ͷֺ�ƽ���� a (�γ� ID��ѡ����������߷֣���ͷ֣�ƽ����)
select courseno, count(*) count, max(score) max, min(score) min, avg(score) avg
from studentscore
group by courseno
-- ��������
select courseno, count(*) count60
from studentscore
where score >= '60'
group by courseno
-- ������ b 
select a.courseno, round(b.count60/a.count, 2) passrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count60
from studentscore
where score >= '60'
group by courseno) b 
    on a.courseno = b.courseno
-- �е�����
select courseno, count(*) count7079
from studentscore
where score between '70' and '79'
group by courseno
-- �е��� c
select a.courseno, round(b.count7079/a.count, 2) Moderate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count7079
from studentscore
where score between '70' and '79'
group by courseno) b 
    on a.courseno = b.courseno
-- ��������
select courseno, count(*) count8089
from studentscore
where score between '80' and '89'
group by courseno
-- ������ d
select a.courseno, round(b.count8089/a.count, 2) Goodrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count8089
from studentscore
where score between '80' and '89'
group by courseno) b 
    on a.courseno = b.courseno
-- ��������
select courseno, count(*) count90
from studentscore
where score >= '90'
group by courseno
-- ������ e
select a.courseno, round(b.count90/a.count, 2) excellentrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count90
from studentscore
where score >= '90'
group by courseno) b 
    on a.courseno = b.courseno
-- �γ� name f
select a.courseno,
       f.cname,
       a.count,
       a.max,
       a.min,
       a.avg,
       b.passrate,
       c.Moderate,
       d.Goodrate,
       e.excellentrate
  from (select courseno,
               count(*) count,
               max(score) max,
               min(score) min,
               avg(score) avg
          from studentscore
         group by courseno) a
  left join (select a.courseno, round(b.count60 / a.count, 2) passrate
               from (select courseno, count(*) count
                       from studentscore
                      group by courseno) a
               join (select courseno, count(*) count60
                      from studentscore
                     where score >= '60'
                     group by courseno) b
                 on a.courseno = b.courseno) b
    on a.courseno = b.courseno
  left join (select a.courseno, round(b.count7079 / a.count, 2) Moderate
               from (select courseno,
                            count(*) count,
                            max(score) max,
                            min(score) min,
                            avg(score) avg
                       from studentscore
                      group by courseno) a
               join (select courseno, count(*) count7079
                      from studentscore
                     where score between '70' and '79'
                     group by courseno) b
                 on a.courseno = b.courseno) c
    on a.courseno = c.courseno
  left join (select a.courseno, round(b.count8089 / a.count, 2) Goodrate
               from (select courseno, count(*) count
                       from studentscore
                      group by courseno) a
               join (select courseno, count(*) count8089
                      from studentscore
                     where score between '80' and '89'
                     group by courseno) b
                 on a.courseno = b.courseno) d
    on a.courseno = d.courseno
  left join (select a.courseno, round(b.count90 / a.count, 2) excellentrate
               from (select courseno, count(*) count
                       from studentscore
                      group by courseno) a
               join (select courseno, count(*) count90
                      from studentscore
                     where score >= '90'
                     group by courseno) b
                 on a.courseno = b.courseno) e
    on a.courseno = e.courseno
  left join course f
    on a.courseno = f.courseno
 order by a.count desc, a.courseno;
