package newemp.work.question10;

public class Rectangle implements Shape {
  int length;
  int width;
  public Rectangle(int x, int y){
    length = x;
    width = y;
  }
  public double getArea(){
    return length*width;
  }
}
