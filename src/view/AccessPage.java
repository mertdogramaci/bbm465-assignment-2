package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessPage {
    JFrame frame;

    public AccessPage() {
        frame = new JFrame("Message View");
        frame.setSize(400, 500);

        // Message Codename Part
        JLabel codename = new JLabel("Message Codename");
        codename.setBounds(20, 40, 300, 30);
        codename.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(codename);

        JTextField codenameInput = new JTextField(20);
        codenameInput.setBounds(150, 40, 200, 30);
        frame.add(codenameInput);

        // Message Password Part
        JLabel password = new JLabel("Message Password");
        password.setBounds(20, 80, 300, 30);
        password.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(password);

        JTextField passwordInput = new JTextField(20);
        passwordInput.setBounds(150, 80, 200, 30);
        frame.add(passwordInput);

        // Separator Part
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(10, 120, 350, 20);
        separator.setBackground(Color.black);
        frame.add(separator);

        // Username Part
        JLabel username = new JLabel("Username");
        username.setBounds(20, 130, 300, 30);
        username.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(username);

        JTextField usernameInput = new JTextField(20);
        usernameInput.setBounds(150, 130, 200, 30);
        frame.add(usernameInput);

        // User Password Part
        JLabel userPassword = new JLabel("User Password");
        userPassword.setBounds(20, 170, 300, 30);
        userPassword.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(userPassword);

        JTextField userPasswordInput = new JTextField(20);
        userPasswordInput.setBounds(150, 170, 200, 30);
        frame.add(userPasswordInput);

        // View Button Part
        JButton viewButton = new JButton("VIEW");
        viewButton.setBounds(80, 300, 100, 30);
        frame.add(viewButton);

        // Reset Button Part
        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(200, 300, 100, 30);
        frame.add(resetButton);

        // Home Button Part
        JButton homeButton = new JButton("HOME");
        homeButton.setBounds(150, 350, 100, 30);
        frame.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onHome();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onHome() {
        frame.setVisible(false);
        HomePage homePage = new HomePage();
    }
}
