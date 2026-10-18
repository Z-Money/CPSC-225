public class StandardPackage2 extends Package {
    public static final double BASE_PRICE = 8;
    public static final double PRICE_PER_LB = 1.5;

    public StandardPackage2(String packageID) throws PackageException {
        super(packageID);
    }

    @Override
    public double calcShippingCost() {
        return BASE_PRICE + getWeight() * PRICE_PER_LB;
    }
}