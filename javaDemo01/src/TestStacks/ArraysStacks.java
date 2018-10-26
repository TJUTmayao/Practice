package TestStacks;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/21 13:40
 * @Description:
 */
public class ArraysStacks {

    private String[] charList;
    private int num;
    private int top;

    public ArraysStacks(int n){
        this.charList = new String[n];
        this.num = n;
        this.top = 0;
    }

    public boolean push(String c){
        if (top < num){
            charList[top] = c;
            top++;
            return true;
        }else {
            return false;
        }
    }

    public String out(){
        if (top > 0){
            return charList[--top];
        }else{
            return null;
        }
    }

    public int getTop(){
        return this.top;
    }
}
