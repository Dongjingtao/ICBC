select * from CALENDAR t

select * from CALENDAR_P partition(P_2022)

insert into calendar_p select * from calendar;
commit;

select to_char(systimestamp,'yyyymmddhh24missff3') from dual

select to_char(sysdate,'yyyymmddhh24miss') from dual

--需求1
select workdate
  from (select workdate
          from CALENDAR
         where workdate > '20211203'
           AND WLWORKFLAG = 1
         order by workdate)
where rownum = 1         

--需求2
select min(workdate) as mindate, max(workdate) as maxdate
  from (select workdate
          from (select workdate
                  from CALENDAR
                 where workdate > '20211203'
                   AND WLWORKFLAG = 1
                 order by workdate)
         where rownum <= 3)

--需求3
select catalogue_id, catalogue_name, min(workdate), max(workdate) from (
select c.catalogue_id, c.catalogue_name, calendar.workdate as workdate
  from (select b.catalogue_id, a.workdate, 
               row_number() over(partition by catalogue_id order by a.workdate) as id
          from (select c.workdate
                  from CALENDAR c
                 where c.workdate > to_char(sysdate, 'yyyymmdd')
                   AND trim(c.WLWORKFLAG) = 1
                 order by workdate) a,
               catalogue b
         where b.valid_sdate <= to_char(sysdate, 'yyyymmdd')
           and b.valid_edate >= to_char(sysdate, 'yyyymmdd')) calendar,
       catalogue c
 where calendar.catalogue_id = c.catalogue_id
   and calendar.id  <= c.normal_days)
group by catalogue_id, catalogue_name


--需求4
select count(1) from (
select b.catalogue_id,
       a.workdate,
       row_number() over(partition by catalogue_id order by a.workdate) as id
  from (select c.workdate
          from CALENDAR c
         where c.workdate > '20211207'
           AND trim(c.WLWORKFLAG) = 1
         order by workdate) a,
       catalogue b
 where b.valid_sdate <= to_char(sysdate, 'yyyymmdd')
   and b.valid_edate >= to_char(sysdate, 'yyyymmdd')
   and b.catalogue_id = '104'
   and rownum <= b.normal_days )
where workdate = to_char(sysdate, 'yyyymmdd')

select FUNC_GET_NEXT_WORKDATE('20211205','101') from dual



--测试1
select * from catalogue 

update catalogue set count_limit = 10 where catalogue_id = '103';


select * from catalogue for update


update catalogue set count_limit = 21 where catalogue_id = '103' and count_limit = 10;
