package Module;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Input {
    Validation validation = new Validation();

    public Input() {
    }

    public String inputEmail() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter email: ");
            String email = sc.nextLine();
            if (validation.validateEmail(email)) {
                return email;
            } else {
                System.out.println("Invalid email format");
                return inputEmail();
            }
        } catch (Exception e) {
            System.out.println("Invalid email format");
            return inputEmail();
        }
    }

    public String inputPhoneNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter phone number: ");
            String phoneNumber = sc.nextLine();
            if (validation.validatePhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("Invalid phone number format");
                return inputPhoneNumber();
            }
        } catch (Exception e) {
            System.out.println("Invalid phone number format");
            return inputPhoneNumber();
        }
    }

    public String inputPassword() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            if (validation.validatePassword(password)) {
                return password;
            } else {
                System.out.println("Invalid password format");
                return inputPassword();
            }
        } catch (Exception e) {
            System.out.println("Invalid password format");
            return inputPassword();
        }
    }

    public String inputUsername() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            if (validation.validateUsername(username)) {
                return username;
            } else {
                System.out.println("Invalid username format");
                return inputUsername();
            }
        } catch (Exception e) {
            System.out.println("Invalid username format");
            return inputUsername();
        }
    }

    public String inputFullName() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter full name: ");
            String fullName = sc.nextLine();
            if (validation.validateFullName(fullName)) {
                return fullName;
            } else {
                System.out.println("Invalid full name format");
                return inputFullName();
            }
        } catch (Exception e) {
            System.out.println("Invalid full name format");
            return inputFullName();
        }
    }
// test
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println("Email: " + input.inputEmail());
        System.out.println("Phone number: " + input.inputPhoneNumber());
        System.out.println("Password: " + input.inputPassword());
        System.out.println("Username: " + input.inputUsername());
        System.out.println("Full name: " + input.inputFullName());
    }
}
