package newemp.work.question25;

public class TestArraySum {

  public int arraySum(int[] A){
    int sum = 0;
    for(int i=0;i<A.length;i++){
      sum += A[i];
    }
    return sum;
  }

  public static void main(String arg[]){
    int a[]={11,12,13,14,15,16,17,18,19,20};
    TestArraySum test = new TestArraySum();
    System.out.println(test.arraySum(a));
  }
}
