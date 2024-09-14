package Entity;

public class BlogPost {

    private int id;
    private String title;
    private String content;
    private int authorId;
    private String status;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public BlogPost() {
    }

    public BlogPost(int id, String title, String content, int authorId, String status, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.util.Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(java.util.Date created_at) {
        this.created_at = created_at;
    }

    public java.util.Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(java.util.Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "BlogPost{" + "id=" + id + ", title=" + title + ", content=" + content + ", authorId=" + authorId + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
