package newemp.work.question23;

public class Diagonal {
  public void makeDiagonalOne(int a[][]){
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[0].length;j++){
        if (i==j){
          a[i][j]=1;
        }else {
          a[i][j]=0;
        }
      }
    }
  }
  public static void main(String arg[]){
    Diagonal test = new Diagonal();
    int [][]a = new int[5][5];
    test.makeDiagonalOne(a);
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[0].length;j++){
        System.out.print(a[i][j]+" ");
        }
      System.out.print("\n");
      }
    }
  }