package newemp.work.question18;

public class Outer {
  String name;
  int i;
  public Outer(){
    name="Outer";
    i=20;
  }
  Inner x = new Inner();
  class Inner{
    public Inner(){
      name="Inner";
      i=10;
    }
    String name;
    int i;
    public void printInfo(){
      System.out.println(Outer.this.name);
      System.out.println(Outer.this.i);
      System.out.println(this.name);
      System.out.println(this.i);
    }
  }
}
