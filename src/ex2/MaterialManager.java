package ex2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager extends ArrayList<Material> {
    Scanner scanner = new Scanner(System.in);

    public void isValidPrice(int priceToCheck) {
        if (priceToCheck < 0) {
            do {
                System.out.println("Invalid price, please enter a valid price: ");
                priceToCheck = Integer.parseInt(scanner.nextLine());
            }
            while (priceToCheck >= 0);
        }
    }

    public void addMaterial() {
        System.out.println("Which one do you want to add?");
        System.out.println("1/ Meat");
        System.out.println("2/ CrispyFlour");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter material id");
        String id = scanner.nextLine();
        System.out.println("Enter material name");
        String name = scanner.nextLine();
        System.out.println("Enter the manufacturing date by following order:");
        System.out.println("Enter the year");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the month");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the dayOfMonth");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate manufacturingDate = LocalDate.of(year, month, day);
        System.out.println("Enter the material price");
        int cost = Integer.parseInt(scanner.nextLine());
        isValidPrice(cost);
        switch (choice) {
            case 1 -> {
                System.out.println("Enter meat weight:");
                double weight = Double.parseDouble(scanner.nextLine());
                this.add(new Meat(id, name, manufacturingDate, cost, weight));
            }
            case 2 -> {
                System.out.println("Enter crispy flour quantity");
                int quantity = Integer.parseInt(scanner.nextLine());
                this.add(new CrispyFlour(id, name, manufacturingDate, cost, quantity));
            }
        }
    }

    public void editListByIndex() {
        System.out.println("Please enter the index of the materials that you want to edit: ");
        int indexEdit = Integer.parseInt(scanner.nextLine());
        while (indexEdit < 0 || indexEdit >= size()) {
            System.out.println("Invalid index, please enter a valid index: ");
            indexEdit = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(this.get(indexEdit));
        System.out.println("Enter new material name");
        String name = scanner.nextLine();
        System.out.println("Enter the new manufacturing date by following order:");
        System.out.println("Enter the new year");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the new month");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the new dayOfMonth");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate manufacturingDate = LocalDate.of(year, month, day);
        System.out.println("Enter the new material price");
        int cost = Integer.parseInt(scanner.nextLine());
        isValidPrice(cost);
        if (get(indexEdit) instanceof Meat) {
            System.out.println("Enter meat weight:");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("Are you sure you want to edit?");
            System.out.println("1/ Do it");
            System.out.println("0/ Cancel");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                this.get(indexEdit).setName(name);
                this.get(indexEdit).setManufacturingDate(manufacturingDate);
                this.get(indexEdit).setCost(cost);
                ((Meat) this.get(indexEdit)).setWeight(weight);
            } else {
                System.out.println("Canceled edit");
                System.out.println("Back to the main menu");
                return;
            }
        } else if (get(indexEdit) instanceof CrispyFlour) {
            System.out.println("Enter crispy flour quantity");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Are you sure you want to edit?");
            System.out.println("1/ Do it");
            System.out.println("0/ Cancel");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                this.get(indexEdit).setName(name);
                this.get(indexEdit).setManufacturingDate(manufacturingDate);
                this.get(indexEdit).setCost(cost);
                ((CrispyFlour) this.get(indexEdit)).setQuantity(quantity);
            } else {
                System.out.println("Canceled edit");
                System.out.println("Back to the main menu");
                return;
            }
        }
        System.out.println("Successful Edit");
        System.out.println("New material info: ");
        System.out.println(this.get(indexEdit));
        System.out.println("Back to the main menu");
    }

    public void removeMaterialFromList() {
        System.out.println("Please enter the index of the material that you want to remove: ");
        int indexEdit = Integer.parseInt(scanner.nextLine());
        while (indexEdit < 0 || indexEdit >= size()) {
            System.out.println("Invalid index, please enter a valid index: ");
            indexEdit = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("You are trying to delete this material");
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
    public void priceDifferentAfterDiscount(CrispyFlour flour){
        System.out.println(flour.getDifferentPrice());
    }
    public void priceDifferentAfterDiscount(Meat flour){
        System.out.println(flour.getDifferentPrice());
    }
}
