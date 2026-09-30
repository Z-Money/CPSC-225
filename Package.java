public abstract class Package {
    private String packageID;
    private double weight;

    public Package(String packageID) {
        setPackageID(packageID);
        this.weight = 0;
    }

    public void setPackageID(String packageID) {
        if (packageID == null || packageID.length() != 5) {
            packageID = "*****";
        }
        this.packageID = packageID;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            weight = 0;
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