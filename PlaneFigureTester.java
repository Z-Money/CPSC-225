import java.util.Scanner;

public class PlaneFigureTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PlaneFigureTester pft = new PlaneFigureTester();
        Circle2 circ = pft.getCircle(scan);
        System.out.printf("Area: %.1f%n", circ.calcArea());
        scan.close();
    }

    public Circle2 getCircle(Scanner scan) {
        Circle2 circ = null;
        while (true) {
            System.out.print("Enter the radius: ");
            double radius = Double.parseDouble(scan.nextLine());
            try {
                circ = new Circle2(radius);
            } catch (CircleException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }
            if (circ != null) {
                break;
            }
        }
        return circ;
    }
}