package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningmanagementsystem", "root", "12345678");

            // If connected successfully
            System.out.println("Connected to MySQL database");

        } catch (ClassNotFoundException e) {
            // Handle error if MySQL driver class not found
            System.out.println("MySQL Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL errors
            System.out.println("Failed to connect to the MySQL database");
            e.printStackTrace();
        }
    }
}
