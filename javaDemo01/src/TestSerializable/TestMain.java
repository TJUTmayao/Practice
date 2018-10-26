package TestSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

/**
 * 说明：自定义序列化
 *
 * @Auther: 11432_000
 * @Date: 2018/10/18 11:01
 * @Description:
 */
public class TestMain {

    public static void main(String[] arg)throws Exception{
        FileOutputStream out = null;
        ObjectOutputStream outputStream = null;
        FileInputStream in = null;
        ObjectInputStream objectInputStream = null;
        Pojo pojo = new Pojo();
        pojo.setId(2555);
        pojo.setName("mayao");
        pojo.setWeight(75.5);
        out = new FileOutputStream("D://TestSerializable.txt");
        outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(pojo);
        outputStream.close();

        in = new FileInputStream("D://TestSerializable.txt");
        objectInputStream = new ObjectInputStream(in);

        Pojo s = (Pojo) objectInputStream.readObject();

        Field[] fields = s.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName() + " " + field.get(s).toString());
        }
        System.out.println(s.getId());
    }
}
