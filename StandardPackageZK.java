public class StandardPackageZK extends PackageZK {
    public StandardPackageZK(double weight) {
        super(weight);
    }

    @Override
    public double calcShippingCost() {
        double shipCost = 8.00 + (getWeight() * 1.50);
        return shipCost;
    }
}
