package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:16
 * @Description:
 */
public class Handler004 extends MyHandler{

    public Handler004(MyHandler next) {
        super(next);
    }

    @Override
    void ICanDo(double discount) {
        if (discount >= DiscountPower.CEO.getDiscount()){
            System.out.println("CEO批准了");
        }else {
            System.out.println("滚！没钱别买");
        }
    }
}
