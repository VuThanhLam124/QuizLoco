package Entity;

public class PricePackage {

//        id INT PRIMARY KEY AUTO_INCREMENT,
//    subject_id INT,
//    name VARCHAR(255),
//    description TEXT,
//    price DECIMAL(10,2),
//    duration_months INT,
//    status VARCHAR(20),
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    private int id;
    private int subject_id;
    private String name;
    private String description;
    private double price;
    private int duration_months;
    private String status;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public PricePackage() {
    }

    public PricePackage(int id, int subject_id, String name, String description, double price, int duration_months, String status, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.subject_id = subject_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration_months = duration_months;
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

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration_months() {
        return duration_months;
    }

    public void setDuration_months(int duration_months) {
        this.duration_months = duration_months;
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
        return "PricePackage{" + "id=" + id + ", subject_id=" + subject_id + ", name=" + name + ", description=" + description + ", price=" + price + ", duration_months=" + duration_months + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
