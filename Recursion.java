public class Recursion {
    // Class is being used to learn the topic of recursion
    // A recursive method calls itself
    // I am ONLY using static methods here because I am LAZY

    public static void main(String args[]) {
        int n = 5;
        System.out.printf("%d! = %d%n", n, recursiveFact(n));
    }

    public static int recursiveFact(int n) {
        if (n <= 1) { // Base case or get-out clause
            return 1;
        }
        return n * recursiveFact(n - 1);
    }
}
