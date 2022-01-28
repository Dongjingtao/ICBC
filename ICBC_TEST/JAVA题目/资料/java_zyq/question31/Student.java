package newemp.work.question31;
import java.util.Comparator;
import java.util.Random;

public class Student {
  int sno;
  String name;
  int score;
  String sex;

  public Student(int num) {
    sno = num;
    sex = randSex();
    name = randName();
    score = randScore();
  }

  //随机性别
  public String randSex() {
    int randNum = new Random().nextInt(2) + 1;
    return randNum == 1 ? "男" : "女";
  }
  //随机姓名
  String familyName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨";
  String lastName = "秀娟英华慧巧美娜伟刚勇毅俊峰强军";
  public String randName() {
    String str = "";
    int strLen;
    int index;
    strLen = familyName.length();
    index = new Random().nextInt(strLen);
    str = String.valueOf(familyName.charAt(index));
    strLen = lastName.length();
    index = new Random().nextInt(strLen);
    str= str + String.valueOf(lastName.charAt(index));
    return str;
  }
  public int randScore() {
    int score;
    score = new Random().nextInt(40)+60;
    return score;
  }
  public String toString(){
    return this.sno+" "+this.name+" "+this.score;
  }
}

