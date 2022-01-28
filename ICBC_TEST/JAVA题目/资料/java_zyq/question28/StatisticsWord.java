package newemp.work.question28;

public class StatisticsWord {

  public int statisticsStart(String a[],String b){
    int num = 0;
    for (int i=0; i<a.length; i++ ){
      if(a[i].startsWith(b)){
        num+=1;
      }
    }
    return num;
  }

  public int statisticsContains(String a[],String b){
    int num = 0;
    for (int i=0; i<a.length; i++ ){
      if(a[i].contains(b)){
        num+=1;
      }
    }
    return num;
  }

  public int statisticsLength(String a[],int b){
    int num = 0;
    for (int i=0; i<a.length; i++ ){
      if(a[i].length()==b){
        num+=1;
      }
    }
    return num;
  }
}
