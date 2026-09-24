/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 03
 * Date: 9/23/2026
 * Helpers: N/A
 */

public class SalariedEmpZK extends EmployeeZK {
    private double annualSalary;

    public SalariedEmpZK(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public double getAnnualSalary() {
        return this.annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        if (annualSalary < 0) {
            annualSalary = 0;
        }
        this.annualSalary = annualSalary;
    }

    @Override
    public void calcPay() {
        double weeklyPay = this.annualSalary / 52;
        setPay(weeklyPay);
    }
}