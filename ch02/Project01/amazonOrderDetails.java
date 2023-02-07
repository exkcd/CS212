/* This project showcases the use of Java methods, classes and objects through emulating an Amazon checkout order
 * summary and invoice for shipping.
 *
 * R Stone
 */

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class amazonOrderDetails {
    // initialize
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // for formatting the date
    SimpleDateFormat neatly = new SimpleDateFormat("MMMM dd, yyyy"); // for printing out the date
    NumberFormat money = NumberFormat.getCurrencyInstance(); // for formatting currency
    ArrayList<OrderItem> oi = new ArrayList<>(); // order items are different from the products
    ArrayList<Product> products = new ArrayList<>(); // products are the actual items
    Order order = new Order();
    Customer c1 = new Customer();
    Shipment s1 = new Shipment();
    Payment p1 = new Payment();


    public void addProducts() {
        // init new products to buy
        Product prod1 = new Product("Misery", "It's like Paramore, but worse!", "Fueled by Ramen", 99.99, Condition.Used);
        Product prod2 = new Product("Pain", "Oh the agony...", "SoftMicro", 69.69, Condition.Reconditioned);
        Product prod3 = new Product("Sadness", "Thnx fr th Mmrs", "Fall Out Boy", 4.20, Condition.New);

        // init products as purchased items
        OrderItem item1 = new OrderItem(1, prod1);
        OrderItem item2 = new OrderItem(5, prod2);
        OrderItem item3 = new OrderItem(50, prod3);

        // add items to the OrderItems ArrayList
        oi.add(item1);
        oi.add(item2);
        oi.add(item3);

        // add products to an ArrayList
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
    }

    public void createOrder() throws ParseException {

        // init customer details
        c1.setCustomerName("P Sherman");
        c1.setCustomerId(1234556);
        c1.setContact("psherman@42wallabywaysydney.net");
        c1.setStreetAddress("42 Wallaby Way");
        c1.setCityStateZip("Sydney, NSW 10012");
        c1.setCountry("Australia");

        addProducts();
        createShipment();
        createPayment();

        ArrayList<Double> itemTotal = new ArrayList<>(); // needed a way to count specifically the item price

        for (int i = 0; i != products.size(); i++) {
            itemTotal.add(products.get(i).getPrice());
        }

        double sum = itemTotal.stream().mapToDouble(Double::doubleValue).sum(); // turns the newly created item Array into a sum of all the items bought.

        // made the order
        order.setOrderNum("144-36-2048");
        order.setOrderDate(sdf.parse("30/04/2023"));
        order.setOrderItem(oi);
        order.setItemSubtotal(sum);
        order.setShipHandFee(4);
        order.setTax((order.getItemSubtotal() * 0.06) + order.getItemSubtotal());
        order.setGrandTotal(Double.sum(order.getTax(), order.getShipHandFee()));
        order.setCustomer(c1);
        order.setPayment(p1);

    }

    public void createPayment() throws ParseException {
        p1.setPaymentType(PaymentType.CreditCard);
        p1.setAccNum("132-444-2347-7744");
        p1.setBankIssuer("American Express");
        p1.setPaymentAmt(73);
        p1.setPaymentDate(sdf.parse("01/05/2023"));
    }

    public void createShipment() throws ParseException {
        s1.setShipmentId("12849");
        s1.setCarrier("FedEx");
        s1.setShipmentStatus(ShipmentStatus.Shipped);
        s1.setShippedDate(sdf.parse("02/05/2023"));
        s1.setDeliveryDate(sdf.parse("07/05/2023"));
        s1.setShipmentSpeed(ShipmentSpeed.Express);
    }

    public void printOrderDetails() {

        // formatting. this whole shebang is formatting
        System.out.println("*************");
        System.out.println("Order details");
        System.out.println("*************");

        System.out.println("Ordered on " + neatly.format(order.getOrderDate()) + " Order # " + order.getOrderNum());
        System.out.println("\nOrder account: #" + c1.getCustomerId() + "\nEmail: " + c1.getContact());

        System.out.println("\nShipping address:");
        System.out.println(order.getCustomer());

        System.out.println("\nPayment method:");
        System.out.println(p1.getPaymentType());
        System.out.println("****" + p1.getAccNum().substring(p1.getAccNum().length() - 4));

        System.out.println("\nOrder summary\n");

        System.out.println("Item(s) subtotal:\n" + money.format(order.getItemSubtotal()));
        System.out.println("Shipping and handling:\n" + money.format(order.getShipHandFee()));
        System.out.println("Total before tax:\n" + money.format(Double.sum(order.getItemSubtotal(), order.getShipHandFee())));
        System.out.println("Estimated tax to be collected:\n" + money.format(order.getTax()));
        System.out.println("Grand total:\n" + money.format(order.getGrandTotal()));

        System.out.println("\nDelivered on " + neatly.format(s1.getDeliveryDate()) + "\n");

        for (Product j : products) {
            System.out.println(j);
        }
    }

    public void printInvoice() {

        // same with this. all formatting
        System.out.println("***********************************************************");
        System.out.println("Final details for Order # " + order.getOrderNum());
        System.out.println("***********************************************************");

        System.out.println("Order placed: " + neatly.format(order.getOrderDate()));
        System.out.println("Order number: # " + order.getOrderNum());
        System.out.println("Order total: " + money.format(order.getGrandTotal()));

        System.out.println("\nShipped on " + neatly.format(s1.getShippedDate()));
        System.out.println("Expected delivery date: " + neatly.format(s1.getDeliveryDate()));
        System.out.println("\nShipment speed: " + s1.getShipmentSpeed());

        System.out.println("\nItems ordered\n");
        for (OrderItem i : oi) {
            System.out.println(i);
        }

        System.out.println("\nDetails\n");
        System.out.println("Shipping address\n" + order.getCustomer());

        System.out.println("\nBilling address\n");
        System.out.println(order.getCustomer());

        System.out.println("\nPayment method");
        System.out.println(p1.getPaymentType() + " ending in ****" + p1.getAccNum().substring(p1.getAccNum().length() - 4)
                + " Paid on: " + neatly.format(p1.getPaymentDate()));

        System.out.println("\nItem(s) subtotal: " + money.format(order.getItemSubtotal()));
        System.out.println("Shipping and handling: " + money.format(order.getShipHandFee()));
        System.out.println("Total before tax: " + money.format(Double.sum(order.getItemSubtotal(), order.getShipHandFee())));
        System.out.println("Estimated tax to be collected: " + money.format(order.getTax()));
        System.out.println("\nGrand total: " + money.format(order.getGrandTotal()));
    }

    public static void main(String[] args) throws ParseException {

        // main driver to print it all to the console!
        amazonOrderDetails od = new amazonOrderDetails();
        od.createOrder();
        od.printOrderDetails();
        od.printInvoice();
    }
}