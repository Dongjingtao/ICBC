package newemp.work.question55;

import java.util.ArrayList;

public class Person {
  int food;
  String name;
  ArrayList<Integer> eat = new ArrayList<Integer>();

  public Person(String name,int food){
    this.name=name;
    this.food=food;
  }

  public void beEaten(int num){
    eat.add(num);
    food--;
  }
  public String toString(){
    String result= name;
    for(int i=0;i<eat.size();i++){
      int num = eat.get(i);
      String p = String.valueOf(num);
      result+= " "+p;
    }
    return result;
  }

}
