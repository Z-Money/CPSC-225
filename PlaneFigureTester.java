import java.util.Scanner;

public class PlaneFigureTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Circle2 circ;
        while (true) {
            System.out.print("Enter the radius: ");
            double rad = Double.parseDouble(scan.nextLine());
            try {
                circ = new Circle2(rad);
                break;
            } catch (CircleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Please try again.");
            }
        }
        System.out.println(circ.calcDiameter());
        scan.close();
    }
}
