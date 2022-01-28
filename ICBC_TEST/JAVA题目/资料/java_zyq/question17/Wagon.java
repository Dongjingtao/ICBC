package newemp.work.question17;

public class Wagon extends Vehicle{
  public Wagon(String name, String brand, double loadCapacity, double maxSpeed) {
    super(name, brand, loadCapacity, maxSpeed);
  }

  public void move(){
    System.out.println("马车启动");
  }
  public void stop(){
    System.out.println("马车停止");
  }
}
