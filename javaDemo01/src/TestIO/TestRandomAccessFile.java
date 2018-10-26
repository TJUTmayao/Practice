package TestIO;

import java.io.File;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 说明：RandomAccessFile可以访问文件（读写），可以随机访问文件（可以访问文件的任意位置）。
 *
 * @Auther: 11432_000
 * @Date: 2018/10/26 16:14
 * @Description:
 */
public class TestRandomAccessFile {

    public static void testRandomAccessFile() throws Exception{
        File file = new File("D:\\TestFileUpAndDownload\\456.txt");
        if (file.exists()){
            file.createNewFile();
        }
        /* 字节读写方式 "rw"为读写 ，"r"为只读 */
        RandomAccessFile raf = new RandomAccessFile(file ,"rw");
        /* 获取文件指针位置 */
        System.out.println(raf.getFilePointer());
        /* 所有基本数据类型写 注意字符串和字符的写入结果不同  */
        /* int，float，double，byte，char，long，short，String，boolean 以及char和byte的数组 */
        raf.writeBytes("mayao");
        raf.writeInt(15);
        raf.writeChars("nmd=f");
        raf.write("woc".getBytes());
        /* 一次性读入 */
        byte[] bytes = new byte[(int)raf.length()];
        /* 设置文件指针位置 */
        raf.seek(0);
        /* 将从当前文件指针位置到文件结束的内容读到byte数组中 (同样支持基本数据类型)*/
        raf.read(bytes);
        /* 读取一行 */
        raf.seek(0);
        String s = raf.readLine();
        System.out.println("一行:" + s + raf.read());

        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
    }
}
