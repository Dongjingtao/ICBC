# Linux基础

## 基础 （3*15=45）

1.选择 

Linux 系统的各种资源都当作文件,都按其作用分门别类地放在相关的目录中，对于外部设备文件，一般应将其放在哪个目录中（           ）

A. /bin B /etc  C /dev  D /usr



2.判断

分页式存储管理中，在一个系统中，根据需要，页面的大小是可以不相等的，这样的说法正确吗？(            )



 3.选择

以下命令可以用于获取本机cpu使用率的是  （                  ）

A.ifconfig     B free    C top    D netstat

 

4.选择 

以下哪个命令不可以查看当前系统的启动时间 （                  ）

A  w    B  top   C ps    D  uptime

 

5,选择

bash中，需要将脚本demo.sh的标准输出和标准错误输出重定向至文件demo.log，以下用法是错误的（            )

A  bash demo.sh &>demo.log

B  bash demo.sh >& demo.log

C  bash demo.sh >demo.log 2>&1

D  bash demo.sh 2>demo.log 1>demo.log

 

6，选择 

在 bash shell 环境下，当一命令正在执行时，按下 control-Z 会（                  ）

A 中止前台任务

B 给当前文件加上EOF

C 将前台任务转入后台

D 取消前台任务

 

7,选择

if [ $2 -a $2 = "test" ] 中 -a 是什么意思（                   ）

A 大于    B  减   C 全部  D 并且



8，选择 

如何获取上一条命令执行的返回码（           ）

A  $!    B   $0     C  $?    D $#

 

9，选择 

采用bash执行shell脚本时加上哪个参数可以跟踪执行脚本过程（            ）

A     -x          B    -u    C   -f    D     -p

 

10, 选择 

能够将shell程序中的本地变量设置为环境变量的命令是（                    ）

A  global         B   public    C  set   D export

 



11.选择 

假设在shell中执行的脚本为：./prog.sh "p1" "p2" "p3 p4"，而我们要在脚本prog.sh中获取参数，应该使用(              )

A  $@    B    $*   C $#   D $?

 



12.选择 

用 ls -al 命令列出下面的文件列表，哪个文件是符号连接文件（                          ）

A   -rw-rw-rw- 2 hel-s users 56 Sep 09 11:05 hello

B    brwxrwxrwx 2 hel-s users 56 Sep 09 11:05 goodbye

C    drwxr--r-- 1 hel users 1024 Sep 10 08:10 zhang

D    lrwxr--r-- 1 hel users 2024 Sep 12 08:12 cheng > peng.yan1

 

13，选择

当内网内没有条件建立dns服务器，又不想用IP访问网站，应配置什么文件 (           )

A    hosts   B  sysconfig   C  network   D  hostname

 

14 选择

如果系统的 umask 设置为 244，创建一个新文件它的权限是（               ）

A   --w-r--r--          B    -r-xr--r--    C  -r---w--w-    D  -r-x-wx-wx

 

15 选择  

使用什么命令把两个文件的合并成一个文件(       )

A   cat    B    append   C   awk    D join





## shell编程1(20)

有一个日志文件 access.log,内容如下

```bash
192.168.1.20 - - [21/Apr/2020:14:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.21 - - [21/Apr/2020:15:27:49 +0800] "GET /2/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [21/Apr/2020:21:27:49 +0800] "GET /3/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.23 - - [21/Apr/2020:22:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.24 - - [22/Apr/2020:15:27:49 +0800] "GET /2/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.25 - - [22/Apr/2020:15:26:49 +0800] "GET /3/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.20 - - [23/Apr/2020:08:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.21 - - [23/Apr/2020:09:20:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [23/Apr/2020:10:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [23/Apr/2020:10:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.20 - - [23/Apr/2020:14:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.21 - - [23/Apr/2020:15:27:49 +0800] "GET /2/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [23/Apr/2020:15:27:49 +0800] "GET /3/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.25 - - [23/Apr/2020:16:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.24 - - [23/Apr/2020:20:27:49 +0800] "GET /2/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.25 - - [23/Apr/2020:20:27:49 +0800] "GET /3/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.20 - - [23/Apr/2020:20:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.21 - - [23/Apr/2020:20:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [23/Apr/2020:20:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.22 - - [23/Apr/2020:15:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
192.168.1.21 - - [23/Apr/2020:20:27:49 +0800] "GET /1/index.php HTTP/1.1" 404 490 "-" "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:45.0) Gecko/20100101 Firefox/45.0"
```

请用shell 编程完成如下功能 ：

请统计出2020年4月23号的访问ip次数，并且按照次数降序排序

结果输出示例

```
5 192.168.1.22

4 192.168.1.21

3 192.168.1.20

2 192.168.1.25

1 192.168.1.24
```



## shell编程2（35）

HTTP服务器上有若干个压缩的报表文件，报表文件名的格式是  包名-日期(yyyymmdd)-场次.gz，例如 (crs-20211201-1.gz)

编写一个shell: getReport.sh，根据一个配置文件config.ini从服务器上获取相关的报表文件，并且解压缩还原成文本文件保存到磁盘上。

服务器的地址，报表的包名，场次需要从配置文件config.ini中读取，报表文件的日期需要从命令行参数获取。

需要判断服务器上文件是否存在，如果不存在要明确提示并退出。

测试文件位置 107.22.157.66:1080/datafile/crs-20211224-1.gz

例如命令  

```
./getReport.sh 20211201
```

