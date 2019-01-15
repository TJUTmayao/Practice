package JavaNet.ChatRoom;

import java.io.*;
import java.net.Socket;

/**
 * 说明：聊天室客户端测试
 *
 * @Auther: 11432_000
 * @Date: 2019/1/15 16:36
 * @Description:
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        new Thread(new SayThread(socket)).start();
        new Thread(new LookThread(socket)).start();
    }
}
/** 输入线程 */
class SayThread implements Runnable{

    private DataOutputStream dataOutputStream;
    private Socket socket;
    private BufferedReader reader;
    public SayThread(Socket socket) {
        try {
            this.socket = socket;
            this.dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) { }
    }

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun){
            String msg = null;
            try {
                msg = reader.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                isRun = false;
            }
        }
    }
}
/** 输出线程 */
class LookThread implements Runnable{

    private DataInputStream dataInputStream;
    private Socket socket;
    public LookThread(Socket socket) {
        try {
            this.socket = socket;
            this.dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) { }
    }

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun){
            String msg = null;
            try {
                msg = dataInputStream.readUTF();
                System.out.println(msg);
            } catch (IOException e) {
                isRun = false;
            }
        }
    }
}
