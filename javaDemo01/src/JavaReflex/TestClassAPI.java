package JavaReflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        Method[] methods = aClass.getDeclaredMethods();
        showMethodMessage(methods);
        System.out.println("公有函数列表");
        Method[] methods1 = aClass.getMethods();
        showMethodMessage(methods1);
    }

    private static void showMethodMessage(Method[] methods1) {
        for (Method method : methods1){
            /* getReturnType() 返回返回值的类类型 */
            System.out.print(method.getReturnType().getName() + ' ');
            System.out.print(method.getName() + "(");
            Class[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class cla = parameterTypes[i];
                if (i < parameterTypes.length - 1){
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
        Field[] fields = objectClass.getDeclaredFields();
        System.out.println("参数列表");
        for (Field field : fields){
            System.out.println(field.getType().getTypeName() + " " + field.getName());
        }
    }

    public static void showConstructor(Object object) {
        Class<?> objectClass = object.getClass();
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
        for (Constructor constructor : constructors){
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
