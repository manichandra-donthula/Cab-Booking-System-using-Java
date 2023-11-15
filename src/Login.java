package src;

import javax.swing.*;

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
        String password = JOptionPane.showInputDialog("Enter your password:");
        String confirmPassword = JOptionPane.showInputDialog("Confirm your password:");

        // Add your logic for user registration here
        if (password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "User registered successfully with username: " + username);
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
