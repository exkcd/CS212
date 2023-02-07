import java.util.ArrayList;
import java.util.Date;

class OrderItem {
    private int qty;
    private Product product;

    public OrderItem(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Amount: " + qty
                + "\nItem: " + product;
    }
}

class Order {
    private String orderNum;
    private Date orderDate;
    private ArrayList<OrderItem> orderItem;
    private double itemSubtotal;
    private double shipHandFee;
    private double tax;
    private double grandTotal;
    private Customer customer;
    private Payment payment;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public double getItemSubtotal() {
        return itemSubtotal;
    }

    public void setItemSubtotal(double itemSubtotal) {
        this.itemSubtotal = itemSubtotal;
    }

    public double getShipHandFee() {
        return shipHandFee;
    }

    public void setShipHandFee(double shipHandFee) {
        this.shipHandFee = shipHandFee;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /*public Order(String orderNum, Date orderDate, ArrayList<OrderItem> orderItem, double itemSubtotal, double shipHandFee, double tax, double grandTotal, Customer customer, Payment payment) {
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        this.orderItem = orderItem;
        this.itemSubtotal = itemSubtotal;
        this.shipHandFee = shipHandFee;
        this.tax = tax;
        this.grandTotal = grandTotal;
        this.customer = customer;
        this.payment = payment;
    } */
}

