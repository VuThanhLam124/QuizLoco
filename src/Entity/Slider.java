package Entity;

public class Slider {
//    id INT PRIMARY KEY AUTO_INCREMENT,
//    title VARCHAR(255),
//    image_url VARCHAR(255),
//    link_url VARCHAR(255),
//    `order` INT,
//    status VARCHAR(20),
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    private int id;
    private String title;
    private String image_url;
    private String link_url;
    private int order;
    private String status;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public Slider() {
    }

    public Slider(int id, String title, String image_url, String link_url, int order, String status, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.title = title;
        this.image_url = image_url;
        this.link_url = link_url;
        this.order = order;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
        return "Slider{" + "id=" + id + ", title=" + title + ", image_url=" + image_url + ", link_url=" + link_url + ", order=" + order + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}
