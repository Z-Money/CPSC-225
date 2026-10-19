import java.util.Scanner;

public class Recursion {
    // Class is being used to learn the topic of recursion
    // A recursive method calls itself
    // I am ONLY using static methods here because I am LAZY

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = 5;
        System.out.printf("%d! = %d%n", n, recursiveFact(n));
        System.out.printf("2^%d = %d%n", n, powOf2(n));

        System.out.print("Enter a string or just press enter: ");
        String str = scan.nextLine();
        // String changedStr = removeVowels(str);
        String changedStr = reverseString(str);
        System.out.printf("%s becomes %s%n", str, changedStr);

        scan.close();
    }

    public static int recursiveFact(int n) {
        if (n <= 1) { // Base case or get-out clause
            return 1;
        }
        return n * recursiveFact(n - 1);
    }

    public static String removeVowels(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if ("aeiou".indexOf(str.charAt(0)) == -1) { // Not a vowel
            return str.charAt(0) + removeVowels(str.substring(1));
        } else {
            return removeVowels(str.substring(1));
        }
    }

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return "";
        }
        // return reverseString(str.substring(1)) + str.charAt(0); // Simpler solution
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static int powOf2(int n) {
        if (n == 0) {
            return 1;
        }
        return 2 * powOf2(n - 1);
    }
}
