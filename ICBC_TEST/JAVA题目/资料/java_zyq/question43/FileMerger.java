package newemp.work.question43;


import java.io.*;
import java.util.Scanner;

public class FileMerger {
  private File dir;
  private File dest;
  public FileMerger(File dir, File dest) {
    this.dir = dir;
    this.dest = dest;
  }
  /**
   * 遍历文件夹下文件，如果是txt文件，则追加
   *
   * @throws //IOException
   */
  public void merge() throws IOException {
    File[] files = dir.listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.getName().toLowerCase().endsWith(".txt")) {
          append(f, dest);
          System.out.println("append " + f);
        }
      }
    }
  }
  /**
   * 将文件f的内容按行追加到文件d中
   *
   * @param f
   * @param d
   * @throws IOException
   */
  private void append(File f, File d) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(f));
    BufferedWriter bw = new BufferedWriter(new FileWriter(d, true));
    String line = null;
    while ((line = br.readLine()) != null) {
      bw.write(line);
      bw.newLine();
    }
    br.close();
    bw.close();
  }
  public static void main(String[] args) {
// 不做判断
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入源文件夹路径：");
    String srcPath = sc.nextLine();
    System.out.println("请输入目标文件路径：");
    String destPath = sc.nextLine();
    FileMerger merger = new FileMerger(new File(srcPath),
        new File(destPath));
    try {
      merger.merge();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
