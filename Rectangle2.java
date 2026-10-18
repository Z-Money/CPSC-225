public class Rectangle2 extends PlaneFigure {
    private double length;
    private double width;

    public Rectangle2(double length, double width) throws RectangleException {
        setLength(length);
        setWidth(width);
    }

    private void setLength(double length) throws RectangleException {
        if (length <= 0) {
            throw new RectangleException("Invalid length.");
        }
        this.length = length;
    }

    private void setWidth(double width) throws RectangleException {
        if (width <= 0) {
            throw new RectangleException("Invalid width.");
        }
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    public double calcArea() {
        double area = this.length * this.width;
        return area;
    }

    @Override
    public double calcPerimeter() {
        double perimeter = (this.length + this.width) * 2;
        return perimeter;
    }

    @Override
    public String toString() {
        String combinedLine = "Length: " + getLength() + "\nWidth: " + getWidth();
        return combinedLine;
    }
}
