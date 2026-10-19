public class Truck extends Vehicle {
    private double towingCapacity;

    public Truck(String code, String description, int year, double dailyRate, int mileage, double towingCapacity) {
        super(code, description, year, dailyRate, mileage);
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s, rate: $%.1f/day, available: %b (odo: %dmi) (tows %.1flbs)", getCode(),
                getYear(), getDescription(), getDailyRate(), isAvailable(), getMileage(), this.towingCapacity);
    }

    @Override
    public double calcRentalCost(int numOfRentalDays) {
        double rentalCost = (getDailyRate() * numOfRentalDays) + 25.00;
        return rentalCost;
    }
}
