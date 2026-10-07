import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShippingApp2 {

    public static void main(String[] args) {
        ShippingApp2 app = new ShippingApp2();
        app.run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        PackageDatabase packBase = new PackageDatabase();
        loadDatabaseFromFile(packBase, "packages.csv");
        int choice = 0;
        do {
            choice = menu(scan);
            processChoice(scan, choice, packBase);
        } while (choice != 99);
        savePackageData(packBase, "packages.csv");
        scan.close();
    }

    public void loadDatabaseFromFile(PackageDatabase packBase, String filename) {
        try {
            File infile = new File(filename);
            Scanner input = new Scanner(infile);
            input.nextLine(); // skip the header
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] linePieces = line.split(",");
                String type = linePieces[0];
                if (type.equalsIgnoreCase("S") || type.equalsIgnoreCase("E")) {
                    String packID = linePieces[1];
                    double weight = Double.parseDouble(linePieces[2]);
                    if (weight >= 1 && weight <= 50) {
                        Package pack = null;
                        if (type.equalsIgnoreCase("S")) {
                            pack = new StandardPackage(packID);
                        } else {
                            pack = new ExpressPackage(packID);
                        }
                        pack.setWeight(weight);
                        packBase.addPackage(pack);
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    } // end loadDatabaseFromFile

    public int menu(Scanner scan) {
        String message = """
                1) Display package data
                2) Find package by ID
                3) Remove package by ID
                4) Edit package data
                99) Quit
                """;
        System.out.println(message);
        System.out.print("Choice an option from the menu above: ");
        String choiceStr = scan.nextLine();
        int choice = Integer.parseInt(choiceStr);
        return choice;
    }

    public void processChoice(Scanner scan, int choice, PackageDatabase packBase) {
        switch (choice) {
            case 1 -> displayPackageData(packBase);
            case 2 -> System.out.println("Find");
            case 3 -> removePackage(scan, packBase);
            case 4 -> System.out.println("Edit");
            case 99 -> System.out.println("Bye!");
            default -> System.out.println("Invalid choice.");
        }
    }

    public void savePackageData(PackageDatabase packBase, String filename) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            String output = "Type,TrackingCode,Weight\n";
            for (int i = 0; i < packBase.getNumberOfPackages(); i++) {
                Package pack = packBase.getPackageByPosition(i);
                String type = "";
                if (pack instanceof StandardPackage) {
                    type = "S";
                } else {
                    type = "E";
                }
                output += String.format("%s,%s,%f%n", type, pack.getPackageID(), pack.getWeight());
            }
            pw.println(output);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dumpData(PackageDatabase packBase) {
        if (packBase.getNumberOfPackages() == 0) {
            System.out.println("No package data");
            return;
        }
        for (int i = 0; i < packBase.getNumberOfPackages(); i++) {
            Package pack = packBase.getPackageByPosition(i);
            System.out.println(pack);
            System.out.printf("Shipping cost: %.2f%n", pack.calcShippingCost());
        }
    }

    public void removePackage(Scanner scan, PackageDatabase packBase) {
        System.out.print("Enter package ID: ");
        String id = scan.nextLine();
        Package removedPackage = packBase.removePackageByID(id);
        if (removedPackage == null) {
            System.out.println("Nothing was removed.");
            return;
        }
        System.out.println("The following package was remove: ");
        displayPackage(removedPackage);
    }

    public void displayPackage(Package pack) {
        System.out.println(pack);
        System.out.printf("Shipping cost: %.2f%n", pack.calcShippingCost());
    }

    public void displayPackageData(PackageDatabase packBase) {
        if (packBase.getNumberOfPackages() == 0) {
            System.out.println("No package data.");
            return;
        }
        for (int i = 0; i < packBase.getNumberOfPackages(); i++) {
            Package pack = packBase.getPackageByPosition(i);
            System.out.println(pack);
        }
    }
}
