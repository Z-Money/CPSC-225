public class Student {
    private int stuID;
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(int id, String first, String last) {
        if (id < 1000 || id > 9999) {
            id = -1;
        }
        if (first == null || first.isBlank()) {
            first = "Unknown";
        }
        if (last == null || last.isBlank()) {
            last = "Unknown";
        }
        this.stuID = id;
        this.firstName = first;
        this.lastName = last;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.0) {
            return;
        }
        this.gpa = gpa;
    }

    public int getStuID() {
        return stuID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return "ID: " + getStuID() + " Name: " + getFullName();
    }

    // Test main
    public static void main(String args[]) {
        Student stu = new Student(1234, "Bugs", "Bunny");
        stu.setGpa(3.72);
        System.out.println(stu);
        System.out.println("GPA: " + stu.getGpa());
    }
}