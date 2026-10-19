public class Vehicle {
    private String code, description;
    private int year, mileage;
    private double dailyRate;
    private boolean available;

    public Vehicle(String code, String description, int year, double dailyRate, int mileage) {
        this.code = code;
        this.description = description;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = true;
        this.mileage = mileage;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public int getYear() {
        return this.year;
    }

    public double getDailyRate() {
        return this.dailyRate;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate < 0) {
            dailyRate = 0;
        }
        this.dailyRate = dailyRate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setMileage(int mileage) {
        if (mileage < 0) {
            mileage = 0;
        }
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s, rate: $%.1f/day, available: %b (odo: %dmi)", getCode(), getYear(),
                getDescription(), getDailyRate(), isAvailable(), getMileage());
    }

    public double calcRentalCost(int numOfRentalDays) {
        double rentalCost = this.dailyRate * numOfRentalDays;
        return rentalCost;
    }
}
