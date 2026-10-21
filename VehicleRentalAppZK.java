import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalAppZK {
    public static void main(String args[]) {
        VehicleRentalAppZK app = new VehicleRentalAppZK();
        app.runApp();
    }

    public void runApp() {
        Scanner scan = new Scanner(System.in);
        VehicleCollection fleet = new VehicleCollection();

        // Cars
        fleet.addVehicle(new Car("C001", "Toyota Camry", 2022, 55.00, 24500, 5));
        fleet.addVehicle(new Car("C002", "Honda Civic", 2023, 50.00, 18200, 5));
        fleet.addVehicle(new Car("C003", "Ford Mustang", 2021, 85.00, 31000, 4));
        fleet.addVehicle(new Car("C004", "Chevy Malibu", 2020, 48.00, 42000, 5));
        fleet.addVehicle(new Car("C005", "Nissan Altima", 2022, 52.00, 27500, 5));
        fleet.addVehicle(new Car("C006", "BMW 3 Series", 2023, 95.00, 15000, 5));
        fleet.addVehicle(new Car("C007", "Hyundai Elantra", 2021, 45.00, 36500, 5));
        // Trucks
        fleet.addVehicle(new Truck("T001", "Ford F-150", 2022, 90.00, 28000, 13000));
        fleet.addVehicle(new Truck("T002", "Chevy Silverado", 2021, 95.00, 41000, 12000));
        fleet.addVehicle(new Truck("T003", "Ram 1500", 2023, 100.00, 17000, 12750));
        fleet.addVehicle(new Truck("T004", "Toyota Tundra", 2022, 92.00, 23000, 11000));
        fleet.addVehicle(new Truck("T005", "GMC Sierra", 2020, 88.00, 52000, 11500));
        fleet.addVehicle(new Truck("T006", "Ford Ranger", 2023, 75.00, 12000, 7500));
        fleet.addVehicle(new Truck("T007", "Nissan Frontier", 2021, 72.00, 35000, 6700));
        // Motorcycles
        fleet.addVehicle(new Motorcycle("M001", "Honda Rebel 500", 2023, 65.00, 8500, 471));
        fleet.addVehicle(new Motorcycle("M002", "Yamaha MT-07", 2022, 70.00, 6200, 689));
        fleet.addVehicle(new Motorcycle("M003", "Kawasaki N650", 2021, 75.00, 9100, 649));
        fleet.addVehicle(new Motorcycle("M004", "HD Sportster", 2020, 85.00, 14500, 1202));
        fleet.addVehicle(new Motorcycle("M005", "Honda Gold Wing", 2023, 110.00, 4200, 1833));
        fleet.addVehicle(new Motorcycle("M006", "Yamaha YZF-R1", 2022, 100.00, 5100, 998));
        fleet.addVehicle(new Motorcycle("M007", "Ducati Panigale", 2023, 125.00, 2800, 1103));

        while (true) {
            displayMenu();
            int choice = getUserChoice(scan);
            if (choice == 0) {
                break;
            }
            handleChoice(choice, fleet, scan);
        }
        scan.close();
    }

    public String promptString(Scanner scan, String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    public int promptInt(Scanner scan, String prompt, int min, int max) {
        while (true) {
            String valueStr = promptString(scan, prompt);
            try {
                int value = Integer.parseInt(valueStr);

                if (value < min && min != -1) {
                    System.out.println("Value out of range!");
                    continue;
                } else if (value > max && max != -1) {
                    System.out.println("Value out of range!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
            }
        }
    }

    public double promptDouble(Scanner scan, String prompt, double min, double max) {
        while (true) {
            String valueStr = promptString(scan, prompt);
            try {
                double value = Double.parseDouble(valueStr);

                if (value < min && min != -1) {
                    System.out.println("Value out of range!");
                    continue;
                } else if (value > max && max != -1) {
                    System.out.println("Value out of range!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double value.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("1. Add Vehicle");
        System.out.println("2. Look Up Vehicle");
        System.out.println("3. Remove Vehicle");
        System.out.println("4. Update Mileage");
        System.out.println("5. Toggle Availability");
        System.out.println("6. Calculate Rental Estimate");
        System.out.println("7. Print Fleet");
        System.out.println("8. Print Unavailable Vehicles");
        System.out.println("9. Print Summary Statistics");
        System.out.println("0. Exit");
    }

    public int getUserChoice(Scanner scan) {
        return promptInt(scan, "Choose an option from the menu above: ", 0, 9);
    }

    public void handleChoice(int userChoice, VehicleCollection fleet, Scanner scan) {
        switch (userChoice) {
            case 1 -> addVehicle(scan, fleet);
            case 2 -> lookupVehicle(scan, fleet);
            case 3 -> removeVehicle(scan, fleet);
            case 4 -> updateMileage(scan, fleet);
            case 5 -> toggleAvailability(scan, fleet);
            case 6 -> calculateRentalEstimate(scan, fleet);
            case 7 -> printFleet(fleet);
            case 8 -> printUnavailable(fleet);
            case 9 -> printSummaryStats(fleet);
        }
    }

    public Vehicle addVehicle(Scanner scan, VehicleCollection fleet) {
        System.out.print("1. Car\n2. Truck\n3. Motorcycle\n");
        int vehicleType = promptInt(scan, "Choose an option from the menu above: ", 1, 3);
        String code = promptString(scan, "Enter the vehicle's code: ");
        String description = promptString(scan, "Enter the vehicle's description: ");
        int year = promptInt(scan, "Enter the vehicle's manufactured year: ", 1900, 2050);
        double dailyRate = promptDouble(scan, "Enter the vehicle's daily rate: ", 0.1, 9999);
        int mileage = promptInt(scan, "Enter the vehicle's mileage: ", 0, -1);
        Vehicle vehicle = null;
        switch (vehicleType) {
            case 1 -> {
                int numOfSeats = promptInt(scan, "Enter the number of seats: ", 1, -1);
                vehicle = new Car(code, description, year, dailyRate, mileage, numOfSeats);
            }
            case 2 -> {
                double towingCapacity = promptDouble(scan, "Enter the towing capacity: ", 0, -1);
                vehicle = new Truck(code, description, year, dailyRate, mileage, towingCapacity);
            }
            case 3 -> {
                int engineCC = promptInt(scan, "Enter the engine CC: ", 0, -1);
                vehicle = new Motorcycle(code, description, year, dailyRate, mileage, engineCC);
            }
        }
        Vehicle addedVehicle = fleet.addVehicle(vehicle);
        if (addedVehicle == null) {
            System.out.println("Vehicle with that code already exists.");
            return null;
        }
        return vehicle;
    }

    public void lookupVehicle(Scanner scan, VehicleCollection fleet) {
        String code = promptString(scan, "Enter the vehicle's code: ");
        Vehicle vehicle = fleet.lookupVehicle(code);
        if (vehicle == null) {
            System.out.println("No vehicles found with that code.");
        } else {
            System.out.printf("Found vehicle:%n%s%n", vehicle);
        }
    }

    public void removeVehicle(Scanner scan, VehicleCollection fleet) {
        String code = promptString(scan, "Enter the vehicle's code: ");
        Vehicle vehicle = fleet.removeVehicle(code);
        if (vehicle == null) {
            System.out.println("Operation failed. No vehicles removed.");
        } else {
            System.out.printf("Removed successfully. Vehicle removed:%n%s%n", vehicle);
        }
    }

    public void updateMileage(Scanner scan, VehicleCollection fleet) {
        String code = promptString(scan, "Enter the vehicle's code: ");
        Vehicle vehicle = fleet.lookupVehicle(code);
        if (vehicle == null) {
            System.out.println("No vehicles found with that code.");
        } else {
            int mileage = promptInt(scan, "Enter the new mileage: ", 0, -1);
            int updatedMileage = fleet.updateMileage(vehicle, mileage);
            if (mileage == -1) {
                System.out.println("Mileage failed to update.");
            } else {
                System.out.printf("Mileage updated to %dmi successfully.%n", mileage);
            }
        }
    }

    public void toggleAvailability(Scanner scan, VehicleCollection fleet) {
        String code = promptString(scan, "Enter the vehicle's code: ");
        Vehicle vehicle = fleet.lookupVehicle(code);
        if (vehicle == null) {
            System.out.println("No vehicles found with that code.");
        } else {
            fleet.toggleAvailability(vehicle);
            if (vehicle.isAvailable()) {
                System.out.println("The vehicle is now available.");
            } else {
                System.out.println("The vehicle is now not available.");
            }
        }
    }

    public void calculateRentalEstimate(Scanner scan, VehicleCollection fleet) {
        String code = promptString(scan, "Enter the vehicle's code: ");
        Vehicle vehicle = fleet.lookupVehicle(code);
        if (vehicle == null) {
            System.out.println("No vehicles found with that code.");
        } else {
            int rentalDayCount = promptInt(scan, "Enter the number of rental days: ", 1, -1);
            double rentalEstimate = vehicle.calcRentalCost(rentalDayCount);
            System.out.printf("Rental Estimate for %d days: %.2f%n", rentalDayCount, rentalEstimate);
        }
    }

    public void printFleet(VehicleCollection fleet) {
        int vehicleCount = fleet.getTotalVehicleCount();

        if (vehicleCount == 0) {
            System.out.println("The fleet is currently empty.");
            return;
        }

        String border = "+----------+----------------------+------+------------+---------------+------------+";

        System.out.println("Fleet");
        System.out.println(border);

        System.out.printf(
                "| %-8s | %-20s | %-4s | %-10s | %-13s | %-10s |%n", "Code", "Description", "Year", "Daily Rate",
                "Availability", "Mileage");

        System.out.println(border);

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = fleet.getVehicle(i);

            System.out.printf("| %-8.8s | %-20.20s | %4d | $%9.2f | %-13s | %7d mi |%n", vehicle.getCode(),
                    vehicle.getDescription(), vehicle.getYear(), vehicle.getDailyRate(),
                    vehicle.isAvailable() ? "Available" : "Not Available", vehicle.getMileage());
        }

        System.out.println(border);
    }

    public void printUnavailable(VehicleCollection fleet) {
        ArrayList<Vehicle> unavailableVehicles = fleet.getUnavailableVehicles();
        if (unavailableVehicles.isEmpty()) {
            System.out.println("There are no unavailable vehicles.");
        } else {
            VehicleCollection unavailableFleet = new VehicleCollection();
            for (int i = 0; i < unavailableVehicles.size(); i++) {
                unavailableFleet.addVehicle(unavailableVehicles.get(i));
            }
            System.out.print("Unavailable ");
            printFleet(unavailableFleet);
        }
    }

    public void printSummaryStats(VehicleCollection fleet) {
        System.out.printf("Total vehicle count: %d%n", fleet.getTotalVehicleCount());
        int[] countByType = fleet.getTypeCounts();
        System.out.println("Count by Type:");
        System.out.printf("Cars: %d%nTrucks: %d%nMotorcycles: %d%n", countByType[0], countByType[1], countByType[2]);
        System.out.printf("Average daily rate: %.2f%n", fleet.getAverageDailyRate());
        Vehicle highestEstimate = fleet.getHighest3DayEstimate();
        System.out.printf("Highest 3-day rate estimate of available vehicles:%n%s%n",
                highestEstimate == null ? "No available vehicles" : highestEstimate);
    }
}
