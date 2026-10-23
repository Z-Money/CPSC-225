
public class RecursionQuizSection1 {

    public static void main(String[] args) {
        int count = countChar("BANANA", 'A');
        System.out.println(count);
    }// end main

    public static int countChar(String str, char ch) {
        if (str.isEmpty()) {
            return 0;
        }

        int index = str.indexOf(ch);

        if (index == -1) {
            return 0;
        }
        System.out.println(str.substring(index + 1));
        return 1 + countChar(str.substring(0, index), ch)
                + countChar(str.substring(index + 1), ch);
    }

}
