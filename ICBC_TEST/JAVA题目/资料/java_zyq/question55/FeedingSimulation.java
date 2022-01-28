package newemp.work.question55;

import java.util.ArrayList;

public class FeedingSimulation {
  public static void main(String[] args) {
    ArrayList<Fish> pool = new ArrayList<Fish>();
    ArrayList<Person> feedingPerson = new ArrayList<Person>();
    ArrayList<Person> finishPerson = new ArrayList<Person>();
    for (int i = 1; i <= 10; i++) {
      pool.add(new Fish(i));
    }
    feedingPerson.add( new Person("a",20));
    feedingPerson.add( new Person("b",40));
    feedingPerson.add( new Person("c",60));
    // 喂食过程
    while(true){
      System.out.println("第一层");
      if(pool.isEmpty() || feedingPerson.isEmpty()) break;
      //更新鱼的等待状态
      for(int i=0;i<pool.size();i++){
        Fish fish =pool.get(i);
        fish.addWaitTime();
      }

      //喂食过程

      if(feedingPerson.size()<= pool.size()){
        int[] totalfish = randomCommon(0,pool.size(),feedingPerson.size());
        for(int i=0;i<feedingPerson.size();i++){
          Fish fish = pool.get(totalfish[i]);
          Person person = feedingPerson.get(i);
          fish.eat();
          person.beEaten(fish.num);
        }
      }else {
        int[] totalperson = randomCommon(0, feedingPerson.size(), pool.size());
        for (int i = 0; i < pool.size(); i++) {
          Fish fish = pool.get(i);
          Person person = feedingPerson.get(totalperson[i]);
          fish.eat();
          person.beEaten(fish.num);
        }
      }

      System.out.println("第二层");
      //判断鱼是否跑路
      for(int i=0;i<pool.size(); ){
        System.out.println("pool:"+pool.size());
        Fish fish =pool.get(i);
        if(fish.waitingTime>=5) {
          pool.remove(fish);
        }else{
          i++;
        }
      }
      //判断人是否跑路
      for(int i=0;i<feedingPerson.size(); ){
        Person person=feedingPerson.get(i);
        if(person.eat.size()>=person.food){
          feedingPerson.remove(person);
          finishPerson.add(person);
        }else{
          i++;
        }
      }
    }



    //打印输出
    for(int i=0;i<feedingPerson.size();i++){
      Person person = feedingPerson.get(i);
      System.out.println(person);
    }
    for(int i=0;i<finishPerson.size();i++){
      Person person = finishPerson.get(i);
      System.out.println(person);
    }

  }


  //随机返回n个不重复的int
  public static int[] randomCommon(int min, int max, int n){
    if (n > (max - min + 1) || max < min) {
      return null;
    }
    int[] result = new int[n];
    int count = 0;
    while(count < n) {
      int num = (int) (Math.random() * (max - min)) + min;
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if(num == result[j]){
          flag = false;
          break;
        }
      }
      if(flag){
        result[count] = num;
        count++;
      }
    }
    return result;
  }

}
