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
        String choice = "";
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("1. Hourly Employee");
            System.out.println("2. Salaried Employee");
            System.out.print("Enter option here (#): ");
            choice = scan.nextLine();
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.print("First Name: ");
        String firstName = scan.nextLine();

        System.out.print("Last Name: ");
        String lastName = scan.nextLine();

        EmployeeZK emp;

        if (choice.equals("1")) {
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
        System.out.println(employee);
        if (employee instanceof HourlyEmpZK hourlyEmpZK) {
            System.out.println("Type: Hourly");
            System.out.println("Pay Rate: " + hourlyEmpZK.getPayRate());
            System.out.println("Hours Worked: " + hourlyEmpZK.getHoursWorked());
            hourlyEmpZK.calcPay();
            System.out.println("Weekly Pay: " + hourlyEmpZK.getPay());
        } else {
            System.out.println("Type: Salaried");
            System.out.println("Salary: " + ((SalariedEmpZK) employee).getAnnualSalary());
            employee.calcPay();
            System.out.printf("Weekly Pay: %.2f\n", employee.getPay());
        }
    }
}