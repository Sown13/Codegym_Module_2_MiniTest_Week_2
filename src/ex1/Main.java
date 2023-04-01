package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerBook bookInventory = new ManagerBook();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Please choose your action:");
            System.out.println("1/ Add Programming Book");
            System.out.println("2/ Add Fiction Book");
            System.out.println("3/ Show list of book");
            System.out.println("4/ Calculate total price");
            System.out.println("0/ Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> bookInventory.addProgrammingBook();
                case 2 -> bookInventory.addFictionBook();
                case 3 -> System.out.println(bookInventory);
//                case 4 -> {
//                    int sum = 0;
//                    for (int unitPrice : (Book)bookInventory.){
//                        sum += unitPrice;
//                    }
//                }
                case 0 -> System.exit(0);
            }
        }
    }
}
