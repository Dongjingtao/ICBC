package newemp.work.question47;

import java.io.*;
import java.net.*;

public class Client {

  public static void main(String[] args) throws Exception {

    String readline = null;
    String inTemp = null;
    //String outTemp = null;
    String turnLine = "\n";
    final String client = "Client:";
    final String server = "Server:";

    int port = 8888;
    byte ipAddressTemp[] = {127, 0, 0, 1};
    InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

    Socket socket = new Socket(ipAddress, port);

    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

    while(true){

      System.out.println(client);
      readline = systemIn.readLine();
      if(readline.equals("bye")) break;
      //System.out.println(readline);

      socketOut.println(readline);
      socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

      //outTemp = readline;
      inTemp = socketIn.readLine();

      //System.out.println(client + outTemp);
      System.out.println(server + turnLine + inTemp);

    }

    systemIn.close();
    socketIn.close();
    socketOut.close();
    socket.close();

  }

}