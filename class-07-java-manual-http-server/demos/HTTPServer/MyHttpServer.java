import java.io.*;
import java.net.*;

class MyHttpServer {
  public static final boolean IS_SLOW_SERVER = false;
  public static final int PORT = 6789;
  
  public static void main(String argv[]) throws Exception {
    ServerSocket welcomeSocket = new ServerSocket(PORT);
    System.out.println("Listening on http://localhost:" + PORT);

    while (true) {
      System.out.println("waiting for request...");
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
   
      // peel off the first GET/POST PATH line
      String requestLine = inFromClient.readLine();
      System.out.println("REQUEST: " + requestLine);
      
      // get the next line to collect all the headers
      String header = inFromClient.readLine();
      // read lines and assume they're headers until reaching an empty line.
      while (!header.equals("")) {
        System.out.println("HEADER: " + header);
        header = inFromClient.readLine();
      }
      
      if (IS_SLOW_SERVER) {
        // adding 5-second delay to make single-threaded server obvious
        Thread.sleep(5000);
      }

      String message = "<h1>neato</h1>";
      outToClient.write("HTTP/1.1 200 OK\n");
      outToClient.write("Content-Length: " + message.length() + "\n");
      outToClient.write("\n");
      outToClient.write(message + "\n");
      outToClient.flush();
      outToClient.close();
      
      System.out.println("closed request.");
    }
  }
}
