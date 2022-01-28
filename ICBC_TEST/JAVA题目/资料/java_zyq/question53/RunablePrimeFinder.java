package newemp.work.question53;

public class RunablePrimeFinder implements Runnable {
  private long start_num;
  public RunablePrimeFinder(long start_num){
    this.start_num=start_num;
  }
  public void run() {
    for (long i=start_num; i< start_num + 10000000L; i++){
      if(IsPrimeUtils.isPrime(i)){
       System.out.println(i);
      }
    }
  }
}
