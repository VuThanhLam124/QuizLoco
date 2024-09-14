package Entity;

public class Registrations {

    private int id;
    private int userId;
    private int subjectId;
    private java.util.Date registered_date;
    private java.util.Date expiration_date;
    private String status;
//    price_paid DECIMAL(10,2) to java datatype: double
    private double price_paid;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public Registrations() {
    }

    public Registrations(int id, int userId, int subjectId, java.util.Date registered_date, java.util.Date expiration_date, String status, double price_paid, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.userId = userId;
        this.subjectId = subjectId;
        this.registered_date = registered_date;
        this.expiration_date = expiration_date;
        this.status = status;
        this.price_paid = price_paid;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public java.util.Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(java.util.Date registered_date) {
        this.registered_date = registered_date;
    }

    public java.util.Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(java.util.Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice_paid() {
        return price_paid;
    }

    public void setPrice_paid(double price_paid) {
        this.price_paid = price_paid;
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
        return "Registrations{" + "id=" + id + ", userId=" + userId + ", subjectId=" + subjectId + ", registered_date=" + registered_date + ", expiration_date=" + expiration_date + ", status=" + status + ", price_paid=" + price_paid + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
