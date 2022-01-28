package newemp.work.question8;

public class Cylinder extends Circle{
  double height;
  public Cylinder( double r, double h){
    radius = r;
    height = h;
  }

  public double getHeight() {
    return height;
  }
  public double getCylinderArea(){
    return radius*radius*Math.PI*2 + 2*radius*Math.PI*height;
  }
  public double getVol(){
    return radius*radius*Math.PI*height;
  }
  public void dispVol(){
    System.out.println(this.getVol());
  }
}
