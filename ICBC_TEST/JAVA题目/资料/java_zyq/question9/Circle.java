package newemp.work.question9;

public class Circle implements Shape{
  int r;
  public Circle(int r){
    this.r=r;
  }
  public double getArea(){
    return r*r*3.14;
  }
}
