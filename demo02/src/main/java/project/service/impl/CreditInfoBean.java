package project.service.impl;

import java.math.BigDecimal;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/24 10:34
 * @Description:
 */
public class CreditInfoBean {
    private String companyName;
    private String billType;
    private String billNumber;
    private BigDecimal buyerBillAmount;
    private String receiveTime;
    private String buyerRemark;
    private String buyerBillStatus;

    public String getBuyerBillStatus() {
        return buyerBillStatus;
    }

    public void setBuyerBillStatus(String buyerBillStatus) {
        this.buyerBillStatus = buyerBillStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public BigDecimal getBuyerBillAmount() {
        return buyerBillAmount;
    }

    public void setBuyerBillAmount(BigDecimal buyerBillAmount) {
        this.buyerBillAmount = buyerBillAmount;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }
}
