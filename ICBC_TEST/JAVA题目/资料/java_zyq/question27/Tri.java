package newemp.work.question27;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tri {
  public boolean isDY(int a,int b,int c){
    return (a==b)||(a==c)||(c==b);
  }
  public boolean isDB(int a,int b,int c){
    return (a==b)&&(a==c)&&(c==b);
  }
  public boolean isZJ(int a,int b,int c){
    return ((a*a+b*b)==c*c)||((a*a+c*c)==b*b)||((c*c+b*b)==a*a);
  }
  public boolean isSj(int a,int b,int c){
    return (a+b>c)&&(b+c>a)&&(a+c>b);
  }
  public static void main(String arg[]) throws FileNotFoundException {
    Scanner scan = new Scanner(System.in);
    String[] str = scan.nextLine().split(" "); //字符串以空格分割
    scan.close();
    int a = Integer.parseInt(String.valueOf(str[0]));
    int b = Integer.parseInt(String.valueOf(str[1]));
    int c = Integer.parseInt(String.valueOf(str[2]));

    Tri test = new Tri();
    if(!test.isSj(a,b,c)){
      System.out.println("不是三角");
    }else {
      if(test.isDY(a,b,c)){
        System.out.println("是等腰");
      }
      if(test.isDB(a,b,c)){
        System.out.println("是等边");
      }
      if(test.isZJ(a,b,c)){
        System.out.println("是直角");
      }
    }
  }
}
