public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        setLength(5);
        setWidth(10);
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be negative.");
        }
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double calcArea() {
        double area = this.length * this.width;
        return area;
    }

    public double calcPerimeter() {
        double perimeter = (this.length + this.width) * 2;
        return perimeter;
    }

    public String toString() {
        String combinedLine = "Length: " + getLength() + "\nWidth: " + getWidth();
        return combinedLine;
    }
}
