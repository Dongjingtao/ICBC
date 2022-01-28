package newemp.work.question39;
import java.util.Locale;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Wordcount {
  private BufferedReader br;
  private String s;
  private StringBuffer sb;
  private String[] article;


  public Wordcount(String path,String doc){
    sb=new StringBuffer();
    try {
      br=new BufferedReader(new FileReader(new File(path,doc)));
    }catch (IOException e) {
      e.getMessage();
    }
  }

  public String toLowerCase(String str) {
    StringBuilder sb=new StringBuilder();
    int temp=0;
    for(int i=0;i<str.length();i++) {
      if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
        temp=str.charAt(i)+('a'-'A');
        sb.append((char)temp);
        continue;
      }
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  public int getWordcount(String word)throws IOException{
    int count=0;
    String lowerword = toLowerCase(word);
    while ((s=br.readLine())!=null){
      sb.append(s);
    }
    s=sb.toString();
    article = s.split("[ ,\"\':.?!\n{}()]");
    for(int i=0;i<article.length;i++){
      if(toLowerCase(article[i]).equals(toLowerCase(word))){
        count= count+1;
      }
    }
    return count;
  }


  public static  void  main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    String testword = s.nextLine();
    String a = System.getProperty("user.dir");
    Wordcount ws=new Wordcount("D:/","t.txt");
    System.out.println(ws.getWordcount(testword));
  }
}
