package JavaReflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/19 11:08
 * @Description:
 */
public class TestClassAPI {

    public static void main(String[] args){

        String a = "555";
        showConstructor(a);
    }


    public static void showClassMessage(Object object){
        Class aClass = object.getClass();
        System.out.println("类名称：" + aClass.getName());
        System.out.println("全部方法列表");
        /* 获取非继承、实现的方法 */
        Method[] methods = aClass.getDeclaredMethods();
        showMethodMessage(methods);
        System.out.println("公有函数列表");
        /* 获取所有public方法 */
        Method[] methods1 = aClass.getMethods();
        showMethodMessage(methods1);
    }

    private static void showMethodMessage(Method[] methods1) {
        for (Method method : methods1){
            /* getReturnType() 返回返回值的类类型 */
            System.out.print(method.getReturnType().getName() + ' ');
            System.out.print(method.getName() + "(");
            /* 获取参数类型数组 */
            Class[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class cla = parameterTypes[i];
                if (i < parameterTypes.length - 1){
                    /* 获取类的简单名称 */
                    System.out.print(cla.getSimpleName() + ",");
                }else {
                    System.out.print(cla.getSimpleName() + ")");
                }
            }
            if (parameterTypes.length == 0){
                System.out.print(")");
            }
            System.out.println();
        }
    }

    public static void showProperty(Object object){
        Class<?> objectClass = object.getClass();
        /* 获取所有该类声明的属性 */
        Field[] fields = objectClass.getDeclaredFields();
        System.out.println("参数列表");
        for (Field field : fields){
            System.out.println(field.getType().getTypeName() + " " + field.getName());
        }
    }

    public static void showConstructor(Object object) {
        Class<?> objectClass = object.getClass();
        /* 获取所有非继承的构造函数 */
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            /* 获取方法所有参数 */
            Parameter[] parameters = constructor.getParameters();
            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.print(constructor.getName() + "(");
            for (Class cla : parameterTypes){
                System.out.print(cla.getTypeName() + ",");
            }
            System.out.print(")");
            System.out.println();
        }
    }
}
