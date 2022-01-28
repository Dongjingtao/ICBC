47.

设计一个使用socket的聊天程序，分为客户端和服务段，服务端程序在8888端口监听客户端程序的请求。

客户端键盘读取输入，并发送给服务方。

连接后，服务端在终端打印客户端发送的信息；

如果键盘输入bye，客户端发送数据之后自行退出， 服务端程序收到bye并打印之后也自行退出。





48.

根据db.txt的脚本内容，创建表EXAM_CONTRACT，导入数据，并编写java程序，连接数据库，对表EXAM_CONTRACT记录进行查询并输出，一条记录输出一个json，格式如下：（字段的顺序不做要求）

```json
{
  "company": "123",
  "contract_no": "123",
  "valid_date": "12341123",
  "customer": "abc",
  "start_date": "12341234",
  "end_date": "23211234"
}
```

49.

接上题，编写一个程序，程序从键盘读入company， contract_no，valid_date，customer，start_date以及end_date的值，然后将这些值，作为一条记录，插入表EXAM_CONTRACT中

50.

接上题，编写一个程序，从键盘读入customer的值，将表EXAM_CONTRACT中的对应的customer的记录中的end_date改为今天日期

51.

接上题，编写一个程序，从键盘读入contract_no的值，将表EXAM_CONTRACT中的对应的contract_no的记录删除。



52.

有一份数据status.csv，大约50万条数据，尽可能快地导入数据库里面。

提示:preparestatement和batch操作。

