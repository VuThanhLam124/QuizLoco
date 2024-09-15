package model;
import java.sql.ResultSet;
import Entity.UserAnswer;
import Module.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAnswersDAO {
    private static final Logger LOGGER = Logger.getLogger(UserAnswersDAO.class.getName());

    // CREATE: Add a new user answer to the database
    public boolean addUserAnswer(UserAnswer userAnswer) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM userquizzes WHERE id = ?";
        String insertSql = "INSERT INTO UserAnswers (user_quiz_id, question_id, answer_id, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new DBConnect().getConnection()) {
            // Check if user_quiz_id exists
            try (PreparedStatement checkPre = conn.prepareStatement(checkSql)) {
                checkPre.setInt(1, userAnswer.getUser_quiz_id());
                ResultSet rs = checkPre.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // Foreign key constraint fails
                    LOGGER.log(Level.SEVERE, "Foreign key constraint fails: user_quiz_id does not exist in userquizzes table");
                    return false; // Stop further execution if user_quiz_id doesn't exist
                }
            }
            // Insert new user answer
            try (PreparedStatement pre = conn.prepareStatement(insertSql)) {
                pre.setInt(1, userAnswer.getUser_quiz_id());
                pre.setInt(2, userAnswer.getQuestion_id());
                pre.setInt(3, userAnswer.getAnswer_id());
                pre.setTimestamp(4, new java.sql.Timestamp(userAnswer.getCreated_at().getTime()));
                pre.setTimestamp(5, new java.sql.Timestamp(userAnswer.getUpdated_at().getTime()));
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "SQL Exception: " + ex.getMessage(), ex);
        }
        return n > 0;
    }
    // DELETE: Remove a user answer from the database
    public boolean deleteUserAnswer(int id) {
        int n = 0;
        String sql = "DELETE FROM UserAnswers WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }
    //remove all user answers
    public boolean deleteAllUserAnswers() {
        int n = 0;
        String sql = "DELETE FROM UserAnswers";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }

    // UPDATE: Update a user answer in the database
    public boolean updateUserAnswer(UserAnswer userAnswer) {
        int n = 0;
        String sql = "UPDATE UserAnswers SET user_quiz_id = ?, question_id = ?, answer_id = ? WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, userAnswer.getUser_quiz_id());
            pre.setInt(2, userAnswer.getQuestion_id());
            pre.setInt(3, userAnswer.getAnswer_id());
            pre.setInt(4, userAnswer.getId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }
    // DELETE: Remove all user answers for a user quiz from the database
    public boolean deleteAllUserAnswersForUserQuiz(int user_quiz_id) {
        int n = 0;
        String sql = "DELETE FROM UserAnswers WHERE user_quiz_id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, user_quiz_id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }
    // DELETE: Remove all user answers for a question from the database
    public boolean deleteAllUserAnswersForQuestion(int question_id) {
        int n = 0;
        String sql = "DELETE FROM UserAnswers WHERE question_id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, question_id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }
    // DELETE: Remove all user answers for a user quiz and question from the database
    public boolean deleteAllUserAnswersForUserQuizAndQuestion(int user_quiz_id, int question_id) {
        int n = 0;
        String sql = "DELETE FROM UserAnswers WHERE user_quiz_id = ? AND question_id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, user_quiz_id);
            pre.setInt(2, question_id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return n > 0;
    }
    //main method for testing
    public static void main(String[] args) {
        UserAnswersDAO userAnswersDAO = new UserAnswersDAO();
        UserAnswer userAnswer = new UserAnswer(1, 1, 1, 1, new java.util.Date(), new java.util.Date());

        // Add a user answer (Ensure user_quiz_id 1 exists in userquizzes table before running this)
        System.out.println(userAnswersDAO.addUserAnswer(userAnswer));

        // Delete the user answer
        System.out.println(userAnswersDAO.deleteUserAnswer(1));
    }

}