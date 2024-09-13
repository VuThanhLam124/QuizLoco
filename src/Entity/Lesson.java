package Entity;

public class Lesson {

    private int id;
    private int subject_id;
    private String title;
    private String content;
    private int order;
    private String status;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;

    public Lesson() {
    }

    public Lesson(int id, int subject_id, String title, String content, int order, String status, java.sql.Timestamp created_at, java.sql.Timestamp updated_at) {
        this.id = id;
        this.subject_id = subject_id;
        this.title = title;
        this.content = content;
        this.order = order;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated_at(java.sql.Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(java.sql.Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getOrder() {
        return order;
    }

    public String getStatus() {
        return status;
    }

    public java.sql.Timestamp getCreated_at() {
        return created_at;
    }

    public java.sql.Timestamp getUpdated_at() {
        return updated_at;
    }
//    tostring method return lesson title + subject id + id
    @Override
    public String toString() {
        return title + " " + subject_id + " " + id;
    }

}
