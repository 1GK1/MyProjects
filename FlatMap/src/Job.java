public class Job {
    private String title;
    private String description;

    Job(String title, String description){
        this.title = title;
        this.description = description;
    }


//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
