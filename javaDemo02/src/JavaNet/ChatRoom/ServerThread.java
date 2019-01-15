package JavaNet.ChatRoom;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：聊天室服务器线程
 *
 * @Auther: 11432_000
 * @Date: 2019/1/15 16:16
 * @Description:
 */
public class ServerThread implements Runnable{
    public Socket accept;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ServerThread(Socket accept) {
        this.accept = accept;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(accept.getInputStream()));
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(accept.getOutputStream()));
        }catch (Exception e){}
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            close();
        }catch (Exception e){}
    }

    public void sendMsg(String string)throws IOException {
        dataOutputStream.writeUTF(string);
        dataOutputStream.flush();
    }

    public void sendMsg(Boolean string)throws IOException {
        dataOutputStream.writeBoolean(string);
        dataOutputStream.flush();
    }

    public void close()throws IOException{
        dataInputStream.close();
        dataOutputStream.close();
    }
}
