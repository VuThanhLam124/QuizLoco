package Entity;

import java.math.BigDecimal;

public class Quizz {

    private int id;
    private int subject_id;
    private String title;
    private String description;
    private int time_limit;
    private BigDecimal passing_score;
    private String status;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;

    public Quizz() {
    }

    public Quizz(int id, int subject_id, String title, String description, int time_limit, BigDecimal passing_score, String status, java.sql.Timestamp created_at, java.sql.Timestamp updated_at) {
        this.id = id;
        this.subject_id = subject_id;
        this.title = title;
        this.description = description;
        this.time_limit = time_limit;
        this.passing_score = passing_score;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime_limit(int time_limit) {
        this.time_limit = time_limit;
    }

    public void setPassing_score(BigDecimal passing_score) {
        this.passing_score = passing_score;
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

    public String getDescription() {
        return description;
    }

    public int getTime_limit() {
        return time_limit;
    }

    public BigDecimal getPassing_score() {
        return passing_score;
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

//    tostring method return quizz title + id
    @Override
    public String toString() {
        return title + " - " + id;
    }
}
