package newemp.work.question15;

public class Rectangle implements Arealnterface {
  int x;
  int y;

  public Rectangle(){
    this.x = 5;
    this.y = 2;
  }
  public Rectangle(int x, int y){
    this.x = x;
    this.y = y;
  }
  public double area(){
    return x*y;
  }
  public String toString(){
    return "该长方形面积为："+area();
  }
}
