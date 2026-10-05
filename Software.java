
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 04
 * Date: 10/2/2026
 * Helpers: N/A
 */

public class Software extends Product {
    private String version;

    public Software(String code, String description, double price, double discountRate, String version) {
        super(code, description, price, discountRate);
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    @Override
    public double calcDiscountAmount() {
        if (isOnSale()) {
            double discountRate = getDiscountRate() + 0.1;
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
        return (super.toString() + " (ver. " + this.version + ")");
    }
}