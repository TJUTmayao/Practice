package tjut.mayao;

import java.io.File;
import java.io.IOException;

/**
 * 说明：执行函数。
 *
 * @Auther: 11432_000
 * @Date: 2018/12/17 11:23
 * @Description:
 */
public class ExecutRename {

    private static final Log4j LOG = new Log4j();

    public static void main(String[] args) {
        try {
            execut("C:\\Users\\11432_000.000.000\\Desktop\\001" ,"yy");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void execut(String directory ,String fileNamePrefix)throws IOException {
        Rename rename = new Rename();
        long beginTime = System.currentTimeMillis();
        File file = new File(directory);
        rename.rename(file ,fileNamePrefix ,Rename.USE_INSERT_ALGORITHM ,Rename.BY_LAST_MODIFIED);
        long endTime = System.currentTimeMillis();
        String executTimeMsg = "执行成功。耗时：" + (endTime - beginTime) + "ms";
        String renameFilesMsg = "更新文件数：" + rename.getRenameFilesNumber();
        String renameDirectoryMsg = "更新目录数：" + rename.getRenameDirectoryNumber();
        String filePathMsg = "更新文件目录" + rename.getRenameFileName();
        System.out.println(executTimeMsg);
        System.out.println(renameFilesMsg);
        System.out.println(renameDirectoryMsg);
        LOG.info(filePathMsg ,executTimeMsg ,renameFilesMsg ,renameDirectoryMsg);
    }
}
