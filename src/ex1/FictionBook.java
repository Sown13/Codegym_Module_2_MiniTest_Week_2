package ex1;

public class FictionBook extends Book{
    public String category;

    public FictionBook() {
    }

    public FictionBook(String name, int price, String author, String category) {
        super(name, price, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                super.toString() +
                "category='" + category + '\'' +
                '}';
    }
}
