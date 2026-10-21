public class Motorcycle extends Vehicle {
    private int engineCC;

    public Motorcycle(String code, String description, int year, double dailyRate, int mileage, int engineCC) {
        super(code, description, year, dailyRate, mileage);
        this.engineCC = engineCC;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s, rate: $%.1f/day, available: %b (odo: %dmi) (%dcc)", getCode(), getYear(),
                getDescription(), getDailyRate(), isAvailable(), getMileage(), this.engineCC);
    }

    @Override
    public double calcRentalCost(int numOfRentalDays) {
        double rentalCost;
        if (this.engineCC >= 1000) {
            rentalCost = (getDailyRate() + 15.00) * numOfRentalDays;
        } else {
            rentalCost = getDailyRate() * numOfRentalDays;
        }
        return rentalCost;
    }
}
