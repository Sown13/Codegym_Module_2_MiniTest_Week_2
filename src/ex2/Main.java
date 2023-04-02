package ex2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialInventory = new MaterialManager();
        Material meat1 = new Meat("m12", "meat1", LocalDate.of(2023,4,1), 100, 10 );
        Material meat2 = new Meat("m24", "meat2", LocalDate.of(2023,4,1), 200, 5 );
        Material meat3 = new Meat("m13", "meat1", LocalDate.of(2023,3,25), 300, 15 );
        Material meat4 = new Meat("m12", "meat1", LocalDate.of(2023,3,27), 400, 5 );
        Material meat5 = new Meat("m11", "meat1", LocalDate.of(2023,4,3), 200, 10 );
        Material flour1 = new CrispyFlour("f10","flour1",LocalDate.of(2022,3,1),50,10);
        Material flour2 = new CrispyFlour("f20","flour2",LocalDate.of(2022,8,1),100,20);
        Material flour3 = new CrispyFlour("f30","flour3",LocalDate.of(2023,1,1),150,30);
        Material flour4 = new CrispyFlour("f20","flour4",LocalDate.of(2023,2,1),200,20);
        Material flour5 = new CrispyFlour("f40","flour5",LocalDate.of(2022,5,1),300,10);
        Scanner scanner = new Scanner(System.in);
        materialInventory.add(meat1);
        materialInventory.add(meat2);
        materialInventory.add(meat3);
        materialInventory.add(meat4);
        materialInventory.add(meat5);
        materialInventory.add(flour1);
        materialInventory.add(flour2);
        materialInventory.add(flour3);
        materialInventory.add(flour4);
        materialInventory.add(flour5);
        int choice;
        while (true) {
            System.out.println("Please choose your action:");
            System.out.println("1/ Add Materials");
            System.out.println("2/ Show list of materials");
            System.out.println("3/ Edit list");
            System.out.println("4/ Remove material from list");
            System.out.println("0/ Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> materialInventory.addMaterial();
                case 2 -> System.out.println(materialInventory);
                case 3 -> materialInventory.editListByIndex();
                case 4 -> materialInventory.removeMaterialFromList();
                case 0 -> System.exit(0);
            }
        }
    }
}