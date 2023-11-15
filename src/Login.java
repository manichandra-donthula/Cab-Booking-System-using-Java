package src;

import javax.swing.JOptionPane;

public class Login {
    public static void performAction(String selectedOption) {
        switch (selectedOption) {
            case "Login":
                JOptionPane.showMessageDialog(null, "Performing Login Option");
                // Add your Login option functionalities here
                break;
            case "Sign Up":
                JOptionPane.showMessageDialog(null, "Performing Sign Up Option");
                // Add your Sign Up option functionalities here
                break;
            case "Admin Login":
                JOptionPane.showMessageDialog(null, "Performing Admin Login Option");
                // Add your Admin Login option functionalities here
                break;
            default:
                break;
        }
    }
}
