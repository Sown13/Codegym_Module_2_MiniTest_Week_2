package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookInventory = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        Book book1 = new ProgrammingBook("book1", 50,"Son","java","springs");
        Book book2 = new ProgrammingBook("book2", 700,"Son","html","bootstrap");
        Book book3 = new ProgrammingBook("book3", 100,"Nam","js","springs");
        Book book4 = new ProgrammingBook("book4", 150,"Son","java","reactJ");
        Book book5 = new ProgrammingBook("book5", 200,"Hai","java","springs");
        Book book6 = new FictionBook("book6", 50,"Son","Viễn tưởng 1");
        Book book7 = new FictionBook("book7", 200,"Hung","fiction 2");
        Book book8 = new FictionBook("book8", 100,"Thi","Viễn tưởng 1");
        Book book9 = new FictionBook("book9", 150,"Giang","not fiction");
        Book book10 = new FictionBook("book10", 300,"Son","actually science");
        bookInventory.add(book1);
        bookInventory.add(book2);
        bookInventory.add(book3);
        bookInventory.add(book4);
        bookInventory.add(book5);
        bookInventory.add(book6);
        bookInventory.add(book7);
        bookInventory.add(book8);
        bookInventory.add(book9);
        bookInventory.add(book10);
        while (true) {
            System.out.println("Please choose your action:");
            System.out.println("1/ Add Programming Book");
            System.out.println("2/ Add Fiction Book");
            System.out.println("3/ Show list of book");
            System.out.println("4/ Calculate total price");
            System.out.println("5/ Calculate total price of book in the range you want");
            System.out.println("6/ Count book by price");
            System.out.println("7/ Count book by type");
            System.out.println("8/ Edit book info");
            System.out.println("9/ Remove book info");
            System.out.println("0/ Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> bookInventory.addProgrammingBook();
                case 2 -> bookInventory.addFictionBook();
                case 3 -> System.out.println(bookInventory);
                case 4 -> System.out.println("The total price is: " + bookInventory.calTotalPrice());
                case 5 -> {
                    System.out.println("Please");
                    bookInventory.calTotalPriceFromTo();
                }
                case 6 -> {
                    boolean menuNestedCheck = true;
                    while (menuNestedCheck) {
                        System.out.println("Please choose your action: ");
                        System.out.println("1/ Count book that have price less than or equal: ");
                        System.out.println("2/ Count book that have price higher than: ");
                        System.out.println("0/ Back to main menu: ");
                        int option = Integer.parseInt(scanner.nextLine());
                        switch (option) {
                            case 1 -> bookInventory.countBookByPriceLesser();
                            case 2 -> bookInventory.countBookByPriceHigher();
                            case 0 -> menuNestedCheck = false;
                        }
                    }
                }
                case 7 -> {
                    boolean menuNestedCheck = true;
                    while (menuNestedCheck) {
                        System.out.println("Please choose your action: ");
                        System.out.println("1/ Count book by Category: ");
                        System.out.println("2/ Count book by programming language: ");
                        System.out.println("3/ Count book by framework: ");
                        System.out.println("0/ Back to main menu: ");
                        int option = Integer.parseInt(scanner.nextLine());
                        switch (option) {
                            case 1 -> bookInventory.countBookByCategory();
                            case 2 -> bookInventory.countBookByLanguage();
                            case 3 -> bookInventory.countBookByFramework();
                            case 0 -> menuNestedCheck = false;
                        }
                    }
                }
                case 8 -> {
                    System.out.println(bookInventory);
                    bookInventory.editBookInfo();
                }
                case 9 -> {
                    System.out.println(bookInventory);
                    bookInventory.removeBookInfo();
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
