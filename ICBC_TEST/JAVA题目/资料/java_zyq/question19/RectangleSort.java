package newemp.work.question19;

public class RectangleSort {
  public static void main(String arg[]){
    double xs[]={1,9,3,5,6};
    double ys[]={10,11,4,7,13};
    Rectangle rects[]= new Rectangle[25];
    for(int i=0;i<Math.min(xs.length,ys.length);i++){
      rects[i] = new Rectangle(xs[i],ys[i]);
    }
    for(int i=0;i<Math.min(xs.length,ys.length)-1;i++){
      for (int j=i+1;j<Math.min(xs.length,ys.length);j++){
        if (rects[i].area()>rects[i].area()){
          Rectangle temp = rects[i];
          rects[i]=rects[j];
          rects[j]=temp;
        }
      }
    }

    for(int i=0;i<Math.min(xs.length,ys.length);i++){
      System.out.println(rects[i].area());
    }
  }
}
