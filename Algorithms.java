public class Algorithms {
    public static void main(String[] args) {
        Algorithms app = new Algorithms();
        app.run();
    }

    public void run() {
        String[] strings = { "A109", "A007", "A234", "A001", "A101", "A200" };

        String target = "A101";
        int pos = linearSearchStrings(strings, target, strings.length);
        if (pos != -1) {
            System.out.printf("%s was found at position %d.%n", target, pos);
        } else {
            System.out.printf("%s was not found.%n", target);
        }

        bubbleSort(strings, strings.length);
        displayStrings(strings, strings.length);
    }

    public int linearSearchStrings(String[] strings, String target, int length) {
        for (int i = 0; i < length; i++) {
            if (strings[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public void displayStrings(String[] strings, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(strings[i]);
        }
    }

    public void bubbleSort(String[] strings, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }
    }
}
