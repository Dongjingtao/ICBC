package newemp.work.question54;

public class RunablePortDetection implements Runnable {
  private int start_port;
  String ip = "192.168.159.128";

  public RunablePortDetection(int start_port) {
    this.start_port = start_port;
  }

  @Override
  public void run() {
    long start = System.currentTimeMillis();
    for (int i=start_port; i< start_port + 100; i++) {
      if (SocketUtils.telnetIpPort(ip, i)){
        System.out.println(i);
      }
    }
    long end = System.currentTimeMillis();
    System.out.println(start_port/100+"线程运行时间："+(end-start)+"ms");
  }
}
