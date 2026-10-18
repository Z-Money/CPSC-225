public abstract class Package2 {
    private String packageID;
    private double weight;

    public Package2(String packageID) throws PackageException {
        setPackageID(packageID);
        this.weight = 0;
    }

    public void setPackageID(String packageID) throws PackageException {
        if (packageID == null || packageID.length() != 5) {
            throw new PackageException("Invalid ID.");
        }
        this.packageID = packageID;
    }

    public void setWeight(double weight) throws PackageException {
        if (weight < 1 || weight > 50) {
            throw new PackageException("Invalid weight.");
        }
        this.weight = weight;
    }

    public String getPackageID() {
        return this.packageID;
    }

    public double getWeight() {
        return this.weight;
    }

    public abstract double calcShippingCost();

    public String toString() {
        return String.format("ID: %s Weight (lbs): %.1f", this.packageID, this.weight);
    }
}