package ex1;

public class Book {
    private static int bookID = 1000000;
    private int bookCode;
    private String name;
    private int price;
    private String author;

    public Book() {
        bookID++;
    }

    public Book(String name, int price, String author) {
        bookID++;
        this.name = name;
        this.price = price;
        this.author = author;
        this.bookCode = bookID;
    }

    public int getBookID(){
        return bookID;
    }
    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book name: " + name + "--" +
                "bookID =" + this.getBookCode() +
                ", price=" + price +
                ", author='" + author + '\'';
    }
}
