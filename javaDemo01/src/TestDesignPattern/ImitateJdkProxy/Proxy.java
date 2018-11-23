package TestDesignPattern.ImitateJdkProxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 说明：模拟jdk动态代理
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 14:06
 * @Description:
 */
public class Proxy {

    public static Object newProxyInstance (Class inter, InvocationHandler handler) throws Exception{
        String methodStr = "";
        String classStr = "";
        for (Method method : inter.getMethods()){
            methodStr += "    @Override\n" +
                    "    public "+ method.getReturnType().getTypeName() +" "+ method.getName() +"("+getArgs(method)+") {\n" +
                    "        try {\n" +
                    "            Method m = "+inter.getName()+".class.getMethod(\""+method.getName()+"\");\n" +
                    "            handler.invoke(this, m);\n" +
                    "        } catch (NoSuchMethodException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "    }\n";
        }
        classStr = "package TestDesignPattern.ImitateJdkProxy;\n" +
                "import java.lang.reflect.Method;\n" +
                "import TestDesignPattern.ImitateJdkProxy.InvocationHandler;\n" +
                "public class $Proxy0 implements "+ inter.getName() +"{\n" +
                "\n" +
                "    private InvocationHandler handler;\n" +
                "    public $Proxy0(InvocationHandler handler) {\n" +
                "         this.handler = handler;\n" +
                "    }\n" +
                methodStr + "\n" +
                "}\n";
        /* 将原码写入文件 */
        String fileName = "D:/idea-file/javaDemo01/src/TestDesignPattern/ImitateJdkProxy/$Proxy0.java";
        File file = new File(fileName);
        byte[] bytes = classStr.getBytes();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        /* 编译原码 */
        /* 获取java编译器 */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /* 文件管理器 */
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                null,null,null);
        /* 获取文件 */
        Iterable units = fileManager.getJavaFileObjects(fileName);
        /* 编译文件 */
        JavaCompiler.CompilationTask task = compiler.getTask(null,
                fileManager, null, null, null, units);
        /* 执行编译 */
        task.call();
        fileManager.close();
        /* 加载到内存 */
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> loadClass = classLoader.loadClass("TestDesignPattern.ImitateJdkProxy.$Proxy0");
        /* 创建代理对象 */
        Constructor<?> constructor = loadClass.getConstructor(InvocationHandler.class);
        return constructor.newInstance(handler);
    }

    private static String getArgs(Method m){
        String args = "";
        String parameterStr = "";
        boolean first = true;
        int num = 0;
        Parameter[] parameters = m.getParameters();
        for (final Parameter parameter : parameters){
            parameterStr = parameter.getType().getTypeName() + " " + "arg" + String.valueOf(num);
            if (first){
                args += parameterStr;
                first = false;
            }else {
                args += "," + parameterStr ;
            }
            num ++;
        }
        return args;
    }
}
