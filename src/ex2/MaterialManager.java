package ex2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MaterialManager extends ArrayList<Material> {
    Scanner scanner = new Scanner(System.in);
    public void isValidPrice(int priceToCheck){
        if (priceToCheck < 0) {
            do {
                System.out.println("Invalid price, please enter a valid price: ");
                priceToCheck = Integer.parseInt(scanner.nextLine());
            }
            while ( priceToCheck >= 0 );
        }
    }
    public void addMaterial (){
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
        System.out.println("Enter the materia price");
        int cost = Integer.parseInt(scanner.nextLine());
        isValidPrice(cost);
        switch (choice){
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

}
