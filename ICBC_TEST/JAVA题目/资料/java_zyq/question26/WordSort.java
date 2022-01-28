package newemp.work.question26;

public class WordSort {
  public static void main(String arg[]) {
    String a[] = {"hello", "world", "welcome", "hi", "he"};
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i].compareTo(a[j]) > 0) {
          String temp = a[i];
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