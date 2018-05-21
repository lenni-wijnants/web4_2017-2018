package domain;

public class BlogPost {

    private String name;
    private String rating;
    private String message;
    private String form;

    public BlogPost(String name, String rating, String message, String form) {
        this.name = name;
        this.rating = rating;
        this.message = message;
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getForm(){ return form; }

    public void setForm(String form) { this.form = form; }
}
