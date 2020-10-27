package flatmap;

public class Job {
    private String title;
    private String description;

    Job(String title, String description){
        this.title = title;
        this.description = description;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
