package TestSerializable;

import java.io.*;
import java.util.ArrayList;

/**
 * 说明：测试pojo，自定义序列化1.继承Serliaizable，在不想序列化的属性前加transient关键字（规避JVM默认的序列化）。
 *       2.实现Externalizable接口，在writeExternal方法中实现序列化，在readExternal方法中实现反序列化。
 *       3.重写private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException 和
 *       private void writeObject(ObjectOutputStream var1) throws IOException 方法。
 *
 * @Auther: 11432_000
 * @Date: 2018/10/18 10:53
 * @Description:
 */
public class Pojo implements Externalizable {

    private transient int id;

    private String name;

    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {

        objectOutput.writeObject(this.name);
        objectOutput.writeObject(this.weight);
//        objectOutput.writeObject(this.id);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.name = (String) objectInput.readObject();
        this.weight = (double) objectInput.readObject();
//        this.id = (int) objectInput.readObject();
    }

    /* 和继承Externalizable 接口的区别： 有无defaultWriteObject 方法 */
    private void writeObject(ObjectOutputStream var1) throws IOException{
        /* 将没有加 transient 关键字的属性序列化 */
        var1.defaultWriteObject();
        /* 自定义序列化 */
        var1.writeObject(this.id);
    }


    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException{
        /* 将没有加 transient 关键字的属性反序列化 */
        var1.defaultReadObject();
        /* 自定义序列化属性的反序列化 */
        this.id = (int) var1.readObject();
    }

}
