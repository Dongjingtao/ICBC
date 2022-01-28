package newemp.work.question17;

public class Ship extends Vehicle{
  public Ship(String name, String brand, double loadCapacity, double maxSpeed) {
    super(name, brand, loadCapacity, maxSpeed);
  }

  public void move(){
    System.out.println("船启动");
  }
  public void stop(){
    System.out.println("船停止");
  }
}
