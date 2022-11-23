package view;

import controller.MessageController;

import javax.swing.*;
import java.awt.*;

public class HomePage {
    private MessageController messageController;
    private final JFrame frame;

    public HomePage(MessageController messageController) {
        setMessageController(messageController);

        frame = new JFrame("Main Page");
        frame.setSize(400, 300);

        JLabel label = new JLabel("Welcome to MessageBox");
        label.setBounds(50, 40, 300, 30);
        label.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 24));
        frame.add(label);

        JButton accessButton = new JButton("Access");
        accessButton.setBounds(140, 100, 100, 30);
        frame.add(accessButton);

        accessButton.addActionListener(e -> onAccess());

        JButton leaveMessageButton = new JButton("Leave a message");
        leaveMessageButton.setBounds(120, 145, 140, 45);
        frame.add(leaveMessageButton);

        leaveMessageButton.addActionListener(e -> onLeaveMessage());

        JButton createUserButton = new JButton("Create an User");
        createUserButton.setBounds(120, 205, 140, 45);
        frame.add(createUserButton);

        createUserButton.addActionListener(e -> onCreateUser());

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onAccess() {
        frame.setVisible(false);
        AccessPage accessPage = new AccessPage(messageController);
    }

    private void onCreateUser(){
        frame.setVisible(false);
        UserRegister userRegister = new UserRegister(messageController);
    }

    private void onLeaveMessage() {
        frame.setVisible(false);
        MessageRegister messageRegister = new MessageRegister(messageController);
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }
}
