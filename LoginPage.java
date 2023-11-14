import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage(CabBookingSystemGUI mainGUI) {
        setTitle("Login - Cab Booking System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize components
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Placeholder for spacing
        loginPanel.add(loginButton);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder logic for login (replace with actual login logic)
                handleLogin();

                // Close the login page
                dispose();

                // Show the main GUI
                mainGUI.setVisible(true);
            }
        });

        // Set layout for the login frame
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void handleLogin() {
        // Placeholder logic for login (replace with actual login logic)
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Display a message (replace with actual login logic)
        JOptionPane.showMessageDialog(this, "Login Successful!\nUsername: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
