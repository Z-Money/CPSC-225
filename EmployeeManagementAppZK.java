
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 03
 * Date: 9/23/2026
 * Helpers: N/A
 */

import java.util.Scanner;

public class EmployeeManagementAppZK {
    public static void main(String args[]) {
        EmployeeManagementAppZK app = new EmployeeManagementAppZK();
        app.runApp();
    }

    public void runApp() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Employee ID: ");
            String idStr = scan.nextLine();
            if (idStr.isEmpty()) {
                System.out.println("Program exited.");
                break;
            }
            int id = Integer.parseInt(idStr);
            EmployeeZK employee = createEmployee(scan, id);
            displayEmployeeData(employee);
        }
        scan.close();
    }

    public EmployeeZK createEmployee(Scanner scan, int id) {
        String empType = "";
        while (!empType.equals("1") && !empType.equals("2")) {
            System.out.println("1. Hourly Employee");
            System.out.println("2. Salaried Employee");
            System.out.print("Enter option here (#): ");
            empType = scan.nextLine();
            if (!empType.equals("1") && !empType.equals("2")) {
                System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.print("First Name: ");
        String firstName = scan.nextLine();

        System.out.print("Last Name: ");
        String lastName = scan.nextLine();

        EmployeeZK emp;

        if (empType.equals("1")) {
            System.out.print("Number of Hours Worked: ");
            String numOfHoursStr = scan.nextLine();
            int numOfHours = Integer.parseInt(numOfHoursStr);

            System.out.print("Pay Rate: ");
            String payRateStr = scan.nextLine();
            double payRate = Double.parseDouble(payRateStr);

            emp = new HourlyEmpZK(id, firstName, lastName);
            ((HourlyEmpZK) emp).setPayRate(payRate);
            ((HourlyEmpZK) emp).setHoursWorked(numOfHours);
        } else {
            System.out.print("Salary: ");
            String salaryStr = scan.nextLine();
            double salary = Double.parseDouble(salaryStr);
            emp = new SalariedEmpZK(id, firstName, lastName);
            ((SalariedEmpZK) emp).setAnnualSalary(salary);
        }

        return emp;
    }

    public void displayEmployeeData(EmployeeZK employee) {
        System.out.println("\n" + employee.toString());
        if (employee instanceof HourlyEmpZK hourlyEmp) {
            System.out.println("Type: Hourly");
            System.out.println("Pay Rate: " + hourlyEmp.getPayRate());
            System.out.println("Hours Worked: " + hourlyEmp.getHoursWorked());
            hourlyEmp.calcPay();
            System.out.printf("Weekly Pay: %.2f\n", hourlyEmpZK.getPay());
        } else if (employee instanceof SalariedEmpZK salaryEmp) {
            System.out.println("Type: Salaried");
            System.out.println("Salary: " + salaryEmp.getAnnualSalary());
            salaryEmp.calcPay();
            System.out.printf("Weekly Pay: %.2f\n", salaryEmp.getPay());
        } else {
            System.out.println("Employee type is invalid.");
        }
    }
}