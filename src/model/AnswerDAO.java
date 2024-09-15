package model;
import Module.DBConnect;
import Entity.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnswerDAO {
    // CREATE: Add a new answer to the database
    public boolean addAnswer(Answer answer) {
        int n = 0;
        String sql = "INSERT INTO Answers(question_id, content, is_correct, created_at, updated_at) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, answer.getQuestionId());
            pre.setString(2, answer.getContent());
            pre.setBoolean(3, answer.getIsCorrect());

            // Check if created_at is null, and use the current timestamp if it is
            if (answer.getCreated_at() != null) {
                pre.setTimestamp(4, new java.sql.Timestamp(answer.getCreated_at().getTime()));
            } else {
                pre.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp
            }

            // Check if updated_at is null, and use the current timestamp if it is
            if (answer.getUpdated_at() != null) {
                pre.setTimestamp(5, new java.sql.Timestamp(answer.getUpdated_at().getTime()));
            } else {
                pre.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp
            }

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }
    // DELETE: Remove an answer from the database
    public boolean deleteAnswer(int id) {
        int n = 0;
        String sql = "DELETE FROM Answers WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }
    // UPDATE: Update an answer in the database
    public boolean updateAnswer(Answer answer) {
        int n = 0;
        String sql = "UPDATE Answers SET question_id = ?, content = ?, is_correct = ? WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, answer.getQuestionId());
            pre.setString(2, answer.getContent());
            pre.setBoolean(3, answer.getIsCorrect());
            pre.setInt(4, answer.getId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }
    // DELETE: Remove all answers from the database
    public boolean deleteAllAnswers() {
        int n = 0;
        String sql = "DELETE FROM Answers";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }
        // DELETE: Remove all answers for a question from the database
    public boolean deleteAllAnswersForQuestion(int question_id) {
        int n = 0;
        String sql = "DELETE FROM Answers WHERE question_id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, question_id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }
    //main method for verification
    public static void main(String[] args) {
        AnswerDAO dao = new AnswerDAO();
        Answer answer = new Answer(1, 1, "content", true, null, null); // created_at and updated_at are null
        System.out.println(dao.addAnswer(answer));
    }

}
