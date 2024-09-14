package Module;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    // Manage the connection
    public Connection conn = null;

    // Constructor with parameters for MySQL
    public DBConnect(String URL, String username, String pass) {
        try {
            // Load the MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(URL, username, pass);
            System.out.println("Connected to MySQL database");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Default constructor for connecting to MySQL with default credentials
    public DBConnect() {
        this("jdbc:mysql://localhost:3306/your_database_name", "root", "12345678");
    }

    // Method to dispatch requests
    public void dispth(HttpServletRequest request, HttpServletResponse response, String page) {
        RequestDispatcher dispth = request.getRequestDispatcher(page);

        try {
            dispth.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to get data from the database
    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    // Method to return the connection
    public Connection getConnection() {
        return conn;
    }

    // Main method for testing connection
    public static void main(String[] args) {
        new DBConnect();  // This will call the default constructor and connect to MySQL
    }
}
