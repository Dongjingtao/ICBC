package newemp.work.question1;

public class Suansu {
  int a;
  int b;

  public Suansu(){
    a=10;
    b=5;
  }
  public Suansu(int x,int y){
    a=x;
    b=y;
  }

  public int addAB() {
    return a+b;
  }

  public int subAB() {
    return a-b;
  }

  public int multiAB() {
    return a*b;
  }
  public double divAB() {
    return (1.0*a/b);
  }

}
