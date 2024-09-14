package Entity;

public class Question {

    private int id;
    private int quizId;
    private String content;
    private String difficulty_level;
    private String explanation;
    private java.util.Date created_at;
    private java.util.Date updated_at;

    public Question() {
    }

    public Question(int id, int quizId, String content, String difficulty_level, String explanation, java.util.Date created_at, java.util.Date updated_at) {
        this.id = id;
        this.quizId = quizId;
        this.content = content;
        this.difficulty_level = difficulty_level;
        this.explanation = explanation;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
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
        return "Question{" + "id=" + id + ", quizId=" + quizId + ", content=" + content + ", difficulty_level=" + difficulty_level + ", explanation=" + explanation + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}
