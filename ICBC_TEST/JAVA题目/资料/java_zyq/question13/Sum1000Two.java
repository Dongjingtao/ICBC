package newemp.work.question13;

public class Sum1000Two {
  public static void main(String[] args) {
    int temp = 0;
    for (int i = 11; i <= 10000; i++) {
      temp += i;
    }
    System.out.println(temp/10.0);
  }
}