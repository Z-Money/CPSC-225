public class ExpressPackageZK extends PackageZK {
    public ExpressPackageZK(double weight) {
        super(weight);
    }

    @Override
    public double calcShippingCost() {
        double shipCost = 15.00 + (getWeight() * 2.50);
        return shipCost;
    }
}
