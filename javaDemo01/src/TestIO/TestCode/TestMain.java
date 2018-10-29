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
        /* 0x12 代表12这个数是一个16进制的数 0x为十六进制的标志 */
        int c = b & 0xff;
        System.out.println(a);
        System.out.println(b);
        /* 16进制 */
        System.out.println(0xff);
        /* 8进制 */
        System.out.println(012);
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
