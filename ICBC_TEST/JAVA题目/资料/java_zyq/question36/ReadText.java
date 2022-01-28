package newemp.work.question36;
import newemp.work.question38.WordStntiatic;

import java.io.*;

public class ReadText {
  private BufferedReader br;
  private String s;
  private StringBuffer sb;
  private char[] c;

  ReadText(String path,String doc ) {
    sb=new StringBuffer();
    try {
      br=new BufferedReader(new FileReader(new File(path,doc)));
    }catch (IOException e) {
      e.getMessage();
    }
  }
  public void getReadText()throws IOException{
    while ((s=br.readLine())!=null){
      sb.append(s+'\n');
    }
    System.out.println(sb.length());
    System.out.println(sb);
  }
  public static  void  main(String[] args) throws IOException {
    String a = System.getProperty("user.dir");
    ReadText rt=new ReadText(a,"status.csv");
    rt.getReadText();
  }
}
