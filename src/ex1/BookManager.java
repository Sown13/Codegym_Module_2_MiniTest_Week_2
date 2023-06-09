package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager extends ArrayList<Book> {
    Scanner scanner = new Scanner(System.in);

    public BookManager() {
    }

    public int validPrice(int priceToCheck) {
        while (priceToCheck < 0) {
            System.out.println("Invalid price, please enter a valid price: ");
            priceToCheck = Integer.parseInt(scanner.nextLine());
        }
        return priceToCheck;
    }

    public void addProgrammingBook() {
        System.out.println("Enter the book's name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter the book's price:");
        int bookPrice = Integer.parseInt(scanner.nextLine());
        bookPrice = validPrice(bookPrice);
        System.out.println("Enter the book's author:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter the book's programming language:");
        String language = scanner.nextLine();
        System.out.println("Enter the framework:");
        String framework = scanner.nextLine();
        ProgrammingBook book = new ProgrammingBook(bookName, bookPrice, bookAuthor, language, framework);
        this.add(book);
    }

    public void addFictionBook() {
        System.out.println("Enter the book's name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter the book's price:");
        int bookPrice = Integer.parseInt(scanner.nextLine());
        bookPrice = validPrice(bookPrice);
        System.out.println("Enter the book's author:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter the book's category:");
        String category = scanner.nextLine();
        FictionBook book = new FictionBook(bookName, bookPrice, bookAuthor, category);
        this.add(book);
    }

    public int calTotalPrice() {
        int sum = 0;
        for (Book book : this) {
            sum += book.getPrice();
        }
        return sum;
    }

    public void calTotalPriceFromTo() {
        int sum = 0;
        System.out.println("Enter the index of start");
        int indexCalFrom = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the index of end");
        int indexCalTo = Integer.parseInt(scanner.nextLine());
        if (indexCalFrom >= 0 && indexCalFrom <= indexCalTo && indexCalTo < size()) {
            for (int i = indexCalFrom; i <= indexCalTo; i++) {
                sum += get(i).getPrice();
            }
            System.out.println("The total price of book from index " + indexCalFrom + " to " + indexCalTo + " is " + sum);
        } else System.out.println("Invalid index");
    }

    public void countBookByPriceLesser() {
        int count = 0;
        System.out.println("Enter the price for lesser or equal count: ");
        int priceToCheck = Integer.parseInt(scanner.nextLine());
        for (Book book : this) {
            if (book.getPrice() <= priceToCheck) {
                count++;
            }
        }
        System.out.println("The number of book that have price less than or equal " + priceToCheck + " is " + count);
    }

    public void countBookByPriceHigher() {
        int count = 0;
        System.out.println("Enter the price for higher count: ");
        int priceToCheck = Integer.parseInt(scanner.nextLine());
        for (Book book : this) {
            if (book.getPrice() > priceToCheck) {
                count++;
            }
        }
        System.out.println("The number of book that have price higher than " + priceToCheck + " is " + count);
    }

    public void countBookByCategory() {
        int count = 0;
        System.out.println("Enter the category name: ");
        String category = scanner.nextLine();
        for (Book book : this) {
            if (book instanceof FictionBook) {
                if (((FictionBook) book).getCategory().equals(category)) {
                    count++;
                }
            }
        }
        System.out.println("The number of book that have category " + "'" + category + "'" + " is " + count);
    }

    public void countBookByLanguage() {
        int count = 0;
        System.out.println("Enter the programming language name: ");
        String language = scanner.nextLine();
        for (Book book : this) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getLanguage().equals(language)) {
                    count++;
                }
            }
        }
        System.out.println("The number of book that have category " + "'" + language + "'" + " is " + count);
    }

    public void countBookByFramework() {
        int count = 0;
        System.out.println("Enter the framework name: ");
        String framework = scanner.nextLine();
        for (Book book : this) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getFramework().equals(framework)) {
                    count++;
                }
            }
        }
        System.out.println("The number of book that have category " + "'" + framework + "'" + " is " + count);
    }

    public void editBookInfo() {
        System.out.println("Please enter the index of the book you want to edit: ");
        int indexEdit = Integer.parseInt(scanner.nextLine());
        while (indexEdit < 0 || indexEdit >= size()) {
            System.out.println("Invalid index, please enter a valid index: ");
            indexEdit = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(this.get(indexEdit));
        System.out.println("Enter the new book's name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter the new book's price:");
        int bookPrice = Integer.parseInt(scanner.nextLine());
        bookPrice = validPrice(bookPrice);
        System.out.println("Enter the new book's author:");
        String bookAuthor = scanner.nextLine();
        if (get(indexEdit) instanceof ProgrammingBook) {
            System.out.println("Enter the new book's programming language:");
            String language = scanner.nextLine();
            System.out.println("Enter the new framework:");
            String framework = scanner.nextLine();
            this.get(indexEdit).setName(bookName);
            this.get(indexEdit).setPrice(bookPrice);
            this.get(indexEdit).setAuthor(bookAuthor);
            ((ProgrammingBook) this.get(indexEdit)).setLanguage(language);
            ((ProgrammingBook) this.get(indexEdit)).setFramework(framework);
        } else if (get(indexEdit) instanceof FictionBook) {
            System.out.println("Enter the book's category:");
            String category = scanner.nextLine();
            ((FictionBook) this.get(indexEdit)).setCategory(category);
        }

    }

    public void removeBookInfo() {
        System.out.println("Please enter the index of the book you want to remove: ");
        int indexEdit = Integer.parseInt(scanner.nextLine());
//        run-time error : input string, double, float, out of range integer.
        while (indexEdit < 0 || indexEdit >= size()) {
            System.out.println("Invalid index, please enter a valid index: ");
            indexEdit = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("You are trying to delete this book");
        System.out.println(this.get(indexEdit));
        System.out.println("Are you sure about this? ");
        System.out.println("1/ Yes");
        System.out.println("0/ No");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            remove(this.get(indexEdit));
            System.out.println("Successful removal");
            System.out.println("Back to the main menu");
        } else {
            System.out.println("Canceled");
            System.out.println("Back to the main menu!");
        }
    }

//    public void countBookByType() - finding a better solution for counting book
//        run-time error : input string, double, float, out of range integer.
}
