/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 01
 * Date: 9/6/2026
 * Helpers: N/A
 */

public class BookZK {
    private String isbn;
    private String title;
    private String author;
    private int quantity;
    private double unitPrice;

    public BookZK(String isbn, String title, String author) {
        if (isbn == null || isbn.isEmpty()) {
            isbn = "*";
        }
        if (title == null || title.isEmpty()) {
            title = "*";
        }
        if (author == null || author.isEmpty()) {
            author = "*";
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
        if (price < 0) {
            /*
             * I talked to Caleb about using the IllegalArgumentException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. I choose an IllegalArgumentException
             * here because its price argument that is the source of the error, with it
             * providing an invalid value. The price of a book cannot be negative, so I
             * raised an error that can be handled by the eventual program that uses this
             * class, being BookAppZK.java in this specific case.
             */
            throw new IllegalArgumentException("Price must be positive");
        }
        unitPrice = price;
    }

    public void addQuantity(int num) {
        if (num <= 0) {
            /*
             * I talked to Caleb about using the IllegalArgumentException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. I choose an IllegalArgumentException
             * here because its the num argument that is the source of the error, with it
             * providing an invalid value. The directions state that the quantity added must
             * be positive, so any negative values are invalid, so I raised an error that
             * can be handled by the eventual program that uses this class, being
             * BookAppZK.java in this specific case.
             */
            throw new IllegalArgumentException("Additions must be positive");
        }
        quantity += num;
    }

    public void deductQuantity(int num) {
        if (num <= 0) {
            /*
             * I talked to Caleb about using the IllegalArgumentException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. I choose an IllegalArgumentException
             * here because its the num argument that is the source of the error, with it
             * providing an invalid value. The directions state that the quantity deducted
             * must be positive, so any negative values are invalid, so I raised an error
             * that can be handled by the eventual program that uses this class, being
             * BookAppZK.java in this specific case.
             */
            throw new IllegalArgumentException("Deductions must be positive");
        }
        if ((quantity - num) < 0) {
            /*
             * I talked to Caleb about using the IllegalArgumentException and he said I'm
             * okay and to just explain it here. I learned them from a previous Java course
             * I did and I understand how they work. I choose an IllegalArgumentException
             * here because its the num argument that is the source of the error, with it
             * providing an invalid value. The directions state that you cannot deduct more
             * books than you have, so I raised an error if that were to occur the eventual
             * program that uses this class can handle it, being BookAppZK.java in this
             * specific case.
             */
            throw new IllegalArgumentException("You cannot deduct more than you have in quantity.");
        }
        quantity -= num;
    }

    public double calculateCost() {
        double cost = unitPrice * quantity;
        return cost;
    }

    public String toString() {
        String output = ("ISBN: " + getIsbn() + "; Title: " + getTitle() + "; Author: " + getAuthor());
        return output;
    }
}
