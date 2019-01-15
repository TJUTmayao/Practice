package JavaNet.ChatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 说明：聊天服务器
 *
 * @Auther: 11432_000
 * @Date: 2019/1/15 16:19
 * @Description:
 */
public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("-------启动服务器-------");
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("收到一个请求" + accept.getInetAddress().getHostAddress());
        }
    }
}
