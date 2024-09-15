package model;
import Entity.BlogPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Module.DBConnect;

public class BlogPostDAO {
    //saveBlogPost method
    public void saveBlogPost(BlogPost blogPost) {
        String sql = "INSERT INTO blogposts (title, content, author_id, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, blogPost.getTitle());
            pstmt.setString(2, blogPost.getContent());
            pstmt.setInt(3, blogPost.getAuthorId());
            pstmt.setString(4, blogPost.getStatus());
            pstmt.setDate(5, new java.sql.Date(blogPost.getCreated_at().getTime()));
            pstmt.setDate(6, new java.sql.Date(blogPost.getUpdated_at().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //updateBlogPost method
    public void updateBlogPost(BlogPost blogPost) {
        String sql = "UPDATE blogposts SET title = ?, content = ?, author_id = ?, status = ?, updated_at = ? WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, blogPost.getTitle());
            pstmt.setString(2, blogPost.getContent());
            pstmt.setInt(3, blogPost.getAuthorId());
            pstmt.setString(4, blogPost.getStatus());
            pstmt.setDate(5, new java.sql.Date(blogPost.getUpdated_at().getTime()));
            pstmt.setInt(6, blogPost.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //deleteBlogPost method
    public void deleteBlogPost(int id) {
        String sql = "DELETE FROM blogposts WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //getBlogPost method
    public BlogPost getBlogPost(int id) {
        BlogPost blogPost = null;
        String sql = "SELECT * FROM blogposts WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogPost;
    }
    //main method
    public static void main(String[] args) {
        BlogPostDAO blogPostDAO = new BlogPostDAO();
        BlogPost blogPost = new BlogPost(1, "Title", "Content", 1, "Draft", new java.util.Date(), new java.util.Date());
        blogPostDAO.saveBlogPost(blogPost);
        blogPostDAO.updateBlogPost(blogPost);
        blogPostDAO.deleteBlogPost(1);
        blogPostDAO.getBlogPost(1);
    }
}
