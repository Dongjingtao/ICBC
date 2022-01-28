package newemp.work.question56;
import newemp.work.question56.testPackage.Vehicle;

import java.util.Scanner;


public class ClassFinder {
  public static void main(String[] args)  throws InstantiationException, IllegalAccessException{
    //1.获取Class对象
    Scanner sc = new Scanner(System.in);
    String className=sc.nextLine();
    try {
      Class clazz = Class.forName(className);

      //利用Class对象的newInstance方法创建一个类的实例
      Vehicle obj = (Vehicle) clazz.newInstance();
      obj.move();
    }catch (ClassNotFoundException e){
      System.out.println("类不存在");
    }
  }
}
