import java.io.*;
import java.net.*;

class TCPClient {
     public static void main(String argv[]) throws Exception {
          String sentence;
          String modifiedSentence;
          BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
          Socket clientSocket = new Socket("localhost", 6789);

          DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
          BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

          boolean isRunning = true;
          while (isRunning) {
              System.out.print("send message (q to quit): ");
              sentence = inFromUser.readLine();

              if (sentence.equals("q") || sentence.equals("quit")) {
                  clientSocket.close();
                  isRunning = false;
              }

              outToServer.writeBytes(sentence + '\n');
              modifiedSentence = inFromServer.readLine();

              System.out.println("FROM SERVER: " + modifiedSentence);
          }
     }
}
