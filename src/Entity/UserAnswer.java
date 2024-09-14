package Entity;

public class UserAnswer {
//        id INT PRIMARY KEY AUTO_INCREMENT,
//    user_quiz_id INT,
//    question_id INT,
//    answer_id INT,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    private int id;
    private int user_quiz_id;
    private int question_id;
    private int answer_id;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public UserAnswer() {
    }

    public UserAnswer(int id, int user_quiz_id, int question_id, int answer_id, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.user_quiz_id = user_quiz_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_quiz_id() {
        return user_quiz_id;
    }

    public void setUser_quiz_id(int user_quiz_id) {
        this.user_quiz_id = user_quiz_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
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
        return "UserAnswer{" + "id=" + id + ", user_quiz_id=" + user_quiz_id + ", question_id=" + question_id + ", answer_id=" + answer_id + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
