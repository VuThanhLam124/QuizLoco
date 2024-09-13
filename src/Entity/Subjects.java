package Entity;

public class Subjects {
    private int id;
    private String title;
    private String description;
    private String category;
    private String thumbnail_url;
    private String status;
    private int created_by;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;
    private byte[] avatar;

    public Subjects() {
    }

    public Subjects(int id, String title, String description, String category, String thumbnail_url, String status, int created_by, java.sql.Timestamp created_at, java.sql.Timestamp updated_at, byte[] avatar) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail_url = thumbnail_url;
        this.status = status;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setCreated_at(java.sql.Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(java.sql.Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getStatus() {
        return status;
    }

    public int getCreated_by() {
        return created_by;
    }

    public java.sql.Timestamp getCreated_at() {
        return created_at;
    }

    public java.sql.Timestamp getUpdated_at() {
        return updated_at;
    }

    public byte[] getAvatar() {
        return avatar;
    }

//    tostring method return subject title + category + id
    @Override
    public String toString() {
        return title + " - " + category + " - " + id;
    }
}
