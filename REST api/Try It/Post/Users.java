
public class Users {
    private float userId;
    private float id;
    private String title;

    // if you want to change the name
    @SerializedName("body")
    private String text;

    public Users(float userId, String title, String text) { // this constructor is used for posting. we are not taking the id because the server will give the id automatically.
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    // Getter Methods

    public float getUserId() {
        return userId;
    }

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    // Setter Methods

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String text) {
        this.text = text;
    }
}
