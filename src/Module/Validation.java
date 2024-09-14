package Module;

// Import required packages
import java.util.Scanner;

public class Validation {
    // Validate email
    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    // Validate phone number (10-11 digits)
    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[0-9]{10,11}$");
    }

    // Validate password at least 8 characters, at least 1 number
    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9]).{8,}$");
    }

    // Validate username
    public static boolean validateUsername(String username) {
        return username.matches("^[a-zA-Z0-9._-]{5,}$");
    }

    // Validate full name (only letters and spaces)
    public static boolean validateFullName(String fullName) {
        return fullName.matches("^[a-zA-Z ]{5,}$");
    }

    // Test validation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Email is valid: " + validateEmail(email));

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Phone number is valid: " + validatePhoneNumber(phoneNumber));

        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Password is valid: " + validatePassword(password));

        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Username is valid: " + validateUsername(username));

        System.out.println("Enter full name: ");
        String fullName = sc.nextLine();
        System.out.println("Full name is valid: " + validateFullName(fullName));
    }
}
