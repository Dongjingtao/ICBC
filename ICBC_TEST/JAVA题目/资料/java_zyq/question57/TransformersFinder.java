package newemp.work.question57;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TransformersFinder {
  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<?> printClass = null;
    List<KeyValueDto> list = new ArrayList();

    Scanner sc = new Scanner(System.in);
    String path = sc.nextLine();
    List<String> cu = ClazzUtils.getClazzName(path,true);
    for(int i = 0; i<cu.size();i++) {
      System.out.println(cu.get(i));
//      try {
//        //获取类名的包名地址
//        printClass = Class.forName(path + cu.get(i));
//        //java反射机制获取所有方法名
//        Method[] declaredMethods = printClass.getDeclaredMethods();
//        //遍历循环方法并获取对应的注解名称
//        for (Method declaredMethod : declaredMethods) {
//          String isNotNullStr = "";
//          // 判断是否方法上存在注解  TransformersInterface
//          boolean annotationPresent = declaredMethod.isAnnotationPresent(TransformersInterface.class);
//          if (annotationPresent) {
//            // 获取自定义注解对象
//            TransformersInterface methodAnno = declaredMethod.getAnnotation(TransformersInterface.class);
//            // 根据对象获取注解值
//            isNotNullStr = methodAnno.name();
//          }
//          list.add(new KeyValueDto(declaredMethod.getName(), isNotNullStr));
//        }
//        //排序(按照方法名称排序)
//        Collections.sort(list);
//        System.out.println(list.toString());
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
    }
    sc.close();
  }
}
