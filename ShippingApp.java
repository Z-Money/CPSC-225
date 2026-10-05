import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShippingApp {

    public static void main(String[] args) {
        ShippingApp app = new ShippingApp();
        app.run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        PackageDatabase packBase = new PackageDatabase();
        loadDatabaseFromFile(packBase, "packages.csv");
        dumpData(packBase);
        scan.close();
    }

    public void loadDatabaseFromFile(PackageDatabase packBase, String filename) {
        try {
            File infile = new File(filename);
            Scanner input = new Scanner(infile);
            input.nextLine(); //skip the header
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
    } //end loadDatabaseFromFile

    public void dumpData(PackageDatabase packBase) {
        if (packBase.getNumberOfPackages() == 0) {
            System.out.println("No package data");
            return;
        }
        for (int i = 0; i < packBase.getNumberOfPackages(); i++) {
            Package pack = packBase.getPackageByPosition(i);
            System.out.println(pack);
            System.out.printf("Package weight: %.1f%n", pack.getWeight());
        }
    }
}
