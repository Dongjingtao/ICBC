package newemp.work.question41;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListWords {
  private BufferedReader br;
  private String s;
  private StringBuffer sb;
  private String[] article;
  private Map<String,Integer> maps = new HashMap<String,Integer>();
  private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";


  public ListWords(String path,String doc){
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

  public void getWordcount()throws IOException{
    while ((s=br.readLine())!=null){
      sb.append(s+"\n");
    }
    s=sb.toString();
    s=s.replaceAll(REGEX_CHINESE, " ");
    article = s.split("[ ,\"\':.?!{}();\n]+");
    for(int i=0;i<article.length;i++){
      if (article[i]!="") maps.merge(article[i], 1, Integer::sum);
    }
  }

  public static void sort(Map<String,Integer> map) {
    List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
    Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return (o2.getValue() - o1.getValue());
      }
    });
    for (int i = 0,flag=0; i < 5;  ) {   //输出
      Map.Entry<String, Integer> id = infoIds.get(i+flag);
      if(id.getKey()=="") {flag++; continue;}
      System.out.println(id.getKey() + ":" + id.getValue());
      i++;
    }
  }



  public static  void  main(String[] args) throws IOException {
    String a = System.getProperty("user.dir");
    ListWords ws=new ListWords(a,"testc.txt");
    ws.getWordcount();
    ListWords.sort(ws.maps);
  }
}