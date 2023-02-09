import java.util.Date;

enum PaymentType{CreditCard, BankTransfer, Mail, RewardsVisa}

class Payment{
    private PaymentType paymentType;
    private String accNum; // Credit card num that needs to be omitted.
    private String bankIssuer; // Like AmEx, Chase, etc.
    private double paymentAmt;
    private Date paymentDate;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getBankIssuer() {
        return bankIssuer;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public void setBankIssuer(String bankIssuer) {
        this.bankIssuer = bankIssuer;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
