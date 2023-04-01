package ex1;

public class ProgrammingBook extends Book{
    private String language;
    private String framework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(String name, int price, String author, String language, String framework) {
        super(name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public String toString() {
        return "ProgrammingBook{" +
                super.toString() +
                "language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
