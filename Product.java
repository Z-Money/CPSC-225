public class Product {
    private String code, description;
    private double price, discountRate;
    private boolean onSale;
    private int quantity;

    public Product(String code, String description, double price, double discountRate, boolean onSale, int quantity) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.discountRate = discountRate;
        this.onSale = onSale;
        this.quantity = quantity;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public boolean getOnSale() {
        return this.onSale;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Description: " + getDescription() + ", Price: %.2f", getPrice());
    }

    // public abstract class calcDiscountAmount(){};

    public static void main(String args[]) {
        Product p = new Product("0", "Coffee Mug", 9.99, 0, false, 1);
        System.out.println(p);
    }
}