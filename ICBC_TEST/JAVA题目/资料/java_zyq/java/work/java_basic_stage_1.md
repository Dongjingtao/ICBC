# java_basic_stage_1



## 1

编写一个Java程序 Suansu.java,定义两个整型变量a和b,使用构造方法初始化a为10,b为5,并定义求出a与b的和(方法名为addAB)、差(方法名为subAB)、积(方法名为 multiAB)、商(方法名为 divAB)的方法。 用另一个Java程序 TestSuansu.java测试Suansu.java定义的方法,并在屏幕上输出结果。

## 2.

创建一个名为 Rectangle的类来表示一个使用宽度和高度来改变量的矩形,矩形的宽度和高度由构造方法来确定。为 Rectangle类创建下列方法：
getArea返回矩形的面积,要求长和高的范围为0-50
getPerimeter返回矩形的周长
draw使用星号(*)作为描绘字符画出该矩形(假设宽度和高度为整数)
在另一个类 TestRectangle中编写main方法来测试 Rectangle类

## 3.

根据以下的设计要求编写Java源代码。
类名：StudentInfoManager
变量(访问权限均为private)
name,//表示为姓名,类型为String
age, //表示年龄,类型为int
方法如下：
(1)构造方法(没有参数,设置姓名为“无名氏”,年龄为20)。
(2) set name(有一个名为name的 String型参数,将name的值设为这个新值)。
(3) getName(没有参数,返回姓名)
(4) setAge(有一个名为age的int型参数,将age的值设为这个新值)
(5) getAge(没有参数,返回年龄)。
(6) isSameAge(有一个参数s,是另一个 Studen对象的引用,如果两个 Student对象的age相同,则返回true,否则返回false)

## 4.

编写一个复数类 Complex 验证两个复数1+2i和3+4i相加产生一个新的复数4+6i,复数类 Complex必须满足如下要求:
(1)复数类 Complex的属性如下
realpart是int型,代表复数的实数部分。
imaginPart是int型,代表复数的虚数部分。
(2)复数类 Complex的方法如下
Complex()构造方法,将复数的实部和虚数都置0
Complex(int r；int i)构造方法,形参r为实部的初值,i为虚部的初值
Complex complexADD( Complex a)将当前复数对象与形参复数对象相加,所得的结果仍是一个复数值,将其返回给此方法的调用者
String toString把当前复数对象的实部、虚部组合成a+bi的字符串形式,其中,a和b分别为实部和虚部的数据。

## 5.

编写一个表示二维平面上的点的类 MyPoint,满足以下条件
(1)定义 private的成员变量x和y,表示点的x和y坐标,类型为整数。
(2)定义两个 MyPoint的构造方法,一个构造方法不带参数,且x和y的初始值为0,另一个构造方法有两个参数,参数名为x和y,类型为整数,用这两个参数分别作为初始x和y的坐标。
(3)定义一个getD方法,功能为返回两个坐标点(由 MyPoint定义)距离,值为float
(4)编写main方法,打印坐标点(2,3)到点(4,5)的距离。

## 6.

编写一个公共( public)类,类名为 AccountUtil,,该类属于account包,类中包含一个公用静态方法 toSeparateNumber,该方法以一个十进制字符串为参数,返回用逗号隔开的数字字符串,分隔从右边开始,每三个数字用一个逗号隔开。例如,若参数为2367548,则返回2,367,548。若参数为小数,则分隔从小数点开始,例如,若参数为2367548.85,则返回2,367,548.85

## 7.

编写两个类:
classA属于包 package1, classA中有一个方法 methodA(); classB属于包package2,在classB的方法methodB()中调用classA的methodA()方法。每个方法简单地输出方法名即可。

## 8.

按以下要求编写程序。
(1)根据下面的要求实现圆类 Circle
Circle类的成员变量： radius半径。
Circle类的方法成员如下所示
Circle()：构造方法,将半径置为0。
Circle( double r)：构造方法,创建 Circle对象时将半径初始化为r
double getRadius()：获得圆的半径值。
double getPerimeter()：获得圆的周长。
double gerArea()：获得圆的面积。
void disp()：将圆的半径、周长、面积输出到屏幕上。
(2)继承上题中的圆 Circle类,派生圆柱体类 Cylinder,要求如下
Cylinder类的成员变量； height表示圆柱体的高
Cylinder类的方法成员如下所示
Cylinder( double r, double h)构造方法创建 Cylinder对象时将圆半径初始化为r,圆柱高初始化为h。
double getHeight()：获得圆柱体的高。
double getCylinderArea(): 获得圆柱体的面积
double getVol()：获得圆柱体的体积。
void dispVol()：将圆柱体的体积输出到屏幕。

