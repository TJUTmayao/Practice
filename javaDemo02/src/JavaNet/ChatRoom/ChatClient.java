package JavaNet.ChatRoom;

import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.net.Socket;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/15 16:22
 * @Description:
 */
public class ChatClient {

    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("localhost" ,8888);
    }
}
