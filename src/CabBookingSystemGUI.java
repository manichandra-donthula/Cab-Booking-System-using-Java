package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CabBookingSystemGUI extends JFrame {
    private JButton homeButton, bookingButton, contactUsButton, aboutButton;
    private JComboBox<String> accountComboBox;
    private JPanel headerPanel, footerPanel, navigationPanel, contentPanel;

    public CabBookingSystemGUI() {
        // Set frame properties
        setTitle("Cab Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50));
        headerPanel.setForeground(Color.BLACK);
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setPreferredSize(new Dimension(getWidth(), 50));
        navigationPanel = new JPanel();
        contentPanel = new ImagePanel();
        homeButton = new JButton("Home");
        bookingButton = new JButton("Booking");
        contactUsButton = new JButton("Contact Us");
        aboutButton = new JButton("About");
        String[] accountOptions = {"Login", "Sign Up", "Admin Login"};
        accountComboBox = new JComboBox<>(accountOptions);

        // Set layout for content panel
        contentPanel.setLayout(new BorderLayout());

        // Set layout for navigation panel
        navigationPanel.setLayout(new FlowLayout());
        navigationPanel.setOpaque(false);
        navigationPanel.add(homeButton);
        navigationPanel.add(bookingButton);
        navigationPanel.add(contactUsButton);
        navigationPanel.add(aboutButton);
        navigationPanel.add(accountComboBox);

        homeButton.setForeground(Color.black);
        bookingButton.setForeground(Color.black);
        contactUsButton.setForeground(Color.black);
        aboutButton.setForeground(Color.black);
        accountComboBox.setForeground(Color.black);

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
                Home.performAction();
            }
        });

        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking.performAction();
            }
        });

        contactUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactUs.performAction();
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About.performAction();
            }
        });

        accountComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) accountComboBox.getSelectedItem();
                Login.performAction(selectedOption);
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
    }

    private class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel() {
            backgroundImage = new ImageIcon("img/Home.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CabBookingSystemGUI();
            }
        });
    }
}
