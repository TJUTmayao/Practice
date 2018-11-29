package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:16
 * @Description:
 */
public class Handler003 extends MyHandler{

    public Handler003(MyHandler next) {
        super(next);
    }

    @Override
    void ICanDo(double discount) {
        if (discount >= DiscountPower.PROJECT_MANAGER.getDiscount()){
            System.out.println("项目经理批准了");
        }else {
            next.ICanDo(discount);
        }
    }
}
