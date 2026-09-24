/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 03
 * Date: 9/23/2026
 * Helpers: N/A
 */

public abstract class EmployeeZK {
    private int id;
    private String firstName, lastName;
    private double pay;

    public EmployeeZK(int id, String firstName, String lastName) {
        if (id < 1000 || id > 9999) {
            id = -1;
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public double getPay() {
        return this.pay;
    }

    public void setPay(double pay) {
        if (pay < 0) {
            pay = 0;
        }
        this.pay = pay;
    }

    public abstract void calcPay();

    @Override
    public String toString() {
        return "ID: " + this.id + "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName;
    }
}