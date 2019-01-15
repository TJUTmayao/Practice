package JavaNet.ChatRoom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 说明：聊天室服务端测试
 *
 * @Auther: 11432_000
 * @Date: 2019/1/15 16:47
 * @Description:
 */
public class ServerTest {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            new Thread(new ServerTest02(accept)).start();
            System.out.println(accept.getInetAddress().getHostAddress() + "连接了服务器");
        }
    }
}
/** 一对一 */
class ServerTest02 implements Runnable{

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ServerTest02(Socket socket) {
        this.socket = socket;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) { }
    }

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun){
            String newMsg = null;
            try {
                newMsg = dataInputStream.readUTF();
                sendMsg(newMsg);
            } catch (IOException e) {
                isRun = false;
            }
        }
    }

    private void sendMsg(String msg)throws IOException{
        dataOutputStream.writeUTF(msg);
        dataOutputStream.flush();
    }
}

class ServerTest03 implements Runnable{

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ServerTest03(Socket socket) {
        this.socket = socket;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) { }
    }

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun){
            String newMsg = null;
            try {
                newMsg = dataInputStream.readUTF();
            } catch (IOException e) {
                isRun = false;
            }
        }
    }

    private void sendMsg(String msg)throws IOException{
        dataOutputStream.writeUTF(msg);
        dataOutputStream.flush();
    }
}

