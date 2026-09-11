// Zachariah Kersey

public class Lab01_Kersey {
    public static void main(String[] args) {
        // PR1
        int numOne = 1;
        int numTwo = 2;
        int numThree = 3;
        int numFour = 4;

        // PR2
        String strOne = "String 1";
        String strTwo = "String 2";
        String strThree = "String 3";
        String strFour = "String 4";

        // PR3
        boolean boolOne = true;
        boolean boolTwo = false;

        // PR4
        boolean boolThree = numOne <= 0;
        boolean boolFour = ((numTwo % 2) == 0);

        // PR5
        double dblOne = 1.99;
        double dblTwo = 23.4;

        // PR6
        System.out.println("The larger value is: " + Math.max(dblOne, dblTwo));

        // PR7
        for (int i = 10; i <= 100; i += 10) {
            System.out.println(i);
        }

        // PR8
        int top = 10;
        while (top <= 100) {
            System.out.println(top);
            top += 10;
        }

        // PR9
        int numFive = 5;
        int numSix = 6;
        System.out.println("Addition: " + (numFive + numSix));
        System.out.println("Multiplication: " + (numFive * numSix));
        System.out.println("Modulus: " + (numFive % numSix));

        // PR10
        int total = 0;
        for (int i = 1; i <= 10; i += 2) {
            total += i;
        }
        System.out.println("Sum of the odd integers from 1-10 is: " + total);

        // PR11
        int whileInc = 10;
        do {
            System.out.println(whileInc);
            whileInc--;
        } while (whileInc > 0);

        // FR1
        int limit = 10;
        for (int i = 0; i <= limit; i++) {
            System.out.println(i);
        }

        // FR2
        int multiplier = 4;
        while (multiplier < 100) {
            System.out.println(multiplier);
            multiplier *= 2;
        }

        // FR3
        int tot = 0;
        for (int i = 1; i < 6; i++) {
            tot += i;
        }
        System.out.println("Sum of 5 integer values: " + tot);

        // FR4
        if (tot <= 0) {
            System.out.println("Value is less than or equal to 0");
        }
        if ((tot > 50) && (tot < 100)) {
            System.out.println("Value is between 50 and 100");
        }
        if (tot >= 100) {
            System.out.println("Value is greater than or equal to 100");
        }
        if ((tot % 2) == 0) {
            System.out.println("Value is even");
        }
        if ((tot % 2) != 0) {
            System.out.println("Value is odd");
        }

        // FR5
        int N = 15;
        int nSum = 0;
        for (int i = 1; i <= N; i++) {
            nSum += i;
        }
        System.out.println("Sum from 1 to " + N + ": " + nSum);

        // FR6
        int multiple = 9;
        for (int i = 1; i <= 10; i++) {
            System.out.println(multiple + " x " + i + " = " + (multiple * i));
        }

        // FR7
        String predefStr = "I think bananas are yellow";
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ") " + predefStr);
        }
    }
}