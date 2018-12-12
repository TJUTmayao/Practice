package TestIO;

import java.io.File;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/26 14:24
 * @Description:
 */
public class TestFile {

    public static void testFile() throws Exception{
        File file = new File("D:\\TestFileUpAndDownload\\宜立方.txt");
        File file2 = new File("D:\\TestFileUpAndDownload\\123456");
        File file3 = new File("D:\\TestFileUpAndDownload\\123456\\654321\\54188");
        File file34 = new File("D:\\TestFileUpAndDownload");

        /* File 常用方法 */
        /* 检查文件是否存在 存在返回true 不存在返回false */
        System.out.println("1." + file.exists());
        /* 创建一层目录 创建成功返回true 已存在或失败返回false */
        System.out.println("2." + file2.mkdir());
        /* 创建多层目录 创建成功返回true 已存在或失败返回false*/
        System.out.println("3." + file3.mkdirs());
        /* 获取文件或目录名 */
        System.out.println("4." + file2.getName());
        /* 获取的规范化路径 */
        System.out.println("5." + file.getCanonicalPath());
        /* 获取绝对路径 */
        System.out.println("6." + file2.getAbsolutePath());
        /* 判断是否为文件 */
        System.out.println("7." + file2.isFile());
        /* 判断是否为目录 */
        System.out.println("8." + file.isDirectory());
        /* 判断文件或目录是否是隐藏的 */
        System.out.println("9." + file.isHidden());
        /* 检查路径是否为局对路径 */
        System.out.println("10." + file.isAbsolute());
        /* 返回一个局对路径的文件/目录 */
        System.out.println("11." + file2.getAbsoluteFile());
        /* 比较两个路径的字典顺序 相同为0 */
        System.out.println("12." + file.compareTo(file));
        /* 获取文件的url （可在浏览器访问）*/
        System.out.println("13." + file.toURI());
        /* 重命名或移动文件 （注意路径）*/
        System.out.println("14." + file.renameTo(new File("D:\\TestFileUpAndDownload\\宜立方.txt")));
        /* 获取目录下的所有文件的对象 */
        File[] files = file2.listFiles();
        for (File f : files){
            System.out.println(f);
        }
        /* 返回目录下所有文件名 */
        String[] list = file2.list();
        /* 设置可执行/可读/可写 ，设置只读 */
        System.out.println("15." + file.setExecutable(false) + file.setReadable(false) + file.setWritable(false));
        file.setReadOnly();
        /* 创建新文件 */
        file.createNewFile();
        /* 判断文件是否可执行/读/写 */
        System.out.println("16.可执行？" + file.canExecute() + "可读？" + file.canRead() + "可写？" + file.canWrite());
        /* 在虚拟机运行结束时 删除文件 */
        System.out.println("17.");file.deleteOnExit();
        /* 删除文件 */
        System.out.println("18." + file.delete());
        /* 获取最后更改时间(可以设置) */
        System.out.println("19." + file.lastModified());
    }
}
