public final class SphereTwo extends Shape {
    private double radius;

    public SphereTwo(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            radius = 1;
        }
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
        return volume;
    }

    @Override
    public double calcSurfaceArea() {
        double surfaceArea = 4.0 * Math.PI * Math.pow(this.radius, 2);
        return surfaceArea;
    }

    @Override
    public String toString() {
        return String.format("Sphere - Radius: %.2f", this.radius);
    }
}
