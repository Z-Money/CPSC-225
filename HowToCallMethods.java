public class HowToCallMethods {
    public static void main(String[] args) {
        String str = "Missy";
        char what = 's';
        int count = countChars(str, what);
        System.out.printf("%c occurs in %s %d times.%n", what, str, count);
    }

    public static int countChars(String searchStr, char what) {
        int counter = 0;
        for (int i = 0; i < searchStr.length(); i++) {
            char currChar = searchStr.charAt(i);
            if (currChar == what) {
                counter++;
            }
        }
        return counter;
    }
}
