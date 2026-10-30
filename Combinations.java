import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the value for n >= 0: ");
        int n = Integer.parseInt(scan.nextLine());
        System.out.printf("Enter the value for r <= %d: ", n);
        int r = Integer.parseInt(scan.nextLine());
        int cnr = c(n, r);
        System.out.printf("%d choose %d = %d%n", n, r, cnr);
        scan.close();
    }

    public int c(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return c(n - 1, r - 1) + c(n - 1, r);
    }
}
