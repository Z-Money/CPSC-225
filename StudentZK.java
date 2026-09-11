/*
Name: Zachariah Kersey
Course: CPSC 225
Homework Number: 02
Date: 9/10/26
Helpers: N/A
*/
public class StudentZK {

    private int studentID;
    private String firstName;
    private String lastName;
    private double exam1;
    private double exam2;

    public StudentZK(int studentID, String firstName, String lastName) {
        // studentID Validation
        if (studentID < 1000 || studentID > 9999) {
            studentID = -1;
        }
        // firstName Validation
        if (firstName == null || firstName.isEmpty()) {
            firstName = "Unknown";
        }
        // lastName Validation
        if (lastName == null || lastName.isEmpty()) {
            lastName = "Unknown";
        }
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.exam1 = 0;
        this.exam2 = 0;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getExam1() {
        return exam1;
    }

    public double getExam2() {
        return exam2;
    }

    public void setExam1(double examScore) {
        if (examScore < 0 || examScore > 100) {
            examScore = -1;
        }
        this.exam1 = examScore;
    }

    public void setExam2(double examScore) {
        if (examScore < 0 || examScore > 100) {
            examScore = -1;
        }
        this.exam2 = examScore;
    }

    public double calcExamAverage() {
        double examAvg = (exam1 + exam2) / 2;
        return examAvg;
    }

    public char determineLetterGrade() {
        double examAvg = calcExamAverage();
        if (examAvg >= 90) {
            return 'A';
        } else if (examAvg >= 80) {
            return 'B';
        } else if (examAvg >= 70) {
            return 'C';
        } else if (examAvg >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public String toString() {
        String compiled = ("Student ID: " + getStudentID() + "; Full Name: " + getLastName() + ", " + getFirstName());
        return compiled;
    }
}
