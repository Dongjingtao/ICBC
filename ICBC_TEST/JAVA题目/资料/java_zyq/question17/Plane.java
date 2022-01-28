package newemp.work.question17;

public class Plane extends Vehicle{
  public Plane(String name, String brand, double loadCapacity, double maxSpeed) {
    super(name, brand, loadCapacity, maxSpeed);
  }

  public void move(){
    System.out.println("飞机启动");
  }
  public void stop(){
    System.out.println("飞机停止");
  }
}
