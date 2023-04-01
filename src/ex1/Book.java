package ex1;

public class Book {
    private static int bookCode = 1000000;
    private String name;
    private int price;
    private String author;

    public Book() {
        bookCode++;
    }

    public Book(String name, int price, String author) {
        bookCode++;
        this.name = name;
        this.price = price;
        this.author = author;
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
        return "Book{" +
                "bookID =" + this.getBookCode() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'';
    }
}
