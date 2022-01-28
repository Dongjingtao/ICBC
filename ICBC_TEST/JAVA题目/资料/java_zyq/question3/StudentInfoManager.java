package newemp.work.question3;

public class StudentInfoManager {
  private String name;
  private int age;

  public StudentInfoManager(){
    name = "无名氏";
    age = 20;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }
  public boolean isSameAge(int s){
    return s==age;
  }
}
