package newemp.work.question4;

public class Complex {
  int realpart;
  int imaginPart;

  public Complex(){
    realpart=0;
    imaginPart=0;
  }
  public Complex(int r,int i){
    realpart=r;
    imaginPart=i;
  }

  public Complex complexADD( Complex a){
    Complex n = new Complex(this.realpart+a.realpart,this.imaginPart+a.imaginPart);
    return n;
  }
  public String toString(){
    return realpart+"+"+imaginPart+"i";
  }
}
