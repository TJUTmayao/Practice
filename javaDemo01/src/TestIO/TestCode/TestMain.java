package TestIO.TestCode;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/26 11:34
 * @Description:
 */
public class TestMain {

    public static void main(String[] arg){
        String string = "我是mayao";
        byte[] bytes1 = string.getBytes();
        byte b = -127;
        int a = b;
        int c = b & 0xff;
        System.out.println(a);
        System.out.println(b);
        System.out.println(0xff);
        for (byte x : bytes1){
            /* 加 & 0xff 是为了保证二进制补码的一致性 */
            System.out.print(Integer.toHexString(x) + " " + ((int) x) + " ");
        }
        System.out.println();
        for (byte x : bytes1){
            System.out.print(Integer.toHexString(x & 0xff) + " ");
        }
    }
}
