package newemp.work.question44;
import newemp.work.exp.EmptyStackException;

import java.io.*;

public class FileOperate {

  //创建指定的目录makeDirectory
  public static  void makeDirectory(String path){
    File file = new File(path);
    //如果这个目录不存在，就创建一个
    if(!file.exists()){
      file.mkdirs();
    }
  }
  //清空指定目录中的所有文件emptyDirectory方法
  public static  boolean emptyDirectory(String path){
    boolean flag = true;
    File file = new File(path);
    //如果文件不存在
    if(!file.exists())
      flag = true;
    if(file.isFile()){
      if(file.delete()==false){
        flag = false;
      }
    }
    else{
      File[] dir = file.listFiles();
      for(int i=0;i<dir.length;i++){
        emptyDirectory(dir[i].getAbsolutePath());
      }
    }
    return flag;
  }


  //listAll方法：列出目录中的所有内容，包括其子目录中的内容。
  public static void listAll(String path){
    File file = new File(path);
    //如果文件不存在
    if(!file.exists())
      return ;
    if(file.isFile()){
      System.out.println(file.getAbsolutePath());
    }
    else{
      System.out.println(file.getAbsolutePath());
      File[] dir = file.listFiles();
      for(int i=0;i<dir.length;i++){
        System.out.println(dir[i].getAbsolutePath());
      }
    }
  }

  //getTypePart方法：得到指定目录下所有以某后缀命名的所有文件名。
  //我使用了类中套类的方法,讲一个继承FilenameFilter接口的ListFilter写到了类里面
  class ListFilter1 implements FilenameFilter{
    private String type ="";
    public ListFilter1(String _type){
      type = _type;
    }
    public boolean accept(File dir, String name) {
      boolean y = true;
      try{
        name = name.toLowerCase();
        y = name.endsWith(type);
      }catch(NullPointerException e){}
      return y;
    }
  }

  public void getTypePart(String path,String type){
    File f = new File(path);
    ListFilter1 lf = new ListFilter1(type);
    String[] files = f.list(lf);
    for(int i=0;i<files.length;i++){
      System.out.println(files[i]);
    }
  }


  //搜索文件SearchFile方法:搜索给定目录下的指定文件，支持模糊查询和深度搜索。
  //如:test.*，则返回所有以test.开头的文件名。
  //也是采用类中套类的方法
  class ListFilter2 implements FilenameFilter{
    String name = "",type = "";
    public ListFilter2(String allname){
      int i,j;
      i = allname.indexOf('*');
      j = allname.indexOf('.');
      //不存在模糊查找
      if(i<0){
        name = allname.substring(0,j-1);
        type = allname.substring(j+1);
      }
      //模糊查找出现在文件名当中
      else if(i<j){
        name = allname.substring(0,i-1);
        type = allname.substring(j+1);
      }
      //模糊查找出现在文件类型中
      else{
        name = allname.substring(0,j-1);
      }
    }
    public boolean accept(File dir, String allname) {
      boolean y = true;
      try{
        allname = allname.toLowerCase();
        y = allname.startsWith(name)&allname.endsWith(type);
      }catch(NullPointerException e){}
      return y;
    }
  }

  public void searchFile(String path,String allname){
    File f = new File(path);
    ListFilter2 lf = new ListFilter2(allname);
    String[] files = f.list(lf);
    try{
      for(int i=0;i<files.length;i++){
        System.out.println(files[i]);
      }
    }catch(NullPointerException e){}
    File[] newFile = f.listFiles();
    try{
      for(int j=0;j<newFile.length;j++){
        searchFile(newFile[j].getAbsolutePath(),allname);//在这里我使用了递归的方法
      }
    }catch(NullPointerException e){}
  }

  public static void main(String []arg){
    FileOperate f = new FileOperate();
    listAll("D:/abcf");
  }
}
