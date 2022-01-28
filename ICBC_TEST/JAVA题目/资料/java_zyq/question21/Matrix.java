package newemp.work.question21;

public class Matrix {
  int m[][]=new int[100][100];
  int row;
  int column;

  public Matrix(){
    row=0;
    column =0;
  }

  public Matrix(int b[][]){
    for (int i=0;i<b.length;i++){
      for (int j=0;j<b[0].length;j++){
        m[i][j]=b[i][j];
      }
    }
    column = b.length;
    row = b[0].length;
  }

  public void show(){
    for (int i =0;i<column;i++){
      for (int j = 0;j<row;j++){
        System.out.print(m[i][j]+"  ");
      }
      System.out.print("\n");
    }
  }

  public Matrix multi(Matrix a){
    int [][]b=new int[this.column][this.column];
    for (int i=0;i<this.column;i++) {
      for (int j=0;j<this.column;j++){
        int point = 0;
        for (int k=0;k<this.column;k++){
          point+=this.m[i][k]*a.m[k][j];
        }
        b[i][j]=point;
      }
    }
    Matrix c = new Matrix(b);
    return c;
  }
}
