public class Car extends Vehicle {
    private int seats;

    public Car(String code, String description, int year, double dailyRate, int mileage, int seats) {
        super(code, description, year, dailyRate, mileage);
        this.seats = seats;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s, rate: $%.1f/day, available: %b (odo: %dmi) (seats: %d)", getCode(), getYear(),
                getDescription(), getDailyRate(), isAvailable(), getMileage(), this.seats);
    }

    @Override
    public double calcRentalCost(int numOfRentalDays) {
        double rentalCost;
        if (numOfRentalDays >= 7) {
            rentalCost = (getDailyRate() * numOfRentalDays) * 0.9;
        } else {
            rentalCost = getDailyRate() * numOfRentalDays;
        }
        return rentalCost;
    }
}
