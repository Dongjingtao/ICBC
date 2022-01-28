use mydb0;
-- 所有年龄在20岁以下的学生姓名及其年龄
select sname,sage
from student
where sage<20;

-- 考试成绩不及格的学生的学号
select distinct sno
from sc
where grade<60;

-- 年龄在20-23岁之间的学生姓名系别和年龄
select sname,sdept,sage
from student
where sage between 20 and 23;

-- 年龄不在20-23岁之间的学生姓名系别和年龄
select sname,sdept,sage
from student
where sage not between 20 and 23;

-- 计算机科学系 数学系 信息系学生的姓名和性别
select sname,ssex
from student
where sdept in ('cs','ma','is');

-- 既不是计算机科学系 数学系 信息系学生的姓名和性别
select sname,ssex
from student
where sdept not in ('cs','ma','is');

-- 学号为201215121的学生详细情况
select *
from student
where sno like '201215122';

-- 所有姓刘的学生姓名学号和性别
select sname,sno,ssex
from student
where sname like '刘%';

-- 姓“欧阳”且全名为三个汉字的学生姓名
select sname
from student
where sname like '欧阳_';

-- 名字中第二个字为“阳”学生姓名和学号
select sname,sno
from student
where sname like '_阳%';

-- 所有不姓刘的学生姓名学号和性别
select sno,ssex
from student
where sname not like '刘%';

-- 查询DB_Design课程的课程号和学分
select cno,ccredit
from course
where cname like 'DB/_Design' escape '/';

-- 查询以“DB_”开头，且倒数第三个字符为i的课程的详细情况
select *
from course
where Cname like 'DB/_%i__' escape '/';

-- 查询缺少成绩的学生学号和相应课程号
select sno, cno
from sc
where grade is null;

-- 查询计算机科学系年龄在20以下的学生姓名
select sname
from student
where sdept = 'cs' and sage < '20';

-- ORDER BY
-- 查询选修了3号课程学生的学号和成绩，查询结果按分数降序排列
select sno,grade
from sc
where cno = '3'
order by grade desc;

-- 查询全体学生情况，查询结果按所在系的系号升序排列，同一个系的学生按年龄降序排列
select *
from student
order by sdept asc,sage desc;

-- 聚集函数
-- 查询学生总人数
select count(distinct sno)
from student;

-- 查询选修了课程的学生总人数
select count(distinct sno)
from sc;

-- 查询选修1号课程的学生平均分数
select avg(grade)
from sc
where cno = '1';

-- 查询选修1号课程的学生最高分数
select max(grade)
from sc
where cno = '1';

-- 查询学生201215012选修课程的总学分数
select sum(ccredit)
from course c,sc s
where sno = '201215012'
and c.cno = s.cno;

-- Group BY
-- 求各个课程号及相应的选课人数
select cno,count(distinct sno)
from sc
group by cno;

-- 查询选修了三门以上课程的学生学号
select sno
from sc
group by sno -- 按sno分组
having count(*) > 3; -- 对每组里计数

-- 查询平均成绩大于等于90分的学生学号和平均成绩
select sno,avg(grade)
from sc
group by grade
having avg(grade) >= 90;

-- , , join
-- 查询每个学生及其选修课程的情况(去掉重复列就是自然连接)
select a.*, b.cno,b.grade
-- from student a join sc b on a.sno=b.sno
from student a,sc b 
where a.sno = b.sno;

-- 查询选修2号课程且成绩在90分以上的所有学生的学号和姓名
select b.sno,b.sname
from sc a,student b
where a.cno = '2'
and a.sno = b.sno
and a.grade > '90';

-- 查询每一门课的间接先修课（先修课的先修课）
select a.cno, a.cname, b.cpno
-- from course a join course b on a.cpno =  b.cpno
from course a, course b
where a.cpno = b.cno
and b.cpno is not null
order by a.cno;
/* join方法
select a.cno, a.cname, b.cpno
from course a join course b on a.cpno =  b.cno
where b.cpno is not null
order by a.cno;*/

-- 查询每个学生的学号姓名选修的课程名和成绩
select a.sno, a.sname, c.cname, b.grade
from student a,sc b,course c
where a.sno = b.sno
and b.cno = c.cno;

-- 查询与刘晨在同一个系的学生
select b.*
-- from student a right join student b on a.sno = b.sno
from student a ,student b
where a.sname = '刘晨'
and a.sdept = b.sdept;

select sdept
from student
where sname = '刘晨';

select *
from student
where sdept in (select sdept
				from student
				where sname = '刘晨'
)
and sname != '刘晨';

-- 查询选修了课程名为“信息系统”的学生学号和姓名
SELECT a.sno, a.sname
from student a,course b, sc c
where b.cname = '信息系统' and
	  b.cno = c.cno and
	  c.sno = a.sno;

-- 找出每个学生超过他自己选修课程平均成绩的课程号
select sno,cno
from sc a
where grade > (select avg(grade)
				 from sc b
                 where b.sno= a.sno);

-- 方法2：找出每个学生超过他自己选修课程平均成绩的课程号
select a.sno, a.cno
from sc a right join (select sno, avg(grade) dd
from sc
group by sno
) b on a.sno = b.sno
where a.grade > b.dd;
                 
-- 查询非计算机科学系比计算机科学系任意一个学生年龄小的学生姓名和年龄
select sno, sage
from student
where sdept <> 'cs'
and sage < any(select sage
from student
where sdept = 'cs');

-- 查询选修了1号课程的学生姓名
select sname
from student
where sno in (select sno
from sc
where cno = '1') ;

-- 方法2:查询选修了1号课程的学生姓名
select sname
from student
where exists (select *
			from sc
            where student.sno = sc.sno
            and sc.cno = '1'
);

-- 查询没有选修了1号课程的学生姓名
select sname
from student
where sno not in (select sno
from sc
where cno = '1') ;

-- 方法2:查询没有选修了1号课程的学生姓名
select sname
from student
where not exists (select *
			from sc
            where student.sno = sc.sno
            and sc.cno = '1'
);

-- 查询选修了全部课程的学生姓名
select sname
from student
where not exists (
select *
from course
where not exists (
select *
from sc
where sno = student.sno
and cno = course.cno )
);

-- 查询选修了全部课程的学生姓名
select sname
from student
where not exists(select *
				from course
                where not exists (select *
								from sc
                                where student.sno = sno
                                and course.cno = cno
                )
);

-- 查询至少选修了学生201215122选修的全部课程的学生号码
-- 不存在这样的课程，学生201215122选了，而学生x没有选
/*select distinct sno
from sc x
where not exists (select *
					from sc y
					where sno = '201215122' and
                    not exists (select *
									from sc z
									where z.sno = x.sno
                                    z.cno = y.cno
                    )
)

-- 1.学生201215122选修的全部课程
select cno
from sc
where sno = '201215122';
-- 2.d 
select sno
from sc
where not exists (select *
				  from sc
				  where sno = '201215122');
-- 3
select sno
from student
where not exists (select *
			    	from sc a
					where sno = '201215122'
and not exists (select *
				  from sc 
				  where student.sno = sc.sno
                  and a.cno = sc.cno));
*/

-- 查询计算机科学系的学生及年龄不大于19岁的学生
-- 去重 union
select *
from student
where sdept = 'cs'
union
select *
from student
where sage <= '19';
-- 不去重 union all
select *
from student
where sdept = 'cs'
union all
select *
from student
where sage <= '19';

-- 查询选修了课程1或者课程2的学生
select sno
from sc
where cno = '1'
union
select sno
from sc
where cno = '2';

-- 查询计算机科学系的学生与年龄不大于19岁的学生的交集



















































