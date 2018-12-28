package tjut.mayao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 说明：批量重命名(优化后+ 新增插入排序算法)
 *
 * @Auther: 11432_000
 * @Date: 2018/12/12 16:04
 * @Description:
 */
public class Rename {

    public static final int BY_LAST_MODIFIED = 0;
    public static final int BY_CREATE_TIME = 1;
    public static final int USE_BUBBLING_ALGORITHM = 101;
    public static final int USE_INSERT_ALGORITHM = 102;

    private int renameFilesNumber = 0;
    private int renameDirectoryNumber = 0;
    private String renameFileName = null;

    public  void rename(File file ,String fileNamePrefix ,String fileSuffix ,int algorithm ,int choiceMode)throws IOException{
        /**
         *
         * 功能描述: 将目录下指定格式的文件指定规则重命名（从早到晚），
         *           若想要将目录下的全部格式的文件重命名，请传入""
         *
         * @param: [file, fileNamePrefix, fileSuffix]
         * @return: void
         * @auther: 11432_000
         * @date: 2018/12/12 23:20
         */
        int fileNumber = 0;
        int directoryNumber = 0;
        if (this.renameFileName == null){this.renameFileName = file.getPath();}
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files == null || files.length <= 0){
                return;
            }
            files = selectionAlgorithm(files ,algorithm ,choiceMode);
            for(File one : files){
                if (one.isDirectory()){
                    //该递归必须为第一句
                    rename(one ,fileNamePrefix ,fileSuffix ,algorithm ,choiceMode);
                    boolean isSuccess = renameDirectory(one, fileNamePrefix, directoryNumber);
                    if (isSuccess){ directoryNumber ++; }
                }else if(one.isFile() && isThisFileSuffix(one ,fileSuffix)){
                    boolean isSuccess = renameFile(one, fileNamePrefix, fileSuffix, fileNumber);
                    if (isSuccess){ fileNumber ++; }
                }
            }
        }
        return;
    }

    public  File[] sortFilesByBubbling(File[] files ,int choiceMode)throws IOException{
        /**
         *
         * 功能描述: 将这些文件排序(冒泡排序)。
         *
         * @param: [files]
         * @return: java.io.File[]
         * @auther: 11432_000
         * @date: 2018/12/12 23:00
         */
        if (files.length == 0){
            return null;
        }
        File max;
        boolean isExchange;
        for (int i = 0; i < files.length; i++) {
            isExchange = false;
            for (int j = 0; j < files.length - i - 1; j++) {
                if (compareTo(files[j] ,files[j + 1] ,choiceMode) == 1){
                    max = files[j];
                    files[j] = files[j + 1];
                    files[j + 1] = max;
                    isExchange = true;
                }
            }
            if (!isExchange){ break; }
        }
        return files;
    }

    public  File[] sortFilesByInsert(File[] files ,int choiceMode)throws IOException{
        /**
         *
         * 功能描述: 将这些文件排序(插入排序)。
         *
         * @param: [files]
         * @return: java.io.File[]
         * @auther: 11432_000
         * @date: 2018/12/12 23:00
         */
        if (files.length == 0){
            return null;
        }
        int orderIndex;
        File file;
        for (int disOrderIndex = 1; disOrderIndex < files.length; disOrderIndex++) {
            file = files[disOrderIndex];
            for (orderIndex = disOrderIndex - 1; orderIndex >= 0; orderIndex--) {
                files[orderIndex + 1] = files[orderIndex];
                if (compareTo(file ,files[orderIndex] ,choiceMode) != -1){
                    break;
                }
            }
            files[orderIndex + 1] = file;
        }
        return files;
    }

    public int getRenameFilesNumber() {
        return renameFilesNumber;
    }

    public int getRenameDirectoryNumber() {
        return renameDirectoryNumber;
    }

    public String getRenameFileName() {
        return renameFileName;
    }

    private  boolean isThisFileSuffix(File file , String fileSuffix){
        /**
         *
         * 功能描述: 判断是否未指定格式的文件
         *
         * @param: [file, fileSuffix]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2018/12/17 17:11
         */
        String path = file.getPath();
        if ("".equals(fileSuffix)){
            return true;
        }
        if (path.endsWith(fileSuffix)){
            return true;
        }
        return false;
    }

    private String getFileSuffix(File file){
        /**
         *
         * 功能描述: 获取文件后缀名
         *
         * @param: [file]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2018/12/17 17:12
         */
        String path = file.getPath();
        int index = path.lastIndexOf(".");
        return index == -1 ? "" : path.substring(index);
    }

    private boolean renameFile(File file ,String fileNamePrefix ,String fileSuffix ,int fileNumber){
        /**
         *
         * 功能描述: 重命名文件
         *
         * @param: [file, fileNamePrefix, fileSuffix, fileNumber]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2018/12/17 17:13
         */
        if ("".equals(fileSuffix)){
            fileSuffix = getFileSuffix(file);
        }
        String fileName = file.getParentFile().getPath() + "\\" + fileNamePrefix + fileNumber + fileSuffix;
        boolean isSuccess = file.renameTo(new File(fileName));
        if (isSuccess){
            this.renameFilesNumber ++;
        }
        return isSuccess;
    }

    private boolean renameDirectory(File file ,String fileNamePrefix,int directoryNumber){
        /**
         *
         * 功能描述: 重命名目录
         *
         * @param: [file, fileNamePrefix, directoryNumber]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2018/12/17 17:13
         */
        String fileName = file.getParentFile().getPath() + "\\" + fileNamePrefix + directoryNumber;
        boolean isSuccess = file.renameTo(new File(fileName));
        if (isSuccess){
            this.renameDirectoryNumber ++;
        }
        return isSuccess;
    }

    private int compareTo(File file1 ,File file2 ,int choiceMode)throws IOException{
        /**
         *
         * 功能描述: 判断两个文件指定时间的先后 0--相同 1--file1 晚于 file2（需要交换） -1--file1 早于 file2
         *
         * @param: [file1, file2]
         * @return: int
         * @auther: 11432_000
         * @date: 2018/12/27 9:43
         */
        if (file1.isDirectory() && file2.isFile()){
            return -1;
        }
        else if (file2.isDirectory() && file1.isFile()){
            return 1;
        }
        else {
            switch(choiceMode){
                case BY_LAST_MODIFIED:
                    return compareToByLastModified(file1 ,file2);
                case BY_CREATE_TIME:
                    return compareToByCreateTime(file1 ,file2);
                default:throw new RuntimeException("不存在该比较方式");
            }
        }
    }

    private int compareToByLastModified(File file1 ,File file2){
        /**
         *
         * 功能描述: 比较两个文件最后修改日期的先后
         *
         * @param: [file1, file2]
         * @return: int
         * @auther: 11432_000
         * @date: 2018/12/27 10:15
         */
        long lastModified01 = file1.lastModified();
        long lastModified02 = file2.lastModified();
        if (lastModified01 == lastModified02){ return 0; }
        else if(lastModified01 > lastModified02){ return 1;}
        return -1;
    }

    private int compareToByCreateTime(File file1 ,File file2)throws IOException{
        /**
         *
         * 功能描述: 比较两个文件创建日期的先后
         *
         * @param: [file1, file2]
         * @return: int
         * @auther: 11432_000
         * @date: 2018/12/27 10:15
         */
        long createTime01 = Files.readAttributes(file1.toPath() ,BasicFileAttributes.class).creationTime().toMillis();
        long createTime02 = Files.readAttributes(file2.toPath() ,BasicFileAttributes.class).creationTime().toMillis();
        if (createTime01 == createTime02){ return 0; }
        else if(createTime01 > createTime02){ return 1;}
        return -1;
    }

    private File[] selectionAlgorithm(File[] files ,int algorithm ,int choiceMode)throws IOException{
        switch (algorithm){
            case USE_BUBBLING_ALGORITHM :
                return sortFilesByBubbling(files ,choiceMode);
            case USE_INSERT_ALGORITHM :
                return sortFilesByInsert(files ,choiceMode);
                default:throw new RuntimeException("不存在该排序算法");
        }
    }
}
