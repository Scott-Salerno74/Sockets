import java.net.*;
import java.io.*;

/**
 * Server side Socket program
 * 8/29/19
 * Author: Scott Salerno
 * Dr. Yarnall Kline
 */
public class Client {
    private Socket client;
    private PrintWriter output;
    private BufferedReader input;

    /*
     Start the Connection
     */
    public void startConnect(String ipNum, int portNum) throws IOException {
      client = new Socket(ipNum, portNum);
      output= new PrintWriter(client.getOutputStream(), true);
      input = new BufferedReader(new InputStreamReader(client.getInputStream()));

    }
    //Send a Message
    public String sendResponse(String message) throws IOException {
        output.println(message);
        String response = input.readLine();
        return response;


    }

    //End The connection
    public void stop() throws IOException {
        input.close();
        output.close();
        client.close();

    }
    public static void  main  (String[] args) throws IOException {
        Server server = new Server();
        server.start(8888);
    }
}
