1.1

```sql
create table addressbook(
regist_no int not null primary key,
name_ varchar(128) not null,
address varchar(256)  not null,
tel_no char(10),
mail_address char(10)
)
tablespace PYY;

-- Add comments to the table
comment on table addressbook
  is '用户的地址及其他联系信息';
-- Add comments to the columns
comment on column addressbook.regist_no
  is '注册编号';
comment on column addressbook.name_
  is '姓名';
comment on column addressbook.address
  is '住址';
comment on column addressbook.tel_no
  is '电话号码';
comment on column addressbook.mail_address
  is '邮箱地址';
```

1.2

```sql
alter table pyy add (name_ char(8));
alter table addressbook add (postal_code char(8) not null);
```

1.3

```sql
drop table addressbook;
```

1.4删除掉的表是无法恢复的，只能再次使用1.1 的命令重新建表

2.1  

```sql
select product_name,regist_date
from product
where regist_date>='2009-04-28';
```

2.2
三条命令都不会返回结果，要查询空值的话用is null 或者not null

2.3

```sql
select product_name,sale_price,purchase_price
from product
where sale_price>purchase_price+500;

select product_name,sale_price,purchase_price
from product
where sale_price-500>purchase_price;
```

2.4

```sql
select product_name,product_type,0.9*sale_price-purchase as profit
from product
where 0.9*sale_price-purchase>100 and product_type in ('办公用品','厨房用具')
```

3.1
错误有三：第一，sum（）函数后面的字段是字符型的，实际应该是数值型的；
第二，where语句应该放在group by语句前面；
第三，select语句后面出现的不在聚合函数里面的字段必须出现在group by语句后面

3.2

```sql
select product_type,sum(sale_price) as sale_sum, sum(purchase_price) as pur_sum
from product
group by product_type
having sum(sale_price)>1.5*sum(purchase_price);
```

3.3

```sql
select * from product
order by regist_date desc sale_price;
```

4.1

A先生使用begin transaction启动了事务，然后开始执行了insert语句，在A先生commit之前其他用户是看不到A先生更新的结果的，所以B先生查询不会有任何返回值。

4.2

product表的商品编号字段为主键，执行insert  into  product select  * from product语句会违反主键唯一性约束，所以该语句无法执行，表中的数据不会增加为6行。

4.3

```sql
insert into productmargin 
select product_id,product_name,sale_price,purchase_price,sale_price-purchase_price from product;
```

4.4

```
update productmargin set sale_price=3000 where product_name='运动T恤'；
updata productmargin set margin=sale_price-purchase_price where product_name='运动T恤'；
```

5.1

```sql
create view viewpractice5_1 as (
select product_name,sale_price,regist_date
from product
where sale_price>=1000 and regist_date=to_date('2009-09-20','yyyy-mm-dd'));
```

5.2 

向视图插入数据的本质还是向底层表插入数据，现在插入的数据对应的product_id是空的，这违反了主键非空原则，因此执行该语句会报错，无法执行。

5.3

```
select product_id,product_name,product_type,sale_price,
(select avg(sale_price)  from product ) as sale_price_all
from product;
```

5.4

```sql
create view avgpricebytype as 
select t.*, t1.avg_sale_price
from product t left join (select product_type,avg(sale_price) as avg_sale_price
                      from product
                      group by product_type) t1
                      on t.product_type=t1.product_type;
```

6.1

(1)取出的记录为两条，如下表所示

| product-_name | purchase_price |
| ------------- | -------------- |
| 打孔器        | 320            |
| 擦菜板        | 790            |

另外有两条记录，叉子和圆珠笔因为他们的进货单价为null，无法参与not in的比较，因此这两条记录不会被返回。

（2）该语句不会返回任何记录，因为not in后面的条件中有null，因此上一问中返回的两条记录和购买单价为null的叉子圆珠笔都不会被返回。

6.2

```sql
select sum(case when sale_price<1000 then 1 else 0 end) as low_price,
sum(case when sale_price between 1001 and 3000 then 1 else 0 end) as mid_price,
sum(case when sale_price>3001 then 1 else 0 end) as high_price
from product;
```

7.1

该sql语句最后返回的还是product的原来的8条记录

7.2

```sql
select coalesce(t.shop_id ,'不确定') as shop_id,
coalesce (t.shop_name,'不确定') as shop_name,
t1.product_id,t1.product_name,t1.sale_price
from shopproduct t outer join product t1
on t.product_id = t1.product_id；
```

8.1

该sql语句的含义是按照product_id 升序排序，选出截止到当前记录为止sale_price的最大值

8.2

```sql
select regist_date,product_name,sale_price,
sum(sale_price) over(order by coalesce(regist_date , to_date('0001-01-01','yyyy-mm-dd'))) as cum_sum_price 
from product;
```

9.1

```java
import java.sql.*;
public class DBinsert{
    public static viod main(String[] args) throws Exception{
        /*1.Oracle的连接信息*/
        Connection  con;
        Statement st;
        ResultSet rs;
        
        String url='jdbc:Oracle://198.66.152.71:1521/shop';
        String user='homework';
        String password='homework';
        /*2. 定义JDBC驱动*、
        Class.forName("org.plsql.Driver");
        /*3.连接oraclle*/
        con=DriverManager.getConnection(url,user,password);
        st=con.createStatement();
        
        /*4.执行sql语句*/
        int rs=st.executeUpdate("insert into product values('0001','T恤衫','衣服',1000,500,'2009-09-20') ");
        int rs=st.executeUpdate("insert into product values('0002','打孔器','办公用品',500,320,'2009-09-11') ");
        int rs=st.executeUpdate("insert into product values('0003','运动T恤衫','衣服',4000,2800,NULL) ");
        
        /*5.断开与oracle的连接*/
        st.close();
        con.close();
    }
}
```

9.2

```java
import java.sql.*;
public class DBinsert{
    public static viod main(String[] args) throws Exception{
        /*1.Oracle的连接信息*/
        Connection  con;
        Statement st;
        ResultSet rs;
        
        String url='jdbc:Oracle://198.66.152.71:1521/shop';
        String user='homework';
        String password='homework';
        /*2. 定义JDBC驱动*、
        Class.forName("org.plsql.Driver");
        /*3.连接oraclle*/
        con=DriverManager.getConnection(url,user,password);
        st=con.createStatement();
        
        /*4.执行sql语句*/
        int rs=st.executeUpdate("update product set product_name='Y恤衫' where 
        product_id='0001'");
        System.out.println(rs + "行已更新");
        
        
        /*5.断开与oracle的连接*/
        st.close();
        con.close();
    }
}
```


select  gender,  university ,count(id) as user_num,
round(avg(active_days_within_30),1) as avg_active_day,
round(avg(question_cnt),1)  as  avg_question_cnt
from user_profile1
group by  gender , university;



select t.university,t.id,t2.difficult_level
from   user_profile1  t  left  join  question_practice_detail  t1
on t.device_id=t1.device_id 
left  join question_detail t2
on t1.question_id =t2.question_id
where t.university="山东大学"
 

select university,device_id,gpa
from(
select  university,device_id,gpa,
dense_rank()  over(partition by university order gpa ) as rn
 from user_profile1) t 
where rn=1;


select   u.university,u.device_id,count(*) as question_cnt,
sum(case when result='right' then 1 else 0 end ) as right_question_cnt
from  user_profile1  u  left  join(
select *
from(
select   device_id,result,question_id,
substr(workdate,7,1) as month
from 
question_practice_detail ) t 
where month='8';)  t1
on u.device_id=t1.device_id
where u.university='复旦大学';
group by u.university,u.device_id





