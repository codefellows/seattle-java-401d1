import java.io.*;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private User user;

    public ConnectionHandler(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            handleMessage();
        } catch (IOException e) {

        }
    }

    public void handleMessage() throws IOException {
        InputStream inputStream = this.user.socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(reader);

        OutputStream outputStream = this.user.socket.getOutputStream();
        DataOutputStream backToClient = new DataOutputStream(outputStream);

        boolean isRunning = true;
        while (isRunning) {
            String line = buffer.readLine();
            String response = line.toUpperCase() + "\n";

            if (line.startsWith("@quit")) {
                isRunning = false;
                this.user.socket.close();
            }

            TCPServer.broadcast(this.user.toString() + ": " + response);
        }
    }
}
