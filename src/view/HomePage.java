package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    private JFrame frame;

    public HomePage() {
        frame = new JFrame("Main Page");
        frame.setSize(400, 300);

        JLabel label = new JLabel("Welcome to MessageBox");
        label.setBounds(50, 40, 300, 30);
        label.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 24));
        frame.add(label);

        JButton accessButton = new JButton("Access");
        accessButton.setBounds(140, 130, 100, 30);
        frame.add(accessButton);

        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAccess();
            }
        });

        JButton leaveMessageButton = new JButton("Leave a message");
        leaveMessageButton.setBounds(120, 175, 140, 45);
        frame.add(leaveMessageButton);

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onAccess() {
        frame.setVisible(false);
        AccessPage accessPage = new AccessPage();
    }
}
