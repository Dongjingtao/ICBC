package newemp.work.question16;

public class Car {
  String brand;
  double engineDisplacement;
  double speed;
  boolean status =false ;
  double maxSpeed;

  public Car() {
  }

  public Car(String brand, double engineDisplacement, double maxSpeed) {
    this.brand = brand;
    this.engineDisplacement = engineDisplacement;
    this.maxSpeed = maxSpeed;
  }


  public void setBrand(String brand) {
    this.brand = brand;
  }

  //  public Car(String brand, double engineDisplacement, double maxSpeed){
//    this.brand=brand;
//    this.engineDisplacement=engineDisplacement;
//    this.maxSpeed=maxSpeed;
//  }
  public void start(){
    status = true;
    System.out.println(status);
    System.out.println(speed);
  }
  public void speedUp() {
    if (speed + 5 > maxSpeed) {
      speed=maxSpeed;
    } else {
      speed += 5;
    }
    System.out.println(status);
    System.out.println(speed);
  }

  public void slowDown() {
    if (speed - 5 > 0) {
      speed-=5;
    } else {
      speed = 0;
    }
    System.out.println(status);
    System.out.println(speed);
  }

  public void stop(){
    while(speed>0){
      this.slowDown();
    }
    status = false;
    System.out.println(status);
    System.out.println(speed);
  }
}
