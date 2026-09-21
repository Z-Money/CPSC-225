public final class Cylinder extends Shape {
    private double radius, height;

    public Cylinder(double radius, double height) {
        setRadius(radius);
        setHeight(height);
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            radius = 1;
        }
        this.radius = radius;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            height = 1;
        }
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
        double volume = Math.PI * Math.pow(this.radius, 2) * this.height;
        return volume;
    }

    @Override
    public double calcSurfaceArea() {
        double surfaceArea = 2.0 * Math.PI * this.radius * this.height;
        return surfaceArea;
    }

    @Override
    public String toString() {
        return String.format("Cylinder - Radius: %.2f, Height: %.2f", this.radius, this.height);
    }
}