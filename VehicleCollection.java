import java.util.ArrayList;

public class VehicleCollection {
    private ArrayList<Vehicle> vehicles;

    public VehicleCollection() {
        this.vehicles = new ArrayList<>();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        for (Vehicle v : this.vehicles) {
            if (vehicle.getCode().equals(v.getCode())) {
                return null;
            }
        }
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle lookupVehicle(String code) {
        for (Vehicle v : this.vehicles) {
            if (code.equals(v.getCode())) {
                return v;
            }
        }
        return null;
    }

    public Vehicle removeVehicle(String code) {
        Vehicle vehicle = lookupVehicle(code);
        if (vehicle == null) {
            return null;
        }
        vehicles.remove(vehicle);
        return vehicle;
    }

    public int updateMileage(Vehicle vehicle, int mileage) {
        if (mileage < vehicle.getMileage()) {
            return -1;
        }
        vehicle.setMileage(mileage);
        return mileage;
    }

    public void toggleAvailability(Vehicle vehicle) {
        vehicle.setAvailable(!vehicle.isAvailable());
    }

    public Vehicle getVehicle(int index) {
        if (index >= this.vehicles.size() || index < 0) {
            return null;
        }
        return vehicles.get(index);
    }

    public ArrayList<Vehicle> getUnavailableVehicles() {
        ArrayList<Vehicle> unavailableVehicles = new ArrayList<>();
        for (Vehicle v : this.vehicles) {
            if (!v.isAvailable()) {
                unavailableVehicles.add(v);
            }
        }
        return unavailableVehicles;
    }

    public int getTotalVehicleCount() {
        return vehicles.size();
    }

    public int[] getTypeCounts() {
        int[] typeCounts = new int[3];
        for (Vehicle v : this.vehicles) {
            if (v instanceof Car) {
                typeCounts[0]++;
            } else if (v instanceof Truck) {
                typeCounts[1]++;
            } else if (v instanceof Motorcycle) {
                typeCounts[2]++;
            }
        }
        return typeCounts;
    }

    public double getAverageDailyRate() {
        if (this.vehicles.isEmpty()) {
            return 0.0;
        }
        double totalDailyRate = 0.0;
        for (Vehicle v : this.vehicles) {
            totalDailyRate += v.getDailyRate();
        }
        return (totalDailyRate / this.vehicles.size());
    }

    public Vehicle getHighest3DayEstimate() {
        double highestEstimate = 0.0;
        Vehicle vehicle = null;
        for (Vehicle v : this.vehicles) {
            if (v.isAvailable()) {
                double rentalCost = v.calcRentalCost(3);
                if (vehicle == null || rentalCost > highestEstimate) {
                    highestEstimate = rentalCost;
                    vehicle = v;
                }
            }
        }
        return vehicle;
    }
}
