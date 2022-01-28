package newemp.work.question45;

import java.util.Scanner;
import java.util.Vector;

public class StudentInfoManager {
  Vector<Student> v=new Vector<Student>();

  public void addStudent(Student a){
    v.add(a);
  }

  public void delStudent(int studentNo){
    for(int i=0;i<v.size();i++){
      Student st = v.get(i);
      if(st.sno==studentNo){
        v.remove(i);
        break;
      }
    }
  }

  public void show(){
    for(int i=0;i<v.size();i++){
      System.out.println(v.get(i));
    }
  }

  public static void main(String[] args) {
    StudentInfoManager test = new StudentInfoManager();
    while (true) {
      System.out.println("请输入您需要的操作：1.增加 2.删除 3.显示 4.退出");
      Scanner s = new Scanner(System.in);
      int func = Integer.parseInt(s.nextLine());

      if(func==1){
        System.out.println("请输入添加学生的学号，姓名，性别：");
        String[] str = s.nextLine().split(" ");
        int snum = Integer.parseInt(String.valueOf(str[0]));
        String name = str[1];
        String sex = str[2];
        test.addStudent(new Student(snum,name,sex));
      }else if(func==2){
        System.out.println("请输入删除学生的学号：");
        int snum=s.nextInt();
        test.delStudent(snum);
      }else if(func==3){
        test.show();
      }else if(func==4){
        s.close();
        System.exit(0);
      }
    }
  }
}
