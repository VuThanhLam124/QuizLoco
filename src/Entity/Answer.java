package Entity;

public class Answer {

    private int id;
    private int questionId;
    private String content;
    private boolean isCorrect;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public Answer() {
    }

    public Answer(int id, int questionId, String content, boolean isCorrect, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.isCorrect = isCorrect;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
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
        return "Answer{" + "id=" + id + ", questionId=" + questionId + ", content=" + content + ", isCorrect=" + isCorrect + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
