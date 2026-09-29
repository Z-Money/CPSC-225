abstract public class PackageZK {
    private double weight;

    public PackageZK(double weight) {
        setWeight(weight);
    }

    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            weight = 0;
        }
        this.weight = weight;
    }

    abstract public double calcShippingCost();

    @Override
    public String toString() {
        return "Weight: " + getWeight();
    }
}
