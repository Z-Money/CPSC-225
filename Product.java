
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 04
 * Date: 10/2/2026
 * Helpers: N/A
 */

public abstract class Product {
    private String code, description;
    private double price, discountRate;
    private boolean onSale;
    private int quantity;

    public Product(String code, String description, double price, double discountRate) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.discountRate = discountRate;
        this.onSale = false;
        this.quantity = 0;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    public boolean isOnSale() {
        return this.onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double calcDiscountAmount();

    @Override
    public String toString() {
        return String.format("%s %s $%.2f onSale: %b (%.2f) quantity: %d", getCode(), getDescription(), getPrice(),
                isOnSale(), getDiscountRate(), getQuantity());
    }
}