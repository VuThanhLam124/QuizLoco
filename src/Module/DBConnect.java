package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    private Connection conn = null;

    // Constructor to establish connection when the object is created
    public DBConnect() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningmanagementsystem", "root", "12345678");
            System.out.println("Connected to MySQL database");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the MySQL database");
            e.printStackTrace();
        }
    }

    // Function to fetch data from the database
    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            // Create a statement object to send SQL commands to the database
            Statement stmt = conn.createStatement();

            // Execute the query and get the result set
            rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("SQL query execution failed");
            e.printStackTrace();
        }
        return rs;
    }

    // Main method to test the connection and data retrieval
    public static void main(String[] args) {
        DBConnect db = new DBConnect();

        // Example query to fetch data from a table (modify to your table name and columns)
        String query = "SELECT * FROM users";

        // Call getData and retrieve the results
        ResultSet rs = db.getData(query);

        try {
            // Process the result set
            while (rs != null && rs.next()) {
                // Assuming the table has columns 'id' and 'name', modify based on your table structure
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
