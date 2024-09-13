import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // Create a new instance of MyConnection
        MyConnection myConnection  = new MyConnection();
//        MyConnection myConnection = new MyConnection();
        // Get a connection
        Connection con = myConnection.getConnection();
        if (con != null) {
            System.out.println("Connection established");
        } else {
            System.out.println("Connection failed");
        }
    }
}