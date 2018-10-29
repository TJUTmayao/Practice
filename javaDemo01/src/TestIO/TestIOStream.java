package TestIO;

import sun.rmi.runtime.NewThreadAction;

import java.io.*;

/**
 * 说明：InputStream / OutputStream， 序列化练习见TestSerializable
 *
 * @Auther: 11432_000
 * @Date: 2018/10/29 09:36
 * @Description:
 */
public class TestIOStream {

    private static final int SIZE = 1024;

    /* read方法只读取一个字节，返回值为读取的字符（int）编码，读取失败为-1  */
    public static void testFilePutStream()throws IOException{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方2.txt");
        /* 输入流 （读取）*/
        InputStream in = new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt");
        /* 输出流 （写）  true代表在文件末尾继续写 ，false代表覆盖文件 */
        OutputStream out = new FileOutputStream(file ,true);
        /* 输出读取内容 字节数组 */
        byte[] bytes = new byte[SIZE];
        int i = 0;
        /* 获取文件未读大小 */
        in.available();
        /* 将读到的字节放入字节数组中0-SIZE的位置，read返回读取的字节数，没有读到返回-1 */
        while ((i = in.read(bytes ,0 ,SIZE)) != -1){
            String string = new String(bytes ,"GBK");
            System.out.println(string);
            out.write(bytes ,0 ,SIZE);
            out.flush();
        }
        out.close();
        in.close();
    }

    public static void testBufferPutStream()throws IOException{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方Buffer.txt");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file,true));
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt"));
        byte[] bytes = new byte[SIZE];
        int size = 0;
        while ((size = in.read(bytes)) != -1){
            out.write(bytes);
            String s = new String(bytes ,"GBK");
            System.out.println(s);
            out.flush();
        }
        out.close();
        in.close();
    }

    /* DataIn/OutputStream 提供多种基础数据操作 */
    public static void testDataPutStream()throws IOException{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方data.txt");
        DataInputStream in = new DataInputStream(new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt"));
        /* 设置接着文件末尾写 */
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file ,true));
        in.readBoolean();
    }

    /* 字符流读写文件 */
    public static void testCharPutStream()throws IOException{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方char.txt");
        Reader reader = new InputStreamReader(new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt"),"GBK");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file,true),"GBK");
        char[]  bytes = new char[SIZE];
        int c ;
        while ((c = reader.read(bytes)) != -1){
            String s = new String(bytes);
            System.out.println(s);
            writer.write(s);
            writer.flush();
        }
    }

    /* 提供更方便的构造方法，但无法解决多种编码(只兼容项目的编码格式) */
    public static void testFileCharPutStream()throws IOException{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方char2.txt");
        FileReader reader = new FileReader("D:\\TestFileUpAndDownload\\宜立方.txt");
        FileWriter writer = new FileWriter(file);
        char[]  bytes = new char[SIZE];
        int c ;
        while ((c = reader.read(bytes)) != -1){
            String s = new String(bytes);
            System.out.println(s);
            writer.flush();
            writer.write(s);
        }
    }

    public static void testBufferReaderPutStream()throws IOException{
       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt") ,"GBK"));
       BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\TestFileUpAndDownload\\宜立方buffer_r.txt") ,"GBK"));

       String line;
       while((line = reader.readLine()) != null){
           System.out.println(line);
           writer.write(line);
           writer.newLine();
       }
       reader.close();
       writer.close();
    }
}
