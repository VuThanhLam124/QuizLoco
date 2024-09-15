package model;

import Entity.Lesson;
import Module.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LessonDAO {
    // CREATE: Add a new lesson to the database
    public boolean addLesson(Lesson lesson) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM Subjects WHERE id = ?";
        String sql = "INSERT INTO Lessons (subject_id, title, content, `order`, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new DBConnect().getConnection()) {
            // Check if subject_id exists in the Subjects table
            try (PreparedStatement checkPre = conn.prepareStatement(checkSql)) {
                checkPre.setInt(1, lesson.getSubject_id());
                ResultSet rs = checkPre.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // Foreign key constraint fails
                    System.err.println("Foreign key constraint fails: subject_id does not exist in Subjects table");
                    return false; // Stop further execution if subject_id doesn't exist
                }
            }

            // Insert the new lesson
            try (PreparedStatement pre = conn.prepareStatement(sql)) {
                pre.setInt(1, lesson.getSubject_id());
                pre.setString(2, lesson.getTitle());
                pre.setString(3, lesson.getContent());
                pre.setInt(4, lesson.getOrder());
                pre.setString(5, lesson.getStatus());

                // Use the current timestamp if created_at and updated_at are null
                pre.setTimestamp(6, lesson.getCreated_at() != null
                        ? new java.sql.Timestamp(lesson.getCreated_at().getTime())
                        : new java.sql.Timestamp(System.currentTimeMillis()));
                pre.setTimestamp(7, lesson.getUpdated_at() != null
                        ? new java.sql.Timestamp(lesson.getUpdated_at().getTime())
                        : new java.sql.Timestamp(System.currentTimeMillis()));

                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // DELETE: Remove a lesson from the database
    public boolean deleteLesson(int id) {
        int n = 0;
        String sql = "DELETE FROM Lessons WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            // Check if lesson exists
            if (!lessonExists(id, conn)) {
                System.err.println("Deletion failed: Lesson with id " + id + " does not exist.");
                return false;
            }
            // Delete the lesson
            try (PreparedStatement pre = conn.prepareStatement(sql)) {
                pre.setInt(1, id);
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // UPDATE: Update a lesson in the database
    public boolean updateLesson(Lesson lesson) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM Subjects WHERE id = ?";
        String sql = "UPDATE Lessons SET subject_id = ?, title = ?, content = ?, `order` = ?, status = ?, updated_at = ? WHERE id = ?";

        try (Connection conn = new DBConnect().getConnection()) {
            // Check if subject_id exists in the Subjects table
            try (PreparedStatement checkPre = conn.prepareStatement(checkSql)) {
                checkPre.setInt(1, lesson.getSubject_id());
                ResultSet rs = checkPre.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // Foreign key constraint fails
                    System.err.println("Foreign key constraint fails: subject_id does not exist in Subjects table");
                    return false; // Stop further execution if subject_id doesn't exist
                }
            }

            // Check if lesson exists
            if (!lessonExists(lesson.getId(), conn)) {
                System.err.println("Update failed: Lesson with id " + lesson.getId() + " does not exist.");
                return false;
            }

            // Update the lesson
            try (PreparedStatement pre = conn.prepareStatement(sql)) {
                pre.setInt(1, lesson.getSubject_id());
                pre.setString(2, lesson.getTitle());
                pre.setString(3, lesson.getContent());
                pre.setInt(4, lesson.getOrder());
                pre.setString(5, lesson.getStatus());
                pre.setTimestamp(6, lesson.getUpdated_at() != null
                        ? new java.sql.Timestamp(lesson.getUpdated_at().getTime())
                        : new java.sql.Timestamp(System.currentTimeMillis()));
                pre.setInt(7, lesson.getId());
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // DELETE: Remove all lessons for a subject from the database
    public boolean deleteAllLessonsForSubject(int subject_id) {
        int n = 0;
        String checkSql = "SELECT COUNT(*) FROM Subjects WHERE id = ?";
        String sql = "DELETE FROM Lessons WHERE subject_id = ?";

        try (Connection conn = new DBConnect().getConnection()) {
            // Check if subject_id exists in the Subjects table
            try (PreparedStatement checkPre = conn.prepareStatement(checkSql)) {
                checkPre.setInt(1, subject_id);
                ResultSet rs = checkPre.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // Foreign key constraint fails
                    System.err.println("Deletion failed: subject_id does not exist in Subjects table");
                    return false; // Stop further execution if subject_id doesn't exist
                }
            }

            // Delete all lessons for the subject
            try (PreparedStatement pre = conn.prepareStatement(sql)) {
                pre.setInt(1, subject_id);
                n = pre.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // Check if a lesson exists by id
    private boolean lessonExists(int id, Connection conn) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM Lessons WHERE id = ?";
        try (PreparedStatement checkPre = conn.prepareStatement(checkSql)) {
            checkPre.setInt(1, id);
            ResultSet rs = checkPre.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
    // Get a lesson by ID
    public Lesson getLessonById(int id) {
        Lesson lesson = null;
        String sql = "SELECT * FROM Lessons WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                lesson = new Lesson();
                lesson.setId(rs.getInt("id"));
                lesson.setSubject_id(rs.getInt("subject_id"));
                lesson.setTitle(rs.getString("title"));
                lesson.setContent(rs.getString("content"));
                lesson.setOrder(rs.getInt("order"));
                lesson.setStatus(rs.getString("status"));
                lesson.setCreated_at(rs.getTimestamp("created_at"));
                lesson.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lesson;
    }
    //main method for verification
    public static void main(String[] args) {
        LessonDAO dao = new LessonDAO();
        Lesson lesson = new Lesson(1, 1, "title", "content", 1, "status", null, null); // created_at and updated_at are null
        System.out.println(dao.addLesson(lesson));
    }

}
