package src;

import javax.swing.*;
import java.sql.*;

public class Login {
    public static void performAction(String selectedOption) {
        switch (selectedOption) {
            case "Login":
                loginUser();
                break;
            case "Sign Up":
                registerUser();
                break;
            case "Admin Login":
                adminLogin();
                break;
            default:
                break;
        }
    }

    private static void loginUser() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");

        // Add your logic for user login here
        JOptionPane.showMessageDialog(null, "Logging in as user with username: " + username);
    }

    private static void registerUser() {
        String username = JOptionPane.showInputDialog("Enter your desired username:");
        String mobileNumber = JOptionPane.showInputDialog("Enter your mobile number:");
        String emailAddress = JOptionPane.showInputDialog("Enter your email address");
        String password = JOptionPane.showInputDialog("Enter your password:");
        String confirmPassword = JOptionPane.showInputDialog("Confirm your password");
    
        // Add your logic for user registration here
        if (password.equals(confirmPassword)) {
            try {
                Conn conn = new Conn();
                Statement stmt = conn.getConnection().createStatement();
    
                // Check if the table already exists
                DatabaseMetaData meta = conn.getConnection().getMetaData();
                ResultSet tables = meta.getTables(null, null, "SIGNUP", null);
                if (!tables.next()) {
                    // Create the table if it doesn't exist
                    stmt.executeUpdate("CREATE TABLE signup(Username VARCHAR(20), Password VARCHAR(20), MobileNumber varchar(12), EmailAddress VARCHAR(20))");
                }
    
                // Insert user data into the table
                String insertQuery = String.format("INSERT INTO signup VALUES('%s', '%s', '%s', '%s')", username, password, mobileNumber, emailAddress);
                stmt.executeUpdate(insertQuery);
    
                // Close the statement and connection
                conn.closeConnection(conn.getConnection(), stmt);
    
                JOptionPane.showMessageDialog(null, "User registered successfully with username: " + username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password confirmation failed. Please try again.");
        }
    }
    

    private static void adminLogin() {
        String adminUsername = JOptionPane.showInputDialog("Enter admin username:");
        String adminPassword = JOptionPane.showInputDialog("Enter admin password:");

        // Add your logic for admin login here
        if (isAdminValid(adminUsername, adminPassword)) {
            JOptionPane.showMessageDialog(null, "Logging in as admin with username: " + adminUsername);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid admin credentials. Please try again.");
        }
    }

    private static boolean isAdminValid(String adminUsername, String adminPassword) {
        // Add your logic to validate admin credentials
        // For example, you might check against a predefined admin username and password
        return adminUsername.equals("admin") && adminPassword.equals("admin123");
    }
}
