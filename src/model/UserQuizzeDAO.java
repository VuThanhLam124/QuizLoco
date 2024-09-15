package model;

import Entity.UserQuizze;
import Module.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserQuizzeDAO {
    // CREATE: Add a new user quiz to the database
    public boolean addUserQuiz(UserQuizze userQuizze) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM Quizzes WHERE id = ?";
        String sql = "INSERT INTO UserQuizzes (quiz_id, user_id, start_time, end_time, score, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement checkPre = conn.prepareStatement(checkSql);
             PreparedStatement pre = conn.prepareStatement(sql)) {
            checkPre.setInt(1, userQuizze.getQuiz_id());
            ResultSet rs = checkPre.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                pre.setInt(1, userQuizze.getQuiz_id());
                pre.setInt(2, userQuizze.getUser_id());
                pre.setTimestamp(3, new java.sql.Timestamp(userQuizze.getStart_time().getTime()));
                pre.setTimestamp(4, new java.sql.Timestamp(userQuizze.getEnd_time().getTime()));
                pre.setDouble(5, userQuizze.getScore());
                pre.setString(6, userQuizze.getStatus());
                pre.setTimestamp(7, new java.sql.Timestamp(userQuizze.getCreated_at().getTime()));
                pre.setTimestamp(8, new java.sql.Timestamp(userQuizze.getUpdated_at().getTime()));
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // DELETE: Remove a user quiz from the database
    public boolean deleteUserQuiz(int id) {
        int n = 0;
        String sql = "DELETE FROM UserQuizzes WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // UPDATE: Update a user quiz in the database
    public boolean updateUserQuiz(UserQuizze userQuizze) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM Quizzes WHERE id = ?";
        String sql = "UPDATE UserQuizzes SET quiz_id = ?, user_id = ?, start_time = ?, end_time = ?, score = ?, status = ?, created_at = ?, updated_at = ? WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement checkPre = conn.prepareStatement(checkSql);
             PreparedStatement pre = conn.prepareStatement(sql)) {
            checkPre.setInt(1, userQuizze.getQuiz_id());
            ResultSet rs = checkPre.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                pre.setInt(1, userQuizze.getQuiz_id());
                pre.setInt(2, userQuizze.getUser_id());
                pre.setTimestamp(3, new java.sql.Timestamp(userQuizze.getStart_time().getTime()));
                pre.setTimestamp(4, new java.sql.Timestamp(userQuizze.getEnd_time().getTime()));
                pre.setDouble(5, userQuizze.getScore());
                pre.setString(6, userQuizze.getStatus());
                pre.setTimestamp(7, new java.sql.Timestamp(userQuizze.getCreated_at().getTime()));
                pre.setTimestamp(8, new java.sql.Timestamp(userQuizze.getUpdated_at().getTime()));
                pre.setInt(9, userQuizze.getId());
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // DELETE: Remove all user quizzes from the database
    public boolean deleteAllUserQuizzes() {
        int n = 0;
        String sql = "DELETE FROM UserQuizzes";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // READ: Retrieve a user quiz from the database
    public UserQuizze getUserQuiz(int id) {
        UserQuizze userQuizze = null;
        String sql = "SELECT * FROM UserQuizzes WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                userQuizze.setStart_time(rs.getTimestamp("start_time"));
                userQuizze.setEnd_time(rs.getTimestamp("end_time"));
                userQuizze.setScore(rs.getDouble("score"));
                userQuizze.setStatus(rs.getString("status"));
                userQuizze.setCreated_at(rs.getTimestamp("created_at"));
                userQuizze.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userQuizze;
    }

   // READ: Retrieve all user quizzes from the database
    public UserQuizze[] getAllUserQuizzesByUserId(int user_id) {
        List<UserQuizze> userQuizzes = new ArrayList<>();
        String sql = "SELECT * FROM UserQuizzes WHERE user_id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, user_id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                UserQuizze userQuizze = new UserQuizze();
                userQuizze.setId(rs.getInt("id"));
                userQuizze.setQuiz_id(rs.getInt("quiz_id"));
                userQuizze.setUser_id(rs.getInt("user_id"));
                userQuizze.setStart_time(rs.getTimestamp("start_time"));
                userQuizze.setEnd_time(rs.getTimestamp("end_time"));
                userQuizze.setScore(rs.getDouble("score"));
                userQuizze.setStatus(rs.getString("status"));
                userQuizze.setCreated_at(rs.getTimestamp("created_at"));
                userQuizze.setUpdated_at(rs.getTimestamp("updated_at"));
                userQuizzes.add(userQuizze);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userQuizzes.toArray(new UserQuizze[0]);
    }
 //main method for testing
    public static void main(String[] args) {
        UserQuizzeDAO userQuizzeDAO = new UserQuizzeDAO();
        UserQuizze userQuizze = new UserQuizze();
        userQuizze.setQuiz_id(1);
        userQuizze.setUser_id(1);
        userQuizze.setStart_time(new java.util.Date());
        userQuizze.setEnd_time(new java.util.Date());
        userQuizze.setScore(10);
        userQuizze.setStatus("Completed");
        userQuizze.setCreated_at(new java.util.Date());
        userQuizze.setUpdated_at(new java.util.Date());
        userQuizzeDAO.addUserQuiz(userQuizze);
        userQuizzeDAO.deleteUserQuiz(1);
        userQuizzeDAO.updateUserQuiz(userQuizze);
        userQuizzeDAO.deleteAllUserQuizzes();
        userQuizzeDAO.getUserQuiz(1);
        userQuizzeDAO.getAllUserQuizzesByUserId(1);
    }
}