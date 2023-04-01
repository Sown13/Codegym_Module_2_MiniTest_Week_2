package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerBook bookInventory = new ManagerBook();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Please choose your action:");
            System.out.println("1/ Add Programming Book");
            System.out.println("2/ Add Fiction Book");
            System.out.println("3/ Show list of book");
            System.out.println("4/ Calculate total price");
            System.out.println("5/ Calculate total price of book in the range you want");
            System.out.println("6/ Count book by price: ");
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
                    while (menuNestedCheck){
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
                case 0 -> System.exit(0);
            }
        }
    }
}
