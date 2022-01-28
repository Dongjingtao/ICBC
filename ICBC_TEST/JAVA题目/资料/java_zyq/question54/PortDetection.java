package newemp.work.question54;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortDetection {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newCachedThreadPool();
    // 每100个端口开一个线程
    for (int i = 1; i <= 65535; i += 100) {
      pool.execute(new RunablePortDetection(i));
    }
    pool.shutdown();
  }
}