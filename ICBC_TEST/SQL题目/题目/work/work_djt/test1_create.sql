create table tb_user_video_log(
  id     VARCHAR(60)£¬
  u_id     VARCHAR(60)£¬
  video_id    VARCHAR(60)£¬
  start_time    VARCHAR(60)£¬
  end_time    VARCHAR(60)£¬
  if_follow    VARCHAR(60)£¬
  if_like     VARCHAR(60)£¬
  if_retweet    VARCHAR(60),
  comment_id    VARCHAR(60)
);
insert into tb_user_video_log
values ('1', '101', '2001', '2021-9-24 10:00:00', '2021-9-24 10:00:30', '1',  '1', '1', null );
insert into tb_user_video_log
values ('1', '101', '2001', '2021-10-01 10:00:00', '2021-9-24 10:00:31', '1',  '1', '0', null );

create table tb_video_info(
  video_id VARCHAR(60)£¬
  author VARCHAR(60)£¬
  tag  VARCHAR(60)£¬
  duration  VARCHAR(60)£¬
  release_time  VARCHAR(60)
)




select * from tb_user_video_log;
