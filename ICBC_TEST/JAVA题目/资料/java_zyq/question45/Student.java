package newemp.work.question45;

public class Student {
  int sno;
  String name;
  String sex;
  public Student(int sno,String name,String sex){
    this.sno=sno;
    this.name=name;
    this.sex=sex;
  }
  public String toString(){
    return "学号为："+sno+" 姓名为："+name+" 性别为："+sex;
  }
}
