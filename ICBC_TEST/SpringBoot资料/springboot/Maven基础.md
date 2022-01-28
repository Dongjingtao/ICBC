# Maven基础

## 1.Maven是什么？

### 	举个栗子：

​	制作糖醋排骨，需要以下材料：

1.小排500g

2.酱油20g

3.盐5g

4.糖20g

5.茴香5g

6.姜

  a.我们去菜市场买小排、茴香、姜，去小卖部买酱油、盐和糖。

  b.如果这个时候我们可以找到大卖场，例如大润发，那么就能够一次性的全部买完就回家了，甚至大卖场可能会有配菜师傅，你说我要一个糖醋排骨的打包半成品，师傅说好，然后你就买好回家了。或者现在可以网上下单，你在家里操作一下手机，就有人给你送过来了。

传统模式的软件开发就像a，而maven等就像b。gradle也跟maven差不多，有兴趣的同学也可以去看看。

这个在前端里也有类似的工具例如npm。



### Maven的功能包含但不仅限于

管理项目依赖

项目构建



## 2.安装及验证

这个在apache官网都有，不赘述，基本同jdk安装。

注意以下配置

C:\Users\shfh-yangc02\\.m2\settings.xml

这个配置中会指定远端仓库的地址（类似大卖场nexus），以及本地仓库的地址（如不指定，默认为C:\Users\shfh-yangc02\\.m2\repository）



### Maven的依赖

maven需要什么？还是刚才的例子，我们需要一个例如大润发的卖场。

这个东西我们现在使用的是nexus。



## 3.Maven项目实战

<img src="maven.asset/%E5%88%9B%E5%BB%BAmaven%E9%A1%B9%E7%9B%AE1.png" alt="image-20200309152552949"  />

<img src="maven.asset/%E5%88%9B%E5%BB%BAmaven%E9%A1%B9%E7%9B%AE2.png" alt="image-20200309152731530"  />

![image-20200309152840164](maven.asset/%E5%88%9B%E5%BB%BAmaven%E9%A1%B9%E7%9B%AE3.png)

POM文件

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.icbc.sh</groupId>
  <artifactId>maventest</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>maventest</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <junit.version>3.8.1</junit.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>

```

## 4.Maven树显示--IDEA演示
