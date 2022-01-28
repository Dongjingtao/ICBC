package newemp.work.question29;


public class Translate {
  String x[] = {"zero","one","two","three","four","five","six", "seven","eight","nine"};
  String y[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen", "seventeen","eighteen","nineteen"};
  String z[] = {"twenty","thirty","fourty","fifty","sixty","seventy","eighty" ,"ninety"};

  public String numToEnglish(int a){
    if(a>=0 && a<10){
      return x[a];
    }else if(a>=10 && a<20){
      return y[a-10];
      }else{
      if(a/10 ==0){return z[a/10-2];}else{
        return z[a/10-2]+" "+x[a%10];}
    }
  }

  public int englishToNum(String a){
    for (int i=0;i<100;i++){
      if(numToEnglish(i).equals(a)){
        return i;
      }
    }
    return -1;
  }
  public static void main(String arg[]) {
    Translate test = new Translate();
    System.out.println(test.numToEnglish(32));
    System.out.println(test.numToEnglish(8));
    System.out.println(test.englishToNum("ninety three"));
  }
}
