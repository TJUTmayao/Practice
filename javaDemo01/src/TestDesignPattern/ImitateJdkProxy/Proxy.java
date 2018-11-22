package TestDesignPattern.ImitateJdkProxy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.InvocationHandler;
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
            methodStr += " @Override\n" +
                    "    public "+ method.getReturnType().getTypeName() +" "+ method.getName() +"() {\n" +
                    "try {\n" +
                    "            Method m = "+inter.getName()+".getClass().getMethod(\""+method.getName()+"\");\n" +
                    "            handler.invoke(this, m)\n" +
                    "        } catch (NoSuchMethodException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "    }";
        }
        classStr = "package TestDesignPattern.ProxyPattern;\n" +
                "import java.lang.reflect.Method;\n" +
                "import TestDesignPattern.ImitateJdkProxy.InvocationHandler;\n" +
                "public class $Proxy0 implements "+ inter.getName() +"{\n" +
                "\n" +
                "private InvocationHandler h;\n" +
                "    public $Proxy0(InvocationHandler h) {" +
                "         this.h = h;\n" + "}\n" +
                methodStr + "\n" +
                "}\n";
        String fileName = "D:/idea-file/javaDemo01/src/TestDesignPattern/ImitateJdkProxy/$Proxy0.java";
        File file = new File(fileName);
        FileUtils.writeStringToFile(file ,classStr,"UTF-8");
        return null;
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
