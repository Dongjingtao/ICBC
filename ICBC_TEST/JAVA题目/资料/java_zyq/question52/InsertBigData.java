package newemp.work.question52;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertBigData {
  public static void main(String[] args) throws Exception{
    // 连接数据库
    Connection con;
    Statement st;
    ResultSet rs;

    String url = "jdbc:oracle:thin:@//192.168.159.128:1521/orcl";
    String user = "homework";
    String password = "homework";

    Class.forName("oracle.jdbc.OracleDriver");

    con = DriverManager.getConnection(url, user, password);
    st = con.createStatement();

    BufferedReader bf = new BufferedReader(new FileReader("status.csv"));

    //插入数据
    int count = 0;
    String sql = "insert into status (BATCHCODE,BATCHNAME,BATCHSTATUS,STARTDATE,STARTTIME,ENDDATE,ENDTIME,QUITMSG)"
        + "values(?,?,?,?,?,?,?,?)";
    con.setAutoCommit(false);
    PreparedStatement pstmt = con.prepareStatement(sql);
    bf.readLine();
    String temp1;
    while ((temp1=bf.readLine()) != null)
    {
      String[] temp = temp1.split(",");
      if (temp.length < 8)
        continue;

      if (temp.length == 8)
      {
        pstmt.setString(1, temp[0]);
        pstmt.setString(2, temp[1]);
        pstmt.setString(3, temp[2]);
        pstmt.setString(4, temp[3]);
        pstmt.setString(5, temp[4]);
        pstmt.setString(6, temp[5]);
        pstmt.setString(7, temp[6]);
        pstmt.setString(8, temp[7]);
      }

      pstmt.addBatch();
      count++;

      if (count == 20000)
      {
        pstmt.executeBatch();
        con.commit();
        count = 0;
      }
    }
    pstmt.executeBatch();
    con.commit();
    //结束
    bf.close();
    con.close();
  }
}
