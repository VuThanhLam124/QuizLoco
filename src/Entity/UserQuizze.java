package Entity;

public class UserQuizze {

//        id INT PRIMARY KEY AUTO_INCREMENT,
//    user_id INT,
//    quiz_id INT,
//    start_time TIMESTAMP,
//    end_time TIMESTAMP,
//    score DECIMAL(5,2),
//    status VARCHAR(20),
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    private int id;
    private int user_id;
    private int quiz_id;
    private java.util.Date start_time;
    private java.util.Date end_time;
    private double score;
    private String status;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public UserQuizze() {
    }

    public UserQuizze(int id, int user_id, int quiz_id, java.util.Date start_time, java.util.Date end_time, double score, String status, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public java.util.Date getStart_time() {
        return start_time;
    }

    public void setStart_time(java.util.Date start_time) {
        this.start_time = start_time;
    }

    public java.util.Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(java.util.Date end_time) {
        this.end_time = end_time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
        return "UserQuizze{" + "id=" + id + ", user_id=" + user_id + ", quiz_id=" + quiz_id + ", start_time=" + start_time + ", end_time=" + end_time + ", score=" + score + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
