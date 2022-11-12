package view;

import javax.swing.*;
import java.awt.*;

public class MessageBoxGUI {


    public MessageBoxGUI() {
        HomePage();
    }

    private void HomePage() {
        JFrame frame = new JFrame("Main Page");
        frame.setSize(400, 300);

        JLabel label = new JLabel("Welcome to MessageBox");
        label.setBounds(50, 40, 300, 30);
        label.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 24));
        frame.add(label);

        JButton accessButton = new JButton("Access");
        accessButton.setBounds(140, 130, 100, 30);
        frame.add(accessButton);

        JButton leaveMessageButton = new JButton("Leave a message");
        leaveMessageButton.setBounds(120, 175, 140, 45);
        frame.add(leaveMessageButton);

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
