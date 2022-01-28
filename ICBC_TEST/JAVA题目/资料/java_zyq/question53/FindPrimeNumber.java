package newemp.work.question53;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindPrimeNumber {
  public static void main(String[] args) throws Exception {
    ExecutorService pool = Executors.newCachedThreadPool();
    // 每10000000开一个线程
    for (long i = 1L; i <= 10000000000L; i += 10000000L) {
      pool.execute(new RunablePrimeFinder(i));
    }
    pool.shutdown();
  }
}
