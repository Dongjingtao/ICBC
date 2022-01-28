package newemp.work.question31;
import java.util.ArrayList;
import java.util.Collections;

public class StuScore {
    public static void main(String arg[]) {
    ArrayList <Student> al=new ArrayList <Student> ();

    for(int i=20070301,j=10;i<=20070330;i++,j++) {
          al.add(new Student(i));
    }
    Collections.sort(al, new SortbyScore());
    for(Student sd:al)
      System.out.println(sd);
  }
}
