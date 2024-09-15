package model;

import Entity.User;
import Module.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // CREATE: Add a new user to the database
    public boolean addUser(User user) {
        int n = 0;
        String sql = "INSERT INTO Users(username, email, password_hash, full_name)"
                + " VALUES(?, ?, ?, ?)";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getEmail());
            pre.setString(3, user.getPasswordhash()); // Ensure this is a hashed password
            pre.setString(4, user.getFullname());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // Get a user by ID
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPasswordhash(rs.getString("password_hash"));
                user.setFullname(rs.getString("full_name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    // UPDATE user
    public boolean updateUser(User user) {
        int n = 0;
        String sql = "UPDATE Users SET username = ?, email = ?, password_hash = ?, full_name = ? WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getEmail());
            pre.setString(3, user.getPasswordhash()); // Ensure this is a hashed password
            pre.setString(4, user.getFullname());
            pre.setInt(5, user.getId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // REMOVE user
    public boolean removeUser(int id) {
        int n = 0;
        String sql = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n > 0;
    }

    // GET all users
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = new DBConnect().getConnection()) {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPasswordhash(rs.getString("password_hash"));
                user.setFullname(rs.getString("full_name"));
                list.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // Main method to test the connection and data retrieval
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        // Example query to fetch data from a table (modify to your table name and columns)
        List<User> list = dao.getAllUser();
        for (User user : list) {
            System.out.println(user.getId() + " " + user.getUsername() + " " + user.getEmail() + " " + user.getPasswordhash() + " " + user.getFullname());
        }
        // Add user
        User user = new User();
        user.setUsername("user1");
        user.setEmail("user@gmail.com");
        user.setPasswordhash("123456"); // This should be a hashed password in real scenarios
        user.setFullname("User 1");
        dao.addUser(user);
    }
}
