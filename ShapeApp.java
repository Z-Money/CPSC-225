import java.util.Scanner;

public class ShapeApp {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== Cone ===");
        System.out.print("Enter the cone radius: ");
        double coneRadius = Double.parseDouble(scan.nextLine());
        System.out.print("Enter the cone height: ");
        double coneHeight = Double.parseDouble(scan.nextLine());

        System.out.println("=== Sphere ===");
        System.out.print("Enter the sphere radius: ");
        double sphereRadius = Double.parseDouble(scan.nextLine());

        System.out.println("=== Cylinder ===");
        System.out.print("Enter the cylinder radius: ");
        double cylinderRadius = Double.parseDouble(scan.nextLine());
        System.out.print("Enter the cylinder height: ");
        double cylinderHeight = Double.parseDouble(scan.nextLine());

        System.out.println("\n=== Shape Results ===");

        Shape shape = new Cone(coneRadius, coneHeight);
        System.out.println("\n" + shape);
        System.out.printf("Volume: %.2f\n", shape.calcVolume());
        System.out.printf("Surface Area: %.2f\n", shape.calcSurfaceArea());

        if (shape instanceof Cone) {
            System.out.println("This is a cone.");
        }

        shape = new SphereTwo(sphereRadius);
        System.out.println("\n" + shape);
        System.out.printf("volume: %.2f\n", shape.calcVolume());
        System.out.printf("Surface Area: %.2f\n", shape.calcSurfaceArea());

        if (shape instanceof SphereTwo) {
            System.out.println("This is a sphere.");
        }

        shape = new Cylinder(cylinderRadius, cylinderHeight);
        System.out.println("\n" + shape);
        System.out.printf("Volume: %.2f\n", shape.calcVolume());
        System.out.printf("Surface Area: %.2f\n", shape.calcSurfaceArea());

        if (shape instanceof Cylinder) {
            System.out.println("This is a cylinder.");
        }

        scan.close();
    }
}