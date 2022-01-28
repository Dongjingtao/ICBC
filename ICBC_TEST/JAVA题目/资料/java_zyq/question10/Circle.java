package newemp.work.question10;

public class Circle implements Shape {
  int r;
  public Circle(int r){
    this.r=r;
  }
  public double getArea(){
    return r*r*Math.PI;
  }
}
