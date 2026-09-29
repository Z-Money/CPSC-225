import java.util.Scanner;

public class ShippingChargeAppZK {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        double totalShipCost = 0;
        System.out.println("S for Standard or E for Express");
        System.out.print("Enter a package type or press enter to exit: ");
        String choice = scan.nextLine();
        while (!choice.isEmpty()) {
            System.out.print("Enter package weight: ");
            String packWeightStr = scan.nextLine();
            double packWeight = Double.parseDouble(packWeightStr);
            PackageZK pack;
            if (choice.equals("S")) {
                pack = new StandardPackageZK(packWeight);
            } else {
                pack = new ExpressPackageZK(packWeight);
            }
            double shipCost = pack.calcShippingCost();
            if (pack instanceof StandardPackageZK) {
                System.out.println("Type: Standard Package");
                System.out.printf("Weight: %.1f\n", pack.getWeight());
                System.out.printf("Shipping Cost: %.2f\n", shipCost);
                totalShipCost += pack.calcShippingCost();
            } else if (pack instanceof ExpressPackageZK) {
                System.out.println("Type: Standard Package");
                System.out.printf("Weight: %.1f\n", pack.getWeight());
                System.out.printf("Shipping Cost: %.2f\n", shipCost);
                totalShipCost += pack.calcShippingCost();
            }
            System.out.println("S for Standard or E for Express");
            System.out.print("Enter a package type or press enter to exit: ");
            choice = scan.nextLine();

        }
        System.out.printf("Total shipping cost: %.2f", totalShipCost);
        scan.close();
    }
}
