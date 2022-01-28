package newemp.work.question38;

import java.io.*;

public class WordStntiatic {
  private BufferedReader br;
  private String s;
  private StringBuffer sb;
  private char[] c;

  WordStntiatic(String path, String doc) {
    sb = new StringBuffer();
    try {
      br = new BufferedReader(new FileReader(new File(path, doc)));
    } catch (IOException e) {
      e.getMessage();
    }
  }

  public void getWordStatistic() throws IOException {
    int n = 0;
    int m = 0;
    while ((s = br.readLine()) != null) {
      sb.append(s);
    }
    s = sb.toString();
    c = s.toCharArray();
    for (char i : c) {
      if (i >= 'a' && i <= 'z') {
        n = n + 1;
      } else if (i >= 'A' && i <= 'Z') {
        m = m + 1;
      }
    }
    System.out.println("a-z之间的字母是:" + n + "个");
    System.out.println("A-Z之间的字母是:" + m + "个");
  }

  public static void main(String[] args) throws IOException {
    String a = System.getProperty("user.dir");
    WordStntiatic ws = new WordStntiatic(a, "MyText.txt");
    ws.getWordStatistic();
  }
}
