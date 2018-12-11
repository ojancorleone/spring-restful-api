package rest.api;

public class Blog {

    private int id;
    private String title;
    private String content;

    public Blog(){}

    public Blog(int id, String title, String content){

        this.id         = id;
        this.title      = title;
        this.content    = content;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", content='" + this.content + '\'' +
                '}';
    }
}
