
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 01
 * Date: 10/2/2026
 * Helpers: N/A
 */

public class Album extends Product {
    private String artist;

    public Album(String code, String description, double price, double discountRate, String artist) {
        super(code, description, price, discountRate);
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    @Override
    public double calcDiscountAmount() {
        if (isOnSale()) {
            double discountRate = getDiscountRate() + 0.05;
            if (discountRate > 0.5) {
                discountRate = 0.5;
            }
            double discount = getPrice() * discountRate;
            return discount;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return (super.toString() + " (" + this.artist + ")");
    }
}