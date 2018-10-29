package TestIO;

import java.io.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/26 11:33
 * @Description:
 */
public class TestMain {

    public static void main(String[] arg)throws Exception{
//        TestFile.testFile();
//        TestRandomAccessFile.testRandomAccessFile();
//        TestIOStream.testFilePutStream();
//        TestIOStream.testBufferPutStream();
//        TestIOStream.testCharPutStream();
//        TestIOStream.testFileCharPutStream();
//        TestIOStream.testBufferReaderPutStream();
        test();
    }

    /* 测试读取宜立方.txt 时的乱码问题 结论：个别字符的字节被分为两半读取，故转换失败 */
    public static void test()throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\TestFileUpAndDownload\\宜立方.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\TestFileUpAndDownload\\宜立方-test.txt" ,true));
        int c;
        int i = in.available();
        byte[] bytes = new byte[1024*100];
        while((c = in.read(bytes)) != -1){
            String s = new String(bytes ,"GBK");
            System.out.println("--------------------------------" +  i);
            i++;
            out.write(bytes ,0 ,c);
            out.flush();
            System.out.println(s);
        }
        out.close();
        in.close();
    }

}
