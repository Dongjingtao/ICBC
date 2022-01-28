package newemp.work.question12;

public class Bird extends Animal{
  public Bird(String a,int b,int c){
    name = a;
    age = b;
    weight =c;
  }
  public void move(){
    System.out.println("飞行");
  }
  public void eat() {
    System.out.println("虫子");
  }
}
