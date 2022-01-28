package newemp.work.question49;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertExamContract {
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
    String[]addData = s.nextLine().split(" ");
    s.close();
    String company=addData[0];
    String contract_no=addData[1];
    String valid_date=addData[2];
    String customer=addData[3];
    String start_date=addData[4];
    String end_date=addData[5];
    st.executeUpdate("insert into exam_contract values ('"+company+"', '"+contract_no+"', '"+valid_date+"', '"+customer+"', '"+start_date+"', '"+end_date+"')");
    con.close();
  }
}
