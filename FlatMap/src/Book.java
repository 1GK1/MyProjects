import java.util.List;

public class Book {
    private String title;
    private int yearOfPublishing;
    private List<String> authors;


//  Obiekt Book ma mieć trzy pola: String, int i List. Może tak być? Jak zbudować konstruktor?
//    Potem chcę zbudować listę złożoną z obiektów Book - zrobiłem to w Main, ale trochę na około...
    // Czy w kostruktorze może wpisać kod, żeby utworzony obiekt Book wpisywać od razu do listy javaBooks?

    public Book(String title, int yearOfPublishing, List<String> authors){
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
//        this.javaBooks = javaBooks.add(new Book());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getAuthors(){
        return authors;
    }
//    https://hyperskill.org/learn/step/3568
}
