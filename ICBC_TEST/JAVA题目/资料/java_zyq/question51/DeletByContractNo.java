package newemp.work.question51;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeletByContractNo {
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
    String contract_no = s.nextLine();
    s.close();
    st.executeUpdate("DELETE FROM exam_contract WHERE contract_no = '"+contract_no+"'");
    con.close();
  }
}
