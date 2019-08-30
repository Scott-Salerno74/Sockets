import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class clientMessage_ServerRunning {
 @Test
    public void messageWhileLive () throws IOException {
     Client client = new Client();
     client.startConnect("127.0.0.1",8888);
     String response = client.sendResponse("hello server");
     assertEquals("Hello Client", response);
 }
}