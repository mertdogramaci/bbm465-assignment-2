package view;

import controller.MessageController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MessageRegister {
    private MessageController messageController;
    private final JFrame frame;
    private final JComboBox<String> userMenu;
    private boolean isPassword;
    private boolean isConfirmPassword;
    private boolean isCodename;
    private boolean isMessage;
    private String selectedUsername;
    public MessageRegister(MessageController messageController) {
        setMessageController(messageController);

        isPassword = false;
        isConfirmPassword = false;
        isCodename = false;
        isMessage = false;

        frame = new JFrame("Register Form");
        frame.setSize(800, 1000);

        // Auth. username Part
        JLabel username = new JLabel("Auth. username");
        username.setBounds(20, 40, 300, 30);
        username.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(username);

        List<User> users = messageController.getUserController().getAllUsers();
        int numberOfUsers = users.size();
        String[] usernames = new String[numberOfUsers];

        for (int i = 0; i < numberOfUsers; i++) {
            usernames[i] = users.get(i).getUsername();
        }

        userMenu = new JComboBox<>(usernames);
        userMenu.setBounds(150, 40, 200, 30);
        frame.add(userMenu);

        userMenu.addActionListener(e -> selectedUsername = String.valueOf(userMenu.getSelectedItem()));

        // Password Part
        JLabel password = new JLabel("Password");
        password.setBounds(20, 80, 300, 30);
        password.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(password);

        JTextField passwordInput = new JTextField(20);
        passwordInput.setBounds(150, 80, 200, 30);
        frame.add(passwordInput);

        // Confirm Password Part
        JLabel confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setBounds(400, 80, 300, 30);
        confirmPassword.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(confirmPassword);

        JTextField confirmPasswordInput = new JTextField(20);
        confirmPasswordInput.setBounds(530, 80, 200, 30);
        frame.add(confirmPasswordInput);

        // Codename Part
        JLabel codename = new JLabel("Message codename");
        codename.setBounds(20, 120, 300, 30);
        codename.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(codename);

        JTextField codenameInput = new JTextField(20);
        codenameInput.setBounds(150, 120, 200, 30);
        frame.add(codenameInput);

        // Message Entrance Part
        JLabel messageField = new JLabel("ENTER YOUR MESSAGE");
        messageField.setBounds(20, 300, 300, 30);
        messageField.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(messageField);

        JTextField message = new JTextField(20);
        message.setBounds(180, 180, 500, 300);
        frame.add(message);

        // Create Message Button Part
        JButton createMessageButton = new JButton("Create Message");
        createMessageButton.setBounds(80, 550, 150, 30);
        frame.add(createMessageButton);
        createMessageButton.setEnabled(false);

        createMessageButton.addActionListener(e -> onCreateMessage(
                codenameInput.getText(),
                message.getText(),
                passwordInput.getText(),
                selectedUsername
                ));

        // Home Button Part
        JButton homeButton = new JButton("HOME");
        homeButton.setBounds(300, 550, 100, 30);
        frame.add(homeButton);

        homeButton.addActionListener(e -> onHome());

        passwordInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (passwordInput.getText().length() > 0) {
                    isPassword = true;
                    if (isConfirmPassword &&
                            isCodename &&
                            isMessage &&
                            passwordInput.getText().equals(confirmPasswordInput.getText())) {
                        createMessageButton.setEnabled(true);
                    }
                } else {
                    createMessageButton.setEnabled(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        confirmPasswordInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (passwordInput.getText().equals(confirmPasswordInput.getText())) {
                    isConfirmPassword = true;
                    if (isPassword && isCodename && isMessage) {
                        createMessageButton.setEnabled(true);
                    }
                } else {
                    createMessageButton.setEnabled(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        codenameInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (codenameInput.getText().length() > 0) {
                    isCodename = true;
                    if (isPassword && isConfirmPassword && isMessage) {
                        createMessageButton.setEnabled(true);
                    }
                } else {
                    createMessageButton.setEnabled(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        message.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (message.getText().length() > 0) {
                    isMessage = true;
                    if (isPassword && isCodename && isConfirmPassword) {
                        createMessageButton.setEnabled(true);
                    }
                } else {
                    createMessageButton.setEnabled(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onHome() {
        frame.setVisible(false);
        HomePage homePage = new HomePage(messageController);
    }

    private void onCreateMessage(String messageId, String message, String password, String username) {
        messageController.createMessage(messageId, message, password, username);
        onHome();
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }
}
