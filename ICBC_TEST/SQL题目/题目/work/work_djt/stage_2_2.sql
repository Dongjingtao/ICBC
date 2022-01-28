/*
查询各科成绩最高分、最低分和平均分以如下形式显示
课程 ID，课程 name，选修人数，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
   及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
   要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
*/

-- 查询各科成绩最高分、最低分和平均分 a (课程 ID，选修人数，最高分，最低分，平均分)
select courseno, count(*) count, max(score) max, min(score) min, avg(score) avg
from studentscore
group by courseno
-- 及格人数
select courseno, count(*) count60
from studentscore
where score >= '60'
group by courseno
-- 及格率 b 
select a.courseno, round(b.count60/a.count, 2) passrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count60
from studentscore
where score >= '60'
group by courseno) b 
    on a.courseno = b.courseno
-- 中等人数
select courseno, count(*) count7079
from studentscore
where score between '70' and '79'
group by courseno
-- 中等率 c
select a.courseno, round(b.count7079/a.count, 2) Moderate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count7079
from studentscore
where score between '70' and '79'
group by courseno) b 
    on a.courseno = b.courseno
-- 优良人数
select courseno, count(*) count8089
from studentscore
where score between '80' and '89'
group by courseno
-- 优良率 d
select a.courseno, round(b.count8089/a.count, 2) Goodrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count8089
from studentscore
where score between '80' and '89'
group by courseno) b 
    on a.courseno = b.courseno
-- 优秀人数
select courseno, count(*) count90
from studentscore
where score >= '90'
group by courseno
-- 优秀率 e
select a.courseno, round(b.count90/a.count, 2) excellentrate
from (select courseno, count(*) count
               from studentscore
              group by courseno) a
  join (select courseno, count(*) count90
from studentscore
where score >= '90'
group by courseno) b 
    on a.courseno = b.courseno
-- 课程 name f
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
