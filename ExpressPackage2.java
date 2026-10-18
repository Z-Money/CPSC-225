public class ExpressPackage2 extends Package {
    public static final double BASE_PRICE = 15;
    public static final double PRICE_PER_LB = 2.5;

    public ExpressPackage2(String packageID) throws PackageException {
        super(packageID);
    }

    @Override
    public double calcShippingCost() {
        return BASE_PRICE + getWeight() * PRICE_PER_LB;
    }
}