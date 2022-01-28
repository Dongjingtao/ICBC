package newemp.work.question6.account;

public class AccountUtil {
  public static String toSeparateNumber(String a){
    String i="";
    String j="";
    if (a.contains(".")){
      i=a.substring(0,a.indexOf("."));
      j=a.substring(a.indexOf("."),a.length());
    }else{
      i=a;
    }
    String ri= new StringBuffer(i).reverse().toString();
    String pi="";
    for (int ii = 0; ii < ri.length(); ii++) {
      if (ii * 3 + 3 > ri.length()) {
        pi += ri.substring(ii * 3, ri.length());
        break;
      }
      pi += ri.substring(ii * 3, ii * 3 + 3) + ",";
    }
    if (pi.endsWith(",")) {
      pi = pi.substring(0, pi.length() - 1);
    }
    String b = new StringBuffer(pi).reverse().toString()+j;
    return b;
  }
}
