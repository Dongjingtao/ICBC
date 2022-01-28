# java_basic_stage_4



## 28.

设有一个英文单词构成的字符串数组,编写程序 StatisticsWord.java实现 

(1)统计以字母w开头的单词数。

(2)统计单词中含or字符串的单词数。

(3)统计长度为3的单词数。

## 29.

设有3个数组定义如下：

string x[] = {"zero","one","two","three","four","five","six", seven",eight","nine"};

String y[] = ("ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen", "seventeen","eighteen","nineteen");

string z[] = ("twenty", "thirty","fourty","fifty","sixty","seventy","eighty" ,"ninety");

试编写一个翻译程序 Translate.java,实现用Java命令行输入一个小于100的整数,其翻成英文表示,输入英文则输出相应的整数
例如

输入32,输出： thirty two

输入8,输出： eight

输人 fourteen,输出14



## 30.

编写一个程序 ShowDatetime.java, 输出当前日期和当前时间。要求当前日期的格式为年月日；当前时间的格式为时分秒,

比如：2021年12月20日 12点20分20秒 星期三

## 31.

某班30个学生的学号为20070301~20070330,全部选修了Java程序设计课程,

学生信息包括 学号，姓名（随机生成），性别（随机男女），成绩(实现时可用随机数产生,范围为60~100),

请编写一个程序StuScore.java将该班的Java程序设计课程成绩按高到低排序打印输出。

要求分别用List和Map来存储学生信息，并遍历打印,如下所示例如

20120324 张  三 男 95
20120310 李丽芳 女 90
20120302 王小五 男 88

## 32.

编写一个Java程序成绩统计程序,输入一个班的java成绩(含姓名和分数),统计出平均分、最高分、最低分,并打印成绩单。

由于编程时人数不确定,所以要求使用 Vector或ArrayList完成上述程序。

要求学生成绩用一个类Mark表示,其成员变量包含考生姓名、成绩。输入的姓名为end时,程序结束。

主类的名称叫做 GradeStatistic,将Mark设计为Gradestatistic的内部类

提示：键盘输入采用 Scanner类,实例化采用下述语句

Scanner sc = new Scanner(System.in);

然后通过sc调用Scanner的各种方法输入相应的数据。如用next()方法读入一个字符串，nextInt()读入一个整数, nextDouble()方法读入一个双精度数。
输入完毕后用sc.close()释放sc对象。



## 33.

编写一个程序,从命令行参数输入10个数作为学生成绩,需对成绩进行有效性判断,若成绩有误则通过异常处理显示错误信息,并将成绩按高到低排序打印输出。

提示：如果输入数据不为整数,要捕获 Integer.parseInt()产生的异常,显示“请输入成绩”,捕获输入参数不足10个的异常,显示“请输入至少10个成绩”。



## 34.

编写一个银行类Bank,要求如下
1)变量 balance为存款余额。

2) deposite()方法为存款操作
3) drawa()方法为取款操作
4) getbalawal()方法为获取余额操作,如果银行余额少于取款额时,显示当前余额,并告知不能取款的提示,否则显示取款成功的信息。要求用自定义异常来处理余额不足的问题



## 35.

自定义两个异常,一个叫 EmptyStackException,其默认的异常信息是“堆栈空！”；另个叫做 FullStackException,其默认的异常信息是“堆栈满！”。

应用泛型编写一个堆栈类 MyStack,元素可以是任何引用类型的对象, MyStack的构造方法指定堆栈的大小, MyStack类中包括push()、pop()、 ,isEmpty()、isFull()方法。 push()方法申明抛出 FullStackException异常,pop()方法申明抛出 EmptyStackException。编写单元测试类 TestMyStack,创建一个元素为 String,大小为5的堆栈,并使用其方法进行进栈出栈等操作

## 36.

编写一个程序 ReadText.java,判断当前日录下 myText.txt是否存在,若存在则输出其长度，并按行顺序地读取文件的内容并打印输出。

如果不存在则告警推出

## 37.

编写一个程序 WriteLog.java实现如下功能：从键盘输入若干行文字(包含中文),当最后一行输入quit#时,退出程序且将输入内容除quit#外全部存入文件log。

尝试在windows上和linux上打开并阅读这个文件。

## 38.

编写一个程序 WordStntiatic.java,读取文件MyText.txt 统计其中的英文字母的大写个数和小写字母个数,并将结果输出