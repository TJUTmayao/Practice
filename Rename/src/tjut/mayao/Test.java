package tjut.mayao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/12/12 16:34
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception{

//        File file = new File("D:\bika\Nox_share\OtherShare\files\5c11c09c85c2447895459f1a);
//        boolean b = false;
//        b = file.renameTo(new File(file.getParentFile().getPath() + "/0.jpg"));
//        System.out.println(b);

        File file = new File("C:\\Users\\11432_000.000.000\\Desktop\\yy1");
        File[] files = file.listFiles();
        Rename rename = new Rename();
        files = rename.sortFilesByInsert(files ,2);
        show(files);
        System.out.println("--------------------------------------------------------");
        files = rename.sortFilesByBubbling(files ,1);
        show(files);
//        S tringBuilder stringBuilder = new StringBuilder();
//        Log4j log4j = new Log4j();

//        test();
    }



    public static void test(){
        int[] ints = {1,4,5,2,7,3,1,3,4,78,6,4};
        int file;
        int orderIndex;
        for (int disOrderIndex = 1; disOrderIndex < ints.length; disOrderIndex++) {
            file = ints[disOrderIndex];
            for (orderIndex = disOrderIndex - 1; orderIndex >= 0; orderIndex--) {
                ints[orderIndex + 1] = ints[orderIndex];
                if (file >= ints[orderIndex]){
                    break;
                }
            }
            ints[orderIndex + 1] = file;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

    public static void show(File[] files)throws IOException {
        BasicFileAttributes basicFileAttributes = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        for (int i = 0; i < files.length; i++) {
            basicFileAttributes = Files.readAttributes(files[i].toPath(),BasicFileAttributes.class);
            Date date = new Date(basicFileAttributes.creationTime().toMillis());
            String format = simpleDateFormat.format(date);
            System.out.println(files[i].getName() +"  " + files[i].lastModified() + " ");
        }
    }
}
