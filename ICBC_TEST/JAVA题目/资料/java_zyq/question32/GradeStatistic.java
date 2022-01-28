package newemp.work.question32;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeStatistic {
  class Mark{
    String name;
    int score;
    public Mark(String name,int score){
      this.name=name;
      this.score=score;
    }
  }

  public static void main(String arg[]) {
    ArrayList<Mark> arr1 = new ArrayList<Mark>();
    Scanner scan = new Scanner(System.in);
    double sum=0;
    while (true){
      String m = scan.next();
      if(m.equals("end")){break;}
      int n = scan.nextInt();
      Mark temp = new GradeStatistic().new Mark(m,n);
      arr1.add(temp);
    }
    Mark []b = new Mark[arr1.size()];
    for (int i=0;i<arr1.size()-1;i++){
      for (int j =i+1; j<arr1.size();j++){
        if(arr1.get(i).score<arr1.get(j).score){
          Collections.swap(arr1,i,j);
        }
      }
    }
    for (int i=0;i<arr1.size();i++){
      sum+=arr1.get(i).score;
    }
    System.out.println("平均分为："+1.0*sum/ arr1.size());
    System.out.println("最高分为："+arr1.get(0).score);
    System.out.println("最低分为："+arr1.get(arr1.size()-1).score);
    System.out.println("成绩单如下：");
    for (int i=0;i<arr1.size();i++){
      System.out.print(arr1.get(i).name+" "+ arr1.get(i).score+"\n");
    }
    scan.close();
  }
}
