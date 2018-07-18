// This is a manual program that connects to the server,
// reads input from System.in and sends that text from the
// client to the server.
// You do not need to use this file if you're connecting to
// the server via telnet with this command
// telnet localhost 6789

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

              outToServer.writeBytes(sentence + '\n');
              modifiedSentence = inFromServer.readLine();

              if (sentence.equals("q") || sentence.equals("quit")) {
                  clientSocket.close();
                  isRunning = false;
              } else {
                  System.out.println("FROM SERVER: " + modifiedSentence);
              }
          }
     }
}
