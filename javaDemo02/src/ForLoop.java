/**
 * 说明：for循环练习
 *
 * @Auther: 11432_000
 * @Date: 2018/11/28 09:44
 * @Description:
 */
public class ForLoop {
    public static void main(String[] args){
        for (int i = 0,j = 0;i < 10; i++,j = (int) Math.pow(i,2)){
            System.out.println(i + "  " + j);
        }
        for (int i = 1;i <= 9;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(i + "*" + j + "=" +(i*j) + "\t");
            }
            System.out.println();
        }
    }
}
