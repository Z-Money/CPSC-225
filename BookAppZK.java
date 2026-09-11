
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 01
 * Date: 9/6/2026
 * Helpers: N/A
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BookAppZK {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        /*
         * I used an ArrayList here. We haven't discussed them in class yet, but I've
         * used them in previous classes. It seemed like the best option for this
         * program to keep track of the various BookZK objects in order to print the
         * relevant information at the end of the program.
         */
        ArrayList<BookZK> books = new ArrayList<>();
        String isbn;
        System.out.print("ISBN: ");
        isbn =  input.nextLine();
        while (!isbn.isEmpty()) {
            String title;
            String author;
            String numInput;
            int quantity;
            double unitPrice;

            System.out.print("Title: ");
            title = input.nextLine();
            System.out.print("Author: ");
            author = input.nextLine();
            System.out.print("Quantity: ");
            numInput = input.nextLine();
            /*
             * I talked to Caleb about using the NumberFormatException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. Since Integer.parseInt throws a
             * NumberFormatException upon error, I used it and provided a relevant error
             * message.
             */
            try {
                quantity = Integer.parseInt(numInput);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Input must be a valid integer");
            }
            System.out.print("Unit Price: ");
            numInput = input.nextLine();
            /*
             * I talked to Caleb about using the NumberFormatException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. Since Double.parseDouble throws a
             * NumberFormatException upon error, I used it and provided a relevant error
             * message.
             */
            try {
                unitPrice = Double.parseDouble(numInput);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Input must be a valid double");
            }
            BookZK book = new BookZK(isbn, title, author);
            book.addQuantity(quantity);
            book.setUnitPrice(unitPrice);
            books.add(book);

            System.out.print("ISBN: ");
            isbn = input.nextLine();
        }
        double totalCost = 0.0;
        double avgCost = 0.0;
        if (books.isEmpty()) {
            System.out.println("No books were entered.");
            System.out.println("Total Price: $0.00");
            System.out.println("Average Price: $0.00");
        } else {
            for (BookZK b : books) {
                System.out.println("\n" + b.toString());
                System.out.println("Quantity: " + b.getQuantity());
                System.out.printf("Cost: $%.2f", b.calculateCost());
                totalCost += b.calculateCost();
            }
            System.out.printf("\nTotal Price: $%.2f", totalCost);
            avgCost = totalCost / books.size();
            System.out.printf("\nAverage Price: $%.2f", avgCost);
        }
        input.close();
    }
}
