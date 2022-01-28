package newemp.work.question54;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketUtils {
  public static boolean telnetIpPort(String ip, int port) {
    Socket socket = new Socket();
    try {
      socket.connect(new InetSocketAddress(ip, port),1000);
      return true;
    } catch (Exception e) {
      return false;
    } finally {
      try {
        socket.close();
      } catch (IOException ignored) {
      }
    }
  }
}
