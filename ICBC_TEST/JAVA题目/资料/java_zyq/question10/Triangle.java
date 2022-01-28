package newemp.work.question10;

public class Triangle implements Shape {
  int side1;
  int side2;
  int side3;
  public Triangle(int a,int b,int c){
    side1=a;
    side2=b;
    side3=c;
  }
  public double getArea(){
    return Math.sqrt((side1+side2+side3)*(side1+side2-side3)*(side1-side2+side3)*(side2+side3-side1))*0.25;
  }
}
