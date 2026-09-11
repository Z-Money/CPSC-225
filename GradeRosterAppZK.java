/*
Name: Zachariah Kersey
Course: CPSC 225
Homework Number: 02
Date: 9/10/26
Helpers: N/A
*/

import java.util.ArrayList;
import java.util.Scanner;

public class GradeRosterAppZK {
    public static void main(String args[]) {
        Scanner inpt = new Scanner(System.in);
        ArrayList<StudentZK> students = new ArrayList<>();
        int[] gradeTotals = new int[5];

        String passStr;
        int studentID;
        String firstName;
        String lastName;
        double exam1;
        double exam2;

        while (true) {
            System.out.print("Student ID: ");
            passStr = inpt.nextLine();
            if (passStr.isEmpty()) {
                break;
            }
            studentID = Integer.parseInt(passStr);
            System.out.print("First Name: ");
            firstName = inpt.nextLine();
            System.out.print("Last Name: ");
            lastName = inpt.nextLine();
            System.out.print("Exam 1 Score: ");
            passStr = inpt.nextLine();
            exam1 = Double.parseDouble(passStr);
            System.out.print("Exam 2 Score: ");
            passStr = inpt.nextLine();
            exam2 = Double.parseDouble(passStr);

            StudentZK student = new StudentZK(studentID, firstName, lastName);
            student.setExam1(exam1);
            student.setExam2(exam2);
            students.add(student);
        }

        if (students.isEmpty()) {
            System.out.println("No students were entered.");
            System.out.println("Number of A's: 0");
            System.out.println("Number of B's: 0");
            System.out.println("Number of C's: 0");
            System.out.println("Number of D's: 0");
            System.out.println("Number of F's: 0");
        } else {
            for (StudentZK s : students) {
                System.out.println("\n" + s.toString());
                System.out.println("Exam 1 Score: " + s.getExam1());
                System.out.println("Exam 2 Score: " + s.getExam2());
                System.out.printf("Average Exam Score: %.1f", s.calcExamAverage());
                System.out.println("\nLetter Grade: " + s.determineLetterGrade());
                switch (s.determineLetterGrade()) {
                    case 'A':
                        gradeTotals[0]++;
                        break;
                    case 'B':
                        gradeTotals[1]++;
                        break;
                    case 'C':
                        gradeTotals[2]++;
                        break;
                    case 'D':
                        gradeTotals[3]++;
                        break;
                    case 'F':
                        gradeTotals[4]++;
                        break;
                }
            }
            System.out.println("\nGrade Totals:");
            System.out.println("Number of A's: " + gradeTotals[0]);
            System.out.println("Number of B's: " + gradeTotals[1]);
            System.out.println("Number of C's: " + gradeTotals[2]);
            System.out.println("Number of D's: " + gradeTotals[3]);
            System.out.println("Number of F's: " + gradeTotals[4]);
        }

        inpt.close();
    }
}