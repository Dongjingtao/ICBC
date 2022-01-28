package newemp.work.question37;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteLog {
  public static void main(String[] args){
    File file=new File("log");
    if(!file.exists()){
      try {
        file.createNewFile();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    FileWriter fw = null;
    try {
      fw = new FileWriter(file,true);
      BufferedWriter bw = new BufferedWriter(fw);
      System.out.println("Input your Infomation:");
      InputStreamReader isr = new InputStreamReader(System.in);

      BufferedReader br = new BufferedReader(isr);
      String str = br.readLine();
      while (!str.equals("quit#")) {
        bw.write(str);
        bw.newLine();
        bw.flush();
        str = br.readLine();
      }
      br.close();
      isr.close();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}