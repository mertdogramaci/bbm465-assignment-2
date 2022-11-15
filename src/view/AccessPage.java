package view;

import javax.swing.*;

public class AccessPage {
    public AccessPage() {
        JFrame frame = new JFrame("Message View");
        frame.setSize(400, 500);

        JTextField textField = new JTextField(20);

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
