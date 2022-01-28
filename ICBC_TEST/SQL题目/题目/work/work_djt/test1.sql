-- 视频完播率：video_complete_rate a.视频编号 video_id , 观看时长 end_time - start_time, 视频时长 b.duration，相等的count
-- 观看时长
select end_time - start_time watch_time
from tb_user_video_log

select b.video_id, count(*) count
from tb_video_info b left join (select end_time - start_time watch_time
from tb_user_video_log) a on b.video_id = a.video_id
where b.duration = a.watch_time
group by a.video_id

select a.video_id, c.count/count(a.video_id) video_complete_rate
from tb_user_video_log a,  (select b.video_id, count(*) count
from tb_video_info b left join (select end_time - start_time watch_time
from tb_user_video_log) a on b.video_id = a.video_id
where b.duration = a.watch_time) c
where a.video_id = c.video_id
group by a.video_id

-- 点赞数 num_thumb_up 
select video_id, if_like
from tb_user_video_log

select video_id, count(*) num_thumb_up 
from (select video_id, if_like
from tb_user_video_log)
group by video_id
having if_like = '1'
-- 评论数 num_comment
select video_id, comment_id
from tb_user_video_log

select video_id, count(*) num_comment
from (select video_id, comment_id
from tb_user_video_log)
group by video_id
having comment_id is not null
-- 转发数 num_transmit
select video_id, if_retweet
from tb_user_video_log

select video_id, count(*) num_transmit 
from (select video_id, if_retweet
from tb_user_video_log)
group by video_id
having if_retweet = '1'

-- 最近无播放天数
select video_id, SUBSTR(to_char(trunc(sysdate, 'yyyy-mm-dd') - SUBSTR(a.end_time, 1, 10)),9,2) num_no_watch
from tb_user_video_log

-- 新鲜度=1/(最近无播放天数+1)；
select video_id, 1/(num_no_watch+1) freshness  
from (select video_id, SUBSTR(to_char(trunc(sysdate, 'yyyy-mm-dd') - SUBSTR(a.end_time, 1, 10)),9,2) num_no_watch
from tb_user_video_log)


-- 热度=(a*视频完播率+b*点赞数+c*评论数+d*转发数)*新鲜度；100、5、3、2。
select a.video_id,
       round((100 * a.video_complete_rate + 5 * b.num_thumb_up +
             3 * c.num_comment + 2 * d.num_transmit) * freshness,
             -1) heat
  from (select a.video_id, c.count / count(a.video_id) video_complete_rate
          from tb_user_video_log a,
               (select b.video_id, count(*) count
                  from tb_video_info b
                  left join (select end_time - start_time watch_time
                              from tb_user_video_log) a
                    on b.video_id = a.video_id
                 where b.duration = a.watch_time) c
         where a.video_id = c.video_id
         group by a.video_id) a,
       (select video_id, count(*) num_thumb_up
          from (select video_id, if_like from tb_user_video_log)
         group by video_id
        having if_like = '1') b,
       (select video_id, count(*) num_comment
          from (select video_id, comment_id from tb_user_video_log)
         group by video_id
        having comment_id is not null) c,
       (select video_id, count(*) num_transmit
          from (select video_id, if_retweet from tb_user_video_log)
         group by video_id
        having if_retweet = '1') d,
       (select video_id, 1 / (num_no_watch + 1) freshness
          from (select video_id,
                       SUBSTR(to_char(trunc(sysdate, 'yyyy-mm-dd') -
                                      SUBSTR(a.end_time, 1, 10)),
                              9,
                              2) num_no_watch
                  from tb_user_video_log)) e
 where a.video_id = b.video_id
   and a.video_id = c.video_id
   and a.video_id = d.video_id
   and a.video_id = e.video_id
 order by heat desc;




