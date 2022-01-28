package newemp.work.question46;

public class Student {
  int sno;
  String name;
  String sex;
  String major;
  public Student(int sno,String name,String sex,String major){
    this.sno=sno;
    this.name=name;
    this.sex=sex;
    this.major=major;
  }
  public String toString(){
    return "学号为："+sno+" 姓名为："+name+" 性别为："+sex+" 专业为："+major;
  }
}
