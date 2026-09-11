import java.util.Scanner;

public class PlaneFigureApp {
    public static void main(String args[]) {
        Scanner inpt = new Scanner(System.in);
        System.out.print("Enter the length: ");
        String lenStr = inpt.nextLine();
        double length = Double.parseDouble(lenStr);

        System.out.print("Enter the width: ");
        String widthStr = inpt.nextLine();
        double width = Double.parseDouble(widthStr);

        Rectangle rect1 = new Rectangle(length, width);
        System.out.println(rect1.toString());
        System.out.println("Area: " + rect1.calcArea());
        System.out.println("Perimeter: " + rect1.calcPerimeter());
        inpt.close();
    }
}