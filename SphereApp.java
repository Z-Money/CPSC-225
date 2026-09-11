import java.util.Scanner;

public class SphereApp {
    public static void main(String args[]) {
        Scanner inpt = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        String radStr = inpt.nextLine();
        double radius = Double.parseDouble(radStr);
        
        Sphere s = new Sphere(radius);
        System.out.println(s.toString());
        System.out.println("Volume: " + s.calculateVolume());
        System.out.println("Surface Area: " + s.calculateSurfaceArea());

        inpt.close();
    }
}