public class PlaneFigureDBase {
    private PlaneFigure[] figures;
    private int figureCount;

    public PlaneFigureDBase(int numFigures) {
        if (numFigures <= 0) {
            numFigures = 10;
        }
        this.figures = new PlaneFigure[numFigures];
        this.figureCount = 0;
    }

    public int getNumberOfFigures() {
        return this.figureCount;
    }

    public PlaneFigure addFigure(PlaneFigure figure) {
        if (figure == null) {
            return null;
        }
        if (this.figureCount == figures.length) {
            return null;
        }
        this.figures[this.figureCount] = figure;
        this.figureCount++;
        return figure;
    }

    public PlaneFigure getFigureByPosition(int index) {
        if (index < 0 || index >= figureCount) {
            return null;
        }
        return figures[index];
    }

    public PlaneFigure removeFigureByPosition(int index) {
        if (index < 0 || index >= figureCount) {
            return null;
        }
        PlaneFigure temp = figures[index];
        figures[index] = figures[figureCount - 1];
        figures[figureCount - 1] = null;
        figureCount--;
        return temp;
    }

    public static void main(String args[]) {
        PlaneFigureDBase dbase = new PlaneFigureDBase(3);
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
        }
    }
}
