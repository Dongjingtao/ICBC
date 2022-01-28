package newemp.work.question17;

public abstract class Vehicle {
  String name;
  String brand;
  double loadCapacity;
  double load;
  double speed=0;
  double maxSpeed;

  public Vehicle(String name,String brand,double loadCapacity,double maxSpeed){
    this.name=name;
    this.brand=brand;
    this.loadCapacity=loadCapacity;
    this.maxSpeed=maxSpeed;
  }

  public abstract void move();

  public void speedUp(){
    if (speed + 5 > maxSpeed) {
      speed=maxSpeed;
    } else {
      speed += 5;
    }
    System.out.println("Now the speed is:"+speed);
  }

  public void slowdown(){
    if (speed - 5 > 0) {
      speed-=5;
    } else {
      speed = 0;
    }
    System.out.println("Now the speed is:"+speed);
  }

  public abstract void stop();
}
