public class Circle extends PlaneFigure {
    private double radius;

    public Circle(double rad) {
        setRadius(rad);
    }

    public double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        if (radius <= 0) {
            radius = 1;
        }
        this.radius = radius;
    }

    public double calcDiameter() {
        double diameter = 2 * this.radius;
        return diameter;
    }

    @Override
    public double calcPerimeter() {
        double perimeter = Math.PI * calcDiameter();
        return perimeter;
    }

    @Override
    public double calcArea() {
        double area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }

    @Override
    public String toString() {
        return "Radius: " + this.radius;
    }
}
