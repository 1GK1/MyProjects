import java.util.List;

public class Book {
    private String title;
    private int yearOfPublishing;
    private List<String> authors;
    private List<List> javaBooks;


    public Book(String title, int yearOfPublishing, List authors, List javaBooks){
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
        this.javaBooks = javaBooks.add(title, authors, authors);
    }

    public List<String> getAuthors(){
        return authors;
    }
//    https://hyperskill.org/learn/step/3568
}
