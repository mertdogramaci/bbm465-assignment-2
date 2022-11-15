package view;

import controller.MessageController;
import model.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class AccessPage {
    private final JFrame frame;
    private final JTextField codenameInput;
    private MessageController messageController;
    private final JButton viewButton;

    private String messageContent;

    public AccessPage(MessageController messageController) {
        setMessageController(messageController);

        frame = new JFrame("Message View");
        frame.setSize(400, 500);

        // Message Codename Part
        JLabel codename = new JLabel("Message Codename");
        codename.setBounds(20, 40, 300, 30);
        codename.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(codename);

        codenameInput = new JTextField(20);
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

        // Show password checkbox part
        JCheckBox checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(160, 200, 200, 50);
        frame.add(checkBox);

        // View Button Part
        viewButton = new JButton("VIEW");
        viewButton.setBounds(80, 300, 100, 30);
        frame.add(viewButton);
        viewButton.setEnabled(false);

        viewButton.addActionListener(e -> onView());

        codenameInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                viewButton.setEnabled(false);
                List<Message> messages = getMessageController().getAllMessages();
                for (Message message : messages) {
                    if (codenameInput.getText().equals(message.getMessage_id())) {
                        viewButton.setEnabled(true);
                        messageContent = message.getContent();
                        break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        // Reset Button Part
        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(200, 300, 100, 30);
        frame.add(resetButton);

        // Home Button Part
        JButton homeButton = new JButton("HOME");
        homeButton.setBounds(150, 350, 100, 30);
        frame.add(homeButton);

        homeButton.addActionListener(e -> onHome());

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onHome() {
        frame.setVisible(false);
        HomePage homePage = new HomePage(messageController);
    }

    private void onView() {
        frame.setVisible(false);
        MessagePage messagePage = new MessagePage(messageContent, messageController);
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }
}
