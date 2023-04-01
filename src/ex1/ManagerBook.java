package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBook extends ArrayList<Book> {
    Scanner scanner = new Scanner(System.in);
    public ManagerBook() {
    }
    public void addProgrammingBook() {
        System.out.println("Enter the book's name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter the book's price:");
        int bookPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the book's author:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter the book's programming language:");
        String language = scanner.nextLine();
        System.out.println("Enter the framework:");
        String framework = scanner.nextLine();
        ProgrammingBook book = new ProgrammingBook(bookName, bookPrice, bookAuthor, language, framework);
        this.add(book);
    }
    public void addFictionBook(){
        System.out.println("Enter the book's name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter the book's price:");
        int bookPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the book's author:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter the book's category:");
        String category = scanner.nextLine();
        FictionBook book = new FictionBook(bookName, bookPrice, bookAuthor, category);
        this.add(book);
    }
    public int calTotalPrice(){
        int sum = 0;
        for (Book book : this) {
            sum += book.getPrice();
        }
        return sum;
    }
    public void calTotalPriceFromTo(){
        int sum = 0;
        System.out.println("Enter the index of start");
        int indexCalFrom = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the index of end");
        int indexCalTo = Integer.parseInt(scanner.nextLine());
        if (indexCalFrom >= 0 && indexCalFrom <= indexCalTo && indexCalTo < size()){
            for (int i = indexCalFrom; i <= indexCalTo; i++){
                sum += get(i).getPrice();
            }
            System.out.println("The total price of book from index " + indexCalFrom + " to " + indexCalTo + " is " + sum);
        } else System.out.println("Invalid index");
    }

}
