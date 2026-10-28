public class MethodCallExample {
    public static void main(String[] args) {
        MethodCallExample app = new MethodCallExample();
        app.run();
    }

    public void run() {
        Rectangle rect = null;
        double len = 5;
        double wid = 10;
        rect = new Rectangle(len, wid);
        createRectangle(rect);
        System.out.println("In main");
        System.out.printf("Length: %.1f Width: %.1f%n", len, wid);
    }

    public void createRectangle(Rectangle r) {
        System.out.println("Inside create");
        System.out.println(r);
    }
}
