
/**
 * Name: Zachariah Kersey
 * Course: CPSC 225
 * Homework Number: 04
 * Date: 10/2/2026
 * Helpers: N/A
 */

import java.util.Scanner;

public class ProductStoreAppZK {
    public static void main(String args[]) {
        ProductStoreAppZK productStore = new ProductStoreAppZK();
        productStore.runApp();
    }

    private void runApp() {
        Scanner scan = new Scanner(System.in);
        Product[] products = new Product[10];
        while (true) {
            displayMenu();
            int choice = getUserChoice(scan);
            if (choice == 8) {
                break;
            }
            handleChoice(products, scan, choice);
        }
        scan.close();
    }

    private Product promptProduct(Product[] products, Scanner scan, String prompt) {
        if (getNumProducts(products) == 0) {
            System.out.println("There are currently no products. Add a product before proceeding.");
            return null;
        }
        for (int i = 0; i < getNumProducts(products); i++) {
            System.out.println((i + 1) + ". " + products[i].toString());
        }
        int index = promptInt(scan, prompt, 1, getNumProducts(products));
        return products[index - 1];
    }

    private int getNumProducts(Product[] products) {
        int numOfProducts = 0;
        for (Product p : products) {
            if (p == null) {
                return numOfProducts;
            }
            numOfProducts++;
        }
        return numOfProducts;
    }

    private String promptString(Scanner scan, String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        return input;
    }

    private int promptInt(Scanner scan, String prompt, int min, int max) {
        int input = 0;
        while (true) {
            System.out.print(prompt);
            String inputStr = scan.nextLine();
            try {
                input = Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input a valid integer value.");
                continue;
            }
            if (input < min && min != -1) {
                System.out.println("The input is too small. Please input a valid value.");
                continue;
            } else if (input > max && max != -1) {
                System.out.println("The input is too large. Please input a valid value.");
                continue;
            }
            break;
        }
        return input;
    }

    private double promptDouble(Scanner scan, String prompt, double min, double max) {
        double input = 0;
        while (true) {
            System.out.print(prompt);
            String inputStr = scan.nextLine();
            try {
                input = Double.parseDouble(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please input a valid double value.");
                continue;
            }
            if (input < min && min != -1) {
                System.out.println("The input is too small. Please input a valid value.");
                continue;
            } else if (input > max && max != -1) {
                System.out.println("The input is too large. Please input a valid value.");
                continue;
            }
            break;
        }
        return input;
    }

    private void displayMenu() {
        System.out.println("\n1. Add a product");
        System.out.println("2. Look up a product by code");
        System.out.println("3. Change the quantity of a product");
        System.out.println("4. Toggle sale status for a product");
        System.out.println("5. Print the inventory");
        System.out.println("6. Print the out of stock products");
        System.out.println("7. Print summary stats");
        System.out.println("8. Exit");
    }

    private int getUserChoice(Scanner scan) {
        int choice = promptInt(scan, "Choose an option from the menu above: ", 1, 8);
        return choice;
    }

    private void handleChoice(Product[] products, Scanner scan, int choice) {
        switch (choice) {
            case 1: {
                Product product = addProduct(products, scan);
                if (product == null) {
                    break;
                }
                System.out.println("New product details: " + product);
                break;
            }
            case 2: {
                System.out.print("Enter the code of the product you're looking for: ");
                String code = scan.nextLine();
                Product product = lookupProduct(products, code);
                if (product == null) {
                    System.out.println("No product was found.");
                    break;
                }
                System.out.println(product);
                break;
            }
            case 3: {
                Product product = changeQuantity(products, scan);
                if (product == null) {
                    break;
                }
                System.out.println("Updated product details: " + product);
                break;
            }
            case 4: {
                Product product = toggleSaleStatus(products, scan);
                if (product == null) {
                    break;
                }
                System.out.println("Updated product details: " + product);
                break;
            }
            case 5: {
                printInventory(products);
                break;
            }
            case 6: {
                printOutOfStock(products);
                break;
            }
            case 7: {
                printSummaryStats(products);
                break;
            }
            default:
                break;
        }
    }

    private Product lookupProduct(Product[] products, String code) {
        for (Product p : products) {
            if (p == null) {
                return null;
            }
            if (code.equals(p.getCode())) {
                return p;
            }
        }
        return null;
    }

    private Product addProduct(Product[] products, Scanner scan) {
        String code = promptString(scan, "Enter the product code: ");
        Product duplicateProduct = lookupProduct(products, code);
        if (duplicateProduct != null) {
            duplicateProduct.setQuantity(duplicateProduct.getQuantity() + 1);
            return duplicateProduct;
        }
        if (getNumProducts(products) == products.length) {
            System.out.println(
                    "Product inventory is full. No new items can be added, only edits to current inventory can be made.");
            return null;
        }
        Product product = null;
        System.out.println("1. Album");
        System.out.println("2. Book");
        System.out.println("3. Software");
        int choice = promptInt(scan, "Which product would you like to add: ", 1, 3);
        String description = promptString(scan, "Enter the product description: ");
        double price = promptDouble(scan, "Enter the product price: ", 0, -1);
        double discountRate = promptDouble(scan, "Enter the product discount rate: ", 0, -1);
        String detail = "";
        if (choice == 1) {
            detail = promptString(scan, "Enter the album artist: ");
            product = new Album(code, description, price, discountRate, detail);
        } else if (choice == 2) {
            detail = promptString(scan, "Enter the book author: ");
            product = new Book(code, description, price, discountRate, detail);
        } else if (choice == 3) {
            detail = promptString(scan, "Enter the software version: ");
            product = new Software(code, description, price, discountRate, detail);
        }
        int insertPos = getNumProducts(products);
        products[insertPos] = product;
        return product;
    }

    private Product changeQuantity(Product[] products, Scanner scan) {
        Product product = promptProduct(products, scan, "Choose a product from above: ");
        if (product == null) {
            return null;
        }
        int newQuantity = promptInt(scan, "Enter the new product quantity: ", 0, -1);
        product.setQuantity(newQuantity);
        return product;
    }

    private Product toggleSaleStatus(Product[] products, Scanner scan) {
        Product product = promptProduct(products, scan, "Choose a product from above: ");
        if (product == null) {
            return null;
        }
        product.setOnSale(!product.isOnSale());
        return product;
    }

    private void printInventory(Product[] products) {
        if (getNumProducts(products) == 0) {
            System.out.println("The inventory is currently empty.");
            return;
        }
        System.out.println("\nInventory");

        System.out.println(
                "+----------+----------------------+------------+----------+------------+----------+----------+----------------------+");
        System.out.printf("| %-8s | %-20s | %-10s | %-8s | %-10s | %-8s | %-8s | %-20s |\n", "Code", "Description",
                "Price", "On Sale", "Discount", "Quantity", "Type", "Details");
        System.out.println(
                "+----------+----------------------+------------+----------+------------+----------+----------+----------------------+");

        for (Product p : products) {
            if (p == null) {
                break;
            }

            double discountAmount = p.calcDiscountAmount();

            double currentPrice;
            if (p.isOnSale()) {
                currentPrice = p.getPrice() - discountAmount;
            } else {
                currentPrice = p.getPrice();
            }

            String type;
            String details;

            if (p instanceof Album) {
                type = "Album";
                details = ((Album) p).getArtist();
            } else if (p instanceof Book) {
                type = "Book";
                details = ((Book) p).getAuthor();
            } else if (p instanceof Software) {
                type = "Software";
                details = ((Software) p).getVersion();
            } else {
                type = "Unknown";
                details = "";
            }

            System.out.printf("| %-8s | %-20s | $%9.2f | %-8s | $%9.2f | %8d | %-8s | %-20s |\n", p.getCode(),
                    p.getDescription(), currentPrice, p.isOnSale() ? "Yes" : "No", discountAmount, p.getQuantity(),
                    type, details);
        }

        System.out.println(
                "+----------+----------------------+------------+----------+------------+----------+----------+----------------------+");
    }

    private void printOutOfStock(Product[] products) {
        int total = 0;
        for (Product p : products) {
            if (p != null) {
                if (p.getQuantity() == 0) {
                    total++;
                }
            }
        }
        Product[] outOfStockProducts = new Product[total];
        int j = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getQuantity() == 0) {
                    outOfStockProducts[j] = products[i];
                    j++;
                }
            }
        }
        printInventory(outOfStockProducts);
    }

    private void printSummaryStats(Product[] products) {
        int totalProducts = 0;
        int totalAlbums = 0;
        int totalBooks = 0;
        int totalSoftware = 0;
        double totalCost = 0;
        for (Product p : products) {
            if (p != null) {
                totalProducts++;
                if (p instanceof Album) {
                    totalAlbums++;
                } else if (p instanceof Book) {
                    totalBooks++;
                } else if (p instanceof Software) {
                    totalSoftware++;
                }
                double discountAmount = p.calcDiscountAmount();
                double price = p.getPrice();
                if (p.isOnSale()) {
                    price = p.getPrice() - discountAmount;
                }
                totalCost += (price * p.getQuantity());
            }
        }
        System.out.println("Total number of products: " + totalProducts);
        System.out.println("Total number of albums: " + totalAlbums);
        System.out.println("Total number of books: " + totalBooks);
        System.out.println("Total number of software: " + totalSoftware);
        System.out.printf("Total dollar value of store's inventory: $%.2f\n", totalCost);
    }
}