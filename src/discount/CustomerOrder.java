package discount;

public class CustomerOrder {

    private String customerName;
    private double billAmount;
    private char discountType;

    public DiscountTypes discountTypes;

    public CustomerOrder(String customerName, double billAmount, char discountType) {
        this.customerName = customerName;
        this.billAmount = billAmount;
        this.discountType = discountType;
    }

    public double getBillAmount() {
        double tempBill;
        switch (discountType) {
            case 'S':
            case 's':
                discountTypes = new Sale();
                break;
            case 'D':
            case 'd':
                discountTypes = new Discount();
                break;
            case 'L':
            case 'l':
                discountTypes = new Liquidation();
                break;
            default:
                tempBill = billAmount;
        }
        tempBill = billAmount- (billAmount * getDiscountType());
        return tempBill;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscountType(){
        return discountTypes.discount();
    }
    public void setDiscountType(DiscountTypes newDiscountType){
        discountTypes = newDiscountType;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "customerName='" + customerName + '\''
                + ", billAmount=" + billAmount
                + ", discountType=" + discountType
                + '}';
    }
}

