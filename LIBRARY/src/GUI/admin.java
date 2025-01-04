package GUI;
public class admin {
    public static void main(String args[]){
        System.out.print("Try 2");
=======
import javax.swing.*;

public class admin extends JFrame {
    public admin(String title) {
        // The main GUI panel
        super(title);
        setSize(1300, 690);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        setResizable(false);

        getContentPane().setBackground(java.awt.Color.LIGHT_GRAY);
    }

    public static void main(String[] args) {
        // Create an instance of the admin class
        admin adminWindow = new admin("Admin Panel");

        // Make the window visible
        adminWindow.setVisible(true);
>>>>>>> upstream/main
    }
}
