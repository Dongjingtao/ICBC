package newemp.work.question40;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RecordScore {
  public static void main(String arg[]) throws Exception {
    ArrayList<Mark> arr1 = new ArrayList<Mark>();
    Scanner scan = new Scanner(System.in);
    double sum = 0;
    double avg;

    FileOutputStream fos1 = new FileOutputStream("score.utf-8.txt");
    FileOutputStream fos2 = new FileOutputStream("score.gbk.txt");
    PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(fos1,"utf-8"));
    PrintWriter writer2 = new PrintWriter(new OutputStreamWriter(fos2,"gbk"));

    while (true) {
      String m = scan.next();
      if (m.equals("end#")) {
        break;
      }
      int n = scan.nextInt();
      Mark temp = new Mark(m, n);
      arr1.add(temp);
      writer1.write(m+" "+n+"\r\n");
      writer2.write(m+" "+n+"\r\n");
    }
    for (int i=0;i<arr1.size();i++){
      sum+=arr1.get(i).score;
    }
    avg = 1.0*sum/arr1.size();
    writer1.write("平均成绩为："+avg);
    writer2.write("平均成绩为："+avg);
    writer1.close();
    writer2.close();
  }
}
