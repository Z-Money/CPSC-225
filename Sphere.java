public class Sphere {
    private double radius;

    public Sphere(double rad) {
        setRadius(rad);
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double rad) {
        this.radius = rad;
    }

    public double calculateVolume() {
        double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
        return volume;
    }

    public double calculateSurfaceArea() {
        double area = 4.0 * Math.PI * Math.pow(radius, 2);
        return area;
    }

    public String toString() {
        return ("Radius: " + radius);
    }
}
