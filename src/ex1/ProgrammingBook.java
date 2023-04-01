package ex1;

public class ProgrammingBook extends Book{
    private String language;
    private String faramework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(int bookCode, String name, int price, String author, String language, String faramework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.faramework = faramework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFaramework() {
        return faramework;
    }

    public void setFaramework(String faramework) {
        this.faramework = faramework;
    }
}
