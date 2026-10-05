
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 04
 * Date: 10/2/2026
 * Helpers: N/A
 */

public class Book extends Product {
    private String author;

    public Book(String code, String description, double price, double discountRate, String author) {
        super(code, description, price, discountRate);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public double calcDiscountAmount() {
        if (isOnSale()) {
            double discount = getPrice() * getDiscountRate();
            if (discount > 20.00) {
                discount = 20.00;
            }
            return discount;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return (super.toString() + " By: " + this.author);
    }
}