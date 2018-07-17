import java.io.*;
import java.net.*;

class TCPServer {
  public static void main(String argv[]) throws Exception {
      String clientSentence;
      String capitalizedSentence;
      ServerSocket welcomeSocket = new ServerSocket(6789);

      System.out.println("Waiting for connection...");
      Socket connectionSocket = welcomeSocket.accept();

      boolean isRunning = true;
      while (isRunning) {
          System.out.println("Waiting for message...");

          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
          DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

          clientSentence = inFromClient.readLine();
          System.out.println("Received: " + clientSentence);

          capitalizedSentence = clientSentence.toUpperCase() + '\n';
          outToClient.writeBytes(capitalizedSentence);
      }
  }
}
