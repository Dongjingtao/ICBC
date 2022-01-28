package newemp.work.question12;

public abstract class Animal {
  public String name;
  public int age;
  public int weight;
  public void showInfo(){
    System.out.println(name);
    System.out.println(age);
    System.out.println(weight);
  }
  public abstract void move();
  public abstract void eat();
}
