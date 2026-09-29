import java.util.ArrayList;

public class PlaneFigureDBase2 {
    // Implementation using ArrayList
    private ArrayList<PlaneFigure> figures;

    public PlaneFigureDBase2() {
        this.figures = new ArrayList<>();
    }

    public int getNumberOfFigures() {
        return this.figures.size();
    }

    public PlaneFigure addFigure(PlaneFigure figure) {
        if (figure == null) {
            return null;
        }
        figures.add(figure);
        return figure;
    }

    public PlaneFigure getFigureByPosition(int index) {
        if (index < 0 || index >= figures.size()) {
            return null;
        }
        return figures.get(index);
    }

    public PlaneFigure removeFigureByPosition(int index) {
        if (index < 0 || index >= figures.size()) {
            return null;
        }
        PlaneFigure temp = figures.remove(index);
        return temp;
    }

    public static void main(String args[]) {
        PlaneFigureDBase2 dbase = new PlaneFigureDBase2();
        dbase.addFigure(new Circle(10));
        dbase.addFigure(new Circle(100));
        dbase.addFigure(new Rectangle(10, 5));

        System.out.println("Current Number of figures: " + dbase.getNumberOfFigures());
        for (int i = 0; i < dbase.getNumberOfFigures(); i++) {
            PlaneFigure pf = dbase.getFigureByPosition(i);
            System.out.println(pf);
        }

        PlaneFigure pf = dbase.getFigureByPosition(2);
        if (pf instanceof Circle) {
            Circle circ = (Circle) pf;
            System.out.println("Removed Figure: " + circ);
            System.out.println("Diameter: " + circ.calcDiameter());
        } else if (pf instanceof Rectangle) {
            Rectangle rect = (Rectangle) pf;
            System.out.println("Removed Figure: " + rect);
            System.out.println("Length: " + rect.getLength());
        } else {
            System.out.println("No such figure.");
            return;
        }

        System.out.printf("Perimeter: %.2f\n", pf.calcPerimeter());
        System.out.printf("Area: %.2f\n", pf.calcArea());
    }
}
