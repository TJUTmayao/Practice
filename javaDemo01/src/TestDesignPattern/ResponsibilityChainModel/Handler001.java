package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:16
 * @Description:
 */
public class Handler001 extends MyHandler{

    public Handler001(MyHandler next) {
        super(next);
    }

    @Override
    void ICanDo(double discount) {
        if (discount >= DiscountPower.RECEPTIONIST.getDiscount()){
            System.out.println("接待批准了");
        }else {
            next.ICanDo(discount);
        }
    }
}
