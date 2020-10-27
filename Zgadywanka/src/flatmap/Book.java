package flatmap;
import flatmap.Job;
import java.util.List;

public class Book {
    private String title;
    private int yearOfPublishing;
    private List<String> authors;
    //todo ta lista jest listą czego ? Musisz tutaj podac typ. Nie za bardzo rozumiem kontekst tego pola - o co w nim chodzi ?
    private List<List> javaBooks;


    //todo java books musi miec konkretny typ zgodny z javaBooks.
    public Book(String title, int yearOfPublishing, List<String> authors, List<List<Object>> javaBooks){
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
        //todo musisz sie zastnawoic jakiego typu jest ta lista, tutaj wychodzi ze jest to lista typu Object - a to jest zawsze blad.
        //this.javaBooks = javaBooks.add(List.of(title, authors, authors));
    }

    public List<String> getAuthors(){
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(final int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setAuthors(final List<String> authors) {
        this.authors = authors;
    }

}
