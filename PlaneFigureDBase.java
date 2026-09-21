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

}
