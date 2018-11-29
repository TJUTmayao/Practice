package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:21
 * @Description:
 */
public enum DiscountPower {
    /** */
    RECEPTIONIST(0.95),RECEPTION_MASTER(0.70),PROJECT_MANAGER(0.60),CEO(0.50);

    private final double discount;

    DiscountPower(double discount) {
        this.discount = discount;
    }

    double getDiscount(){
        return this.discount;
    }
}
