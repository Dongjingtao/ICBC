package newemp.work.question17;

public class Car extends Vehicle{
  public Car(String name, String brand, double loadCapacity, double maxSpeed) {
    super(name, brand, loadCapacity, maxSpeed);
  }

  public void move(){
    System.out.println("汽车启动");
  }
  public void stop(){
    System.out.println("汽车停止");
  }
}
