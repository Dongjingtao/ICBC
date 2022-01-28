package newemp.work.question48;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.sql.*;


public class SelectExamContract {
  public static void main(String[] args) throws Exception {
    // write your code here
    Connection con;
    Statement st;
    ResultSet rs;

    String url = "jdbc:oracle:thin:@//192.168.159.128:1521/orcl";
    String user = "homework";
    String password = "homework";

    Class.forName("oracle.jdbc.OracleDriver");

    con = DriverManager.getConnection(url, user, password);
    st = con.createStatement();

    String columnName = "";
    String columnValue = "";
    JSONArray array = new JSONArray();

    ResultSet resultSet = st.executeQuery("select * from exam_contract");
    ResultSetMetaData metaData = resultSet.getMetaData();

    int columnCount = metaData.getColumnCount();//获取列数

    while (resultSet.next()) {
      JSONObject jsonObject = new JSONObject();
      for (int i = 1; i < columnCount; i++) {
        columnName = metaData.getColumnLabel(i);
        columnValue = resultSet.getString(columnName);
        jsonObject.put(columnName, columnValue);
      }
      array.add(jsonObject);
    }
    con.close();
  }
}
