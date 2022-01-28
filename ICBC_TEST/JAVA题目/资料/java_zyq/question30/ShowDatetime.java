package newemp.work.question30;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ShowDatetime {
  public static void main(String arg[]) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    SimpleDateFormat df1 = new SimpleDateFormat("E");
    System.out.println(df.format(new Date())+" 星期"+df1.format(new Date()).substring(1,2));
  }
}
