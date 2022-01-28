package newemp.work.question5;

public class MyPoint {
  private int x;
  private int y;

  public MyPoint(){
    x = 0;
    y = 0;
  }
  public MyPoint(int x,int y){
    this.x = x;
    this.y = y;
  }
  public float getD(MyPoint p){
    return (float)Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
  }
}
