package TestIO;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 说明：将java文件进行编译生成.class文件并加载到内存中  返回编译类的类类型。
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 10:39
 * @Description:
 */
public class JavaCompileTest {

    public static void main(String[] args){
        String classPath = JavaCompileTest.getClassPath(
                "D:/idea-file/javaDemo01/src/TestDesignPattern/ImitateJdkProxy/$Proxy0.java",
                "test.mayao.hhh");
        System.out.println(classPath);
    }

    public static Class compileJavaFile(String fileFullPath, String targetPackageName) throws Exception{
        /* 通过工具供应商获取系统java编译器 */
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        /* 获取文件管理器 */
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(
                null, null, null);
        /* 获取java文件 */
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(fileFullPath);
        /* 编译文件 */
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null,
                standardFileManager, null, null, null, javaFileObjects);
        /* 进行编译 */
        task.call();
        standardFileManager.close();
        /* 获取类加载器 */
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        /* 加载类获取类类型 */
        Class<?> clazz = systemClassLoader.loadClass(getClassPath(fileFullPath, targetPackageName));
        return clazz;
    }

    private static String getClassPath(String fileFullPath, String pakeageName){
        String javaFileName = "";
        if (fileFullPath.indexOf("\\") <= 0){
            javaFileName = fileFullPath.substring(fileFullPath.lastIndexOf(
                    "/", fileFullPath.lastIndexOf(".")) + 1);
        }else {
            javaFileName = fileFullPath.substring(fileFullPath.lastIndexOf(
                    "\\", fileFullPath.lastIndexOf(".")) + 1);
        }

        return pakeageName+ "." + javaFileName;
    }
}
