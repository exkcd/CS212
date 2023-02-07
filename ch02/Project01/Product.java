import java.text.NumberFormat;
import java.text.SimpleDateFormat;

enum Condition{New, Used, Reconditioned}
class Product {
    private String productId;
    private String productDes;
    private String soldBy;
    private double price;
    private Condition condition;

    public String getProductId() {
        return productId;
    }

    public String getProductDes() {
        return productDes;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public double getPrice() {
        return price;
    }

    public Condition getCondition() {
        return condition;
    }

    public Product(String productId, String productDes, String soldBy, double price, Condition condition) {
        this.productId = productId;
        this.productDes = productDes;
        this.soldBy = soldBy;
        this.price = price;
        this.condition = condition;
    }

    @Override
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();

        return productId + ", " + productDes
                + "\nSold by: " + soldBy
                + "\nPrice: " + money.format(price)
                + "\nCondition: " + condition + "\n";
    }
}
