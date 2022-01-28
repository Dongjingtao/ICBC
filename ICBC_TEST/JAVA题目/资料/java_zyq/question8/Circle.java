package newemp.work.question8;

public class Circle {
  double radius;

  public Circle(){
    radius = 0;
  }
  public Circle( double r){
    radius = r;
  }

  public double getRadius() {
    return radius;
  }
  public double getPerimeter(){
    return 2*radius*Math.PI;
  }
  public double gerArea(){
    return radius*radius*Math.PI;
  }
  public void disp(){
    System.out.println("半径为"+this.radius);
    System.out.println("周长为"+this.getPerimeter());
    System.out.println("面积为"+this.gerArea());
  }
}
