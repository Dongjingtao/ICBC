package newemp.work.question50;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChangeEndDate {
  public static void main(String[] args) throws Exception {
    Connection con;
    Statement st;
    ResultSet rs;

    String url = "jdbc:oracle:thin:@//192.168.159.128:1521/orcl";
    String user = "homework";
    String password = "homework";

    Class.forName("oracle.jdbc.OracleDriver");

    con = DriverManager.getConnection(url, user, password);
    st = con.createStatement();
    Scanner s=new Scanner(System.in);
    String customer = s.nextLine();
    s.close();

    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    String end_date = df.format((new Date()));
    st.executeUpdate("UPDATE exam_contract SET end_date ='"+end_date+"'  WHERE customer='"+customer+"'");
    con.close();
  }
}
