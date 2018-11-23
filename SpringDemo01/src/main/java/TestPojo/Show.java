package TestPojo;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/31 15:17
 * @Description:
 */
public class Show {

    private String showValue;

    public void show(){
        System.out.println("展示的值为：" + this.showValue);
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }
}
