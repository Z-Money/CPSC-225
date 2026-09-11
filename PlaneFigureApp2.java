import java.util.Scanner;

public class PlaneFigureApp2 {
    public static void main(String args[]) {
        Scanner inpt = new Scanner(System.in);
        int numRects = 0;
        double totArea = 0;
        double totPerim = 0;
        System.out.print("Enter the length or just press enter: ");
        String lenStr = inpt.nextLine();
        while (!lenStr.isBlank()) {
            double length = Double.parseDouble(lenStr);

            System.out.print("Enter the width: ");
            String widthStr = inpt.nextLine();
            double width = Double.parseDouble(widthStr);

            numRects++;

            Rectangle rect1 = new Rectangle(length, width);
            System.out.println(rect1.toString());
            totPerim += rect1.calcPerimeter();
            System.out.println("Perimeter: " + rect1.calcPerimeter());
            totArea += rect1.calcArea();
            System.out.println("Area: " + rect1.calcArea());

            System.out.print("Enter the length or just press enter: ");
            lenStr = inpt.nextLine();
            // Circle cir = new Circle();
            // cir.setRadius(56);
            // System.out.println(cir);
            // System.out.println("Area: " + cir.calculateArea());
            // System.out.println("Circumference: " + cir.calculateCircumference());
        }

        if (numRects > 0) {
            System.out.println("Total numbers of rectangles: " + numRects);
            System.out.println("Average perimeter: " + (totPerim / numRects));
            System.out.println("Average area: " + (totArea / numRects));
        }

        inpt.close();
    }
}