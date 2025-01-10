package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI {
    private static JFrame frame;

    public static void main(String[] args) {
        // Create the frame
        frame = new JFrame("Book Library");
        frame.setLayout(null); // Set layout to null for absolute positioning
        frame.setSize(1300, 690); // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components to the frame
        addGuiComponent(frame);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void addGuiComponent(JFrame frame) {
        // Set up the image icon as a background
        ImageIcon losIcon = new ImageIcon(AdminGUI.class.getResource("/image/AdminGUI.png")); // Corrected path
        JLabel losLabel = new JLabel(losIcon);
        losLabel.setBounds(0, 0, 1300, 690);
        frame.add(losLabel);

        // Create buttons with transparent backgrounds and add ActionListeners
        JButton btnPendingRequest = createTransparentButton("");
        btnPendingRequest.setBounds(150, 300, 500, 60); // Adjusted position to match the image
        btnPendingRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                BookPending bookPending = new BookPending();
                bookPending.setSize(1300, 690);
                bookPending.setVisible(true);
            }
        });
        losLabel.add(btnPendingRequest);

        JButton btnBorrowedBook = createTransparentButton("");
        btnBorrowedBook.setBounds(670, 300, 500, 60); // Adjusted position to match the image
        btnBorrowedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                BorrowBookAdmin borrowBookAdmin = new BorrowBookAdmin();
                borrowBookAdmin.setSize(1300, 690);
                borrowBookAdmin.setVisible(true);
            }
        });
        losLabel.add(btnBorrowedBook);

        JButton btnAddBook = createTransparentButton("");
        btnAddBook.setBounds(150, 480, 500, 60); // Adjusted position to match the image
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                AddBook addBook = new AddBook();
                addBook.setSize(1300, 690);
                addBook.setVisible(true);
            }
        });
        losLabel.add(btnAddBook);

        JButton btnReturnedBook = createTransparentButton("");
        btnReturnedBook.setBounds(670, 480, 500, 60); // Adjusted position to match the image
        btnReturnedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                ReturnedBook returnedBook = new ReturnedBook();
                returnedBook.setSize(1300, 690);
                returnedBook.setVisible(true);
            }
        });
        losLabel.add(btnReturnedBook);

        // Create the Settings button
        JButton btnSettings = createTransparentButton("⚙"); // Settings icon as text
        btnSettings.setBounds(1200, 20, 50, 40); // Position of the Settings icon
        losLabel.add(btnSettings);

        // Create the Log Out button (initially invisible)
        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(1120, 70, 125, 45);
        btnLogOut.setVisible(false); // Initially hidden
        btnLogOut.setOpaque(true);
        btnLogOut.setBackground(Color.RED);
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.setFont(new Font("Arial", Font.BOLD, 14));
        losLabel.add(btnLogOut);

        // Add ActionListener to the Settings button to toggle Log Out button visibility
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogOut.setVisible(!btnLogOut.isVisible());
            }
        });

        // Add ActionListener to the Log Out button
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to log out?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    userDasboard dashboard = new userDasboard();
                    dashboard.setSize(1300, 690);
                    dashboard.setVisible(true);
                }
            }
        });
    }

    private static JButton createTransparentButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        return button;
    }
}