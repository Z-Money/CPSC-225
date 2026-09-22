public class HourlyEmpZK extends EmployeeZK {
    private double hoursWorked, payRate;

    public HourlyEmpZK(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public double getHoursWorked() {
        return this.hoursWorked;
    }

    public double getPayRate() {
        return this.payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            hoursWorked = 0;
        }
        this.hoursWorked = hoursWorked;
    }

    public void setPayRate(double payRate) {
        if (payRate < 0) {
            payRate = 0;
        }
        this.payRate = payRate;
    }

    @Override
    public void calcPay() {
        if (this.hoursWorked <= 40) {
            setPay(this.hoursWorked * this.payRate);
        } else if (this.hoursWorked > 40) {
            setPay((40 * this.payRate) + ((this.hoursWorked - 40) * (this.payRate * 1.5)));
        }
    }

}