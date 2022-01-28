package newemp.work.question24;

public class SortArray {
  public static void main(String arg[]){
    int a[]={20,10,50,40,30,70,60,80,90,100};
    for (int i = 0; i< a.length-1;i++){
      for (int j = i+1; j<a.length;j++){
        if(a[i]<a[j]){
          int temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
    for (int i = 0; i< a.length;i++){
      System.out.print(a[i]+" ");
    }
  }
}
