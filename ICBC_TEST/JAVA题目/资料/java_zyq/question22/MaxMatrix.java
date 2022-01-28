package newemp.work.question22;

import newemp.work.question21.Matrix;

public class MaxMatrix {
  double [][]a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16},{17,18,19,20}};
  double maxnum;
  int x;
  int y;
  public void findMax(){
    maxnum = a[0][0];
    x=0;
    y=0;
    for (int i=0;i<4;i++){
      for(int j=0;j<5;j++){
        if(a[j][i]>maxnum){
          y = j+1;
          x = i+1;
        }
      }
    }
  }
  public static void main(String arg[]){
    MaxMatrix test=new MaxMatrix();
    test.findMax();
    System.out.println("横坐标为："+test.x);
    System.out.println("纵坐标为："+test.y);
  }
}
