# Java Basic Stage 2



## 9.

按以下要求编写程序
(1)定义一个Shape接口,该接口中只有一个抽象方法 getArea(),该方法无参数,返回值类型为 double型
(2)定义一个圆类 Circle,满足以下条件。
Circle类实现 Shape接口。
定义Circle类的成员变量r,表示圆的半径,数据类型为int
定义Circle类的构造方法,参数名为r,用该参数初始化圆的半径
实现 getArea()方法,计算圆的面积(圆周率取3.14)
(3)编写一个测试类,类名为 TestCircle,利用Circle类计算半径为5的圆的面积,并将面积在屏幕打印出来

## 10.

定义一个接口 Shape,其中包括一个方法area(),设计“三角形”、“圆”、“长方形”等类实现 Shape接口。分别创建一个“三角形”、“圆”、“长方形”对象存入一个类型为Shape的数组中,将数组中各类图形的面积输出。

## 11.

请编程实现以下要求：
(1)定义一个接口 DataStructure,包括以下方法
Boolean isFull()
Boolean isEmpty()
Void addElement(Object obj)
Object removeElement()
(2)设计一个队列类(MyQueue)实现 DataStructure接口。队列的大小由其构造方法指定。要求实现的方法体现出队列的先进先出的特性。
(3)设计一个测试类,在其主方法中用 DataStructure类型的引用变量引用一个大小为10的 MyQueue对象,使用 addElement(方法增加“0”,“1”,…,“9”共10个字符串对象,再用 removeElement()方法取出这些元素并打印出来。

## 12.

按以下要求编程程序。
(1)编写一个抽象类 Animal,其成员变量有 name, age, weight表示动物名、年龄和质量。(方法有 showInfo()、move()和eat(),其中后面两个方法是抽象方法。
(2)编写类Bird继承 Animal,实现相应的方法。通过构造方法给name、age和weight分别赋值, showInfo()打印鸟名、年龄和质量, move()方法打印鸟的运动方式,eat()打印鸟喜欢吃的食物。
(3)编写测试类 TestAnimal,用 Animal类型的变量,调用Bird对象的三个方法。

## 13.

编写程序求和： 1+2+3+.....+999+1000
编写程序求和： 1.1+1.2+1.3+.....+999.9+1000

## 14.

为管理学校中教师的工作证和学生的学生证设计个类体系结构,尽可能保证代码的重用率。假设教师工作证包括编号、姓名、出生年月、部门、职务和签发工作日期；学生证包括编号、姓名、出生年月、学院、专业、入校时间及每学年的注册信息等。

## 15.

按以下要求编写程序
(1)定义接口 Arealnterface,该接口有一个双精度浮点型的常量PI,它的值等于Math.PI；含有一个求面积的方法 double area()。
(2)定义一个 Rectangle(长方形)实现 AreaInterface接口,该类有两个 private 访问权限的双精度浮点型变量x(长)和y(宽)；定义一个public访问权限的构造方法,用来给类变量赋值；实现area()方法得到长方形的面积；定义toString()方法,返回一段字符串信息,内容如下格式："该长方形面积为：" + 面积
(3)定义一个 TestArea类,在它的main()方法中；创建一个 Rectangle的实例,长为10.0,宽为20.0,输出它的面积。

## 16.

编写一个汽车类Car
Car具有以下属性
品牌： brand,类型为 String；发动机排量： engineDisplacement,类型为 double；速度speed,类型为 double；状态：status,类型为 boolean；最高时速：maxSpeed,类型为double
Car具有以下方法
构造方法：Car( String brand, double engineDisplacement, double maxSpeed),该方法使用参数设置成员变量的值。
启动： start(),该方法使得 status的值变成true
加速： speedUp(),当汽车处于启动状态时,该方法每调用一次,速度增加5,但速度不得高于最高时速
减速： slow Downo,当汽车处于启动状态时,该方法每调用一次,速度减5,但速度不得小于0
熄火： stop(),当speed为零时,将 status的值变成 false
每个方法除了改变成员变量的之外,还要打印出方法执行后的状态和速度。
编写main方法实例化一个Car对象,其品牌为“红旗”,排量为2.0,最高时速为160.00,启动该汽车,加速到120,再减速到0,最后熄火

## 17.

运输工具 Vehicle都有名称(name)、品牌( brand)、最大载重量(loadCapacity)、当前载重量(load)、最高速度(maxSpeed)、速度(speed)等属性,也都有移动(move)、加速(speedUp)、
减速(slow Down)、停止(stop)等方法。飞机 Plane、汽车Car、轮船Ship,马车Wagon概不例外。虽然都有move和stop方法,但其实现不同。其他方法的实现相同。
请编写相应的类,尽量少写相同的代码。编写一个测试类 TestVehicle,在其main方法中声明一个Vehicle类型的引用变量 vehicle,分别引用一个 Plane、Car、Ship、 Wagon对象,并执行相应的方法

## 18.

在一个类 Outer中定义了属性name和i,其构造方法将name赋值为 Outer,i赋值为20,在 Outer中定义一个内部类Inner,也定义了属性name和i,并将其初始化为Iner和10；在内部类中编写一个方法 printInfo(),输出外部类和内部类中所有的属性值。

