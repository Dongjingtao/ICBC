package newemp.work.question55;

public class Fish {
  int num;
  int waitingTime;
  public Fish(int number){
    num=number;
  }
  public int eat(){
    waitingTime = 0;
    return num;
  }
  public void addWaitTime(){
    waitingTime+=1;
  }
}
