import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CabBookingSystemGUI extends JFrame {
    private LoginPage loginPage;
    private JButton homeButton, bookingButton, contactUsButton, aboutButton, accountButton;
    private JPanel headerPanel, footerPanel, navigationPanel, contentPanel;

    public CabBookingSystemGUI() {
        // Set frame properties
        setTitle("Cab Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY); // Change header color to yellow
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50));
        headerPanel.setForeground(Color.BLACK); // Set text color to black
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setPreferredSize(new Dimension(getWidth(), 50));
        navigationPanel = new JPanel();
        contentPanel = new ImagePanel(); // Using custom JPanel for background image
        homeButton = new JButton("Home");
        bookingButton = new JButton("Booking");
        contactUsButton = new JButton("Contact Us");
        aboutButton = new JButton("About");
        accountButton = new JButton("Login/Sign Up");

        // Set layout for content panel
        contentPanel.setLayout(new BorderLayout());

        // Set layout for navigation panel
        navigationPanel.setLayout(new FlowLayout());
        navigationPanel.setOpaque(false);
        navigationPanel.add(homeButton);
        navigationPanel.add(bookingButton);
        navigationPanel.add(contactUsButton);
        navigationPanel.add(aboutButton);
        navigationPanel.add(accountButton);

        homeButton.setForeground(Color.red);
        bookingButton.setForeground(Color.red);
        contactUsButton.setForeground(Color.red);
        aboutButton.setForeground(Color.red);
        accountButton.setForeground(Color.red);

        // Set layout for header panel
        headerPanel.setOpaque(true);
        headerPanel.add(new JLabel("Welcome to Cab Booking System"));

        // Set layout for footer panel
        footerPanel.setOpaque(true);
        footerPanel.add(new JLabel("© 2023 Cab Booking System. All rights reserved."));

        // Add action listeners to buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for home button
                JOptionPane.showMessageDialog(null, "Navigate to Home");
            }
        });

        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for booking button
                JOptionPane.showMessageDialog(null, "Navigate to Booking");
            }
        });

        contactUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for contact us button
                JOptionPane.showMessageDialog(null, "Navigate to Contact Us");
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for about button
                JOptionPane.showMessageDialog(null, "Navigate to About");
            }
        });

        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for account button (login/sign up)
                loginPage.setVisible(true);
                
                //JOptionPane.showMessageDialog(null, "Navigate to Login/Sign Up");
            }
        });

        // Set layout for the frame
        setLayout(new BorderLayout());

        // Add panels to the frame
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(footerPanel, BorderLayout.SOUTH);
        contentPanel.add(navigationPanel, BorderLayout.CENTER);

        // Display the frame
        setContentPane(contentPanel);
        setVisible(true);
        loginPage = new LoginPage(this);
    }

    // Custom JPanel for background image
    private class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel() {
            // Load background image
            backgroundImage = new ImageIcon("Home.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Set look and feel to the system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Run the GUI on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CabBookingSystemGUI();
            }
        });
    }
}
