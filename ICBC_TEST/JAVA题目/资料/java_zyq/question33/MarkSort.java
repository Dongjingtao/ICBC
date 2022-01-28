package newemp.work.question33;
import newemp.work.exp.MyException;

import java.io.IOException;
import java.util.Scanner;

public class MarkSort {
  public void sort(int a[]){
    for(int i=0; i< a.length;i++){
      for (int j=i+1;j<a.length;j++){
        if(a[i]<a[j]){
          int temp=a[i];
          a[i]=a[j];
          a[j]=temp;
        }
      }
    }
  }

  public static  void  main(String[] args) throws MyException {
    MarkSort ms =new MarkSort();
    int []a = new int[10];
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    String[] strArr = s.split(" ");
    if(strArr.length<10){
      throw new MyException("请输入至少10个成绩");
    }
    for(int i = 0; i < 10; i++){
      try {
        a[i] = Integer.parseInt(strArr[i]);
      }
      catch (NumberFormatException e){
      }
      finally {
        throw new MyException("请输入成绩");
      }
    }
    scan.close();

    ms.sort(a);
    for(int i = 0; i < 10; i++){
      System.out.println(a[i]);}
  }
}
