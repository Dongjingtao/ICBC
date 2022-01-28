package newemp.work.question46;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class StudentMIS {
  ArrayList<Student> studentArrayList = new ArrayList<Student>();

  public void readStudent()throws Exception {
    FileInputStream inputStream = new FileInputStream("student.dat");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String str = null;
    while ((str = bufferedReader.readLine()) != null) {
      String[] arr = str.split(" ");
      int snum = Integer.parseInt(String.valueOf(arr[0]));
      String name = arr[1];
      String sex = arr[2];
      String major = arr[3];
      addStudent(new Student(snum, name, sex, major));
    }
  }

  public void addStudent(Student a){
    studentArrayList.add(a);
  }

//  public void changeStudent(int studentNo){
//    for (int)
//
//  }

  public void delStudent(int studentNo){
    for(int i=0;i<studentArrayList.size();i++){
      Student st = studentArrayList.get(i);
      if(st.sno==studentNo){
        studentArrayList.remove(i);
        break;
      }
    }
  }

  public void show(){
    for(int i=0;i<studentArrayList.size();i++){
      System.out.println(studentArrayList.get(i));
    }
  }

  public void save() throws Exception{
    FileOutputStream fos = new FileOutputStream("student.dat");
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos));
    for (int i = 0;i<studentArrayList.size();i++){
      Student st = studentArrayList.get(i);
      writer.write(st.sno+" "+st.name+" "+st.sex+" "+st.major+"\r\n");
    }
    writer.close();
  }



  public static void main(String[] args) throws Exception{
    StudentMIS test = new StudentMIS();
    test.readStudent();
    while (true) {
      System.out.println("请输入您需要的操作：1.增加 2.修改 3.删除 4.显示 5.保存 6.退出");
      Scanner s = new Scanner(System.in);
      int func = Integer.parseInt(s.nextLine());

      if (func == 1) {
        System.out.println("请依次输入添加学生的学号，姓名，性别，专业：");
        String[] str = s.nextLine().split(" ");
        int snum = Integer.parseInt(String.valueOf(str[0]));
        String name = str[1];
        String sex = str[2];
        String major = str[3];
        test.addStudent(new Student(snum, name, sex, major));
      }else if(func==2){
        System.out.println("请输入要修改的学生的学号：");
        int snum = s.nextInt();
        System.out.println("请输入修改后的学生姓名，性别，专业：");
        String[] str = s.nextLine().split(" ");
        String name = str[0];
        String sex = str[1];
        String major = str[2];
        for(int i=0;i<test.studentArrayList.size();i++){
          Student st = test.studentArrayList.get(i);
          if(st.sno==snum){
            st.name = name;
            st.sex=sex;
            st.major=major;
            break;
          }
        }
      }else if(func==3){
        System.out.println("请输入要删除的学生的学号：");
        int snum=s.nextInt();
        test.delStudent(snum);
      }else if(func==4){
        test.show();
      }else if(func==5){
        test.save();
      }else if(func==6){
        s.close();
        System.exit(0);
      }
    }
  }
}
