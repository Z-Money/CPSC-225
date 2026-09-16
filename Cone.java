public class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        setRadius(radius);
        setHeight(height);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double calcVolume() {
        double volume = (1.0 / 3) * Math.PI * Math.pow(this.radius, 2) * this.height;
        return volume;
    }

    @Override
    public double calcSurfaceArea() {
        return 0;
    }
}