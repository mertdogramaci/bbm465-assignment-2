package view;

import controller.MessageController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessagePage {
    private final JFrame frame;
    private MessageController messageController;

    public MessagePage(String messageContent, MessageController messageController) {
        setMessageController(messageController);

        frame = new JFrame("Message");
        frame.setSize(500, 500);

        JTextArea messageArea = new JTextArea(messageContent, 10, 100);
        messageArea.setBounds(50, 50, 400, 300);
        messageArea.setEditable(false);
        frame.add(messageArea);

        JButton viewButton = new JButton("Return");
        viewButton.setBounds(150, 400, 200, 30);
        frame.add(viewButton);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReturn();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onReturn() {
        frame.setVisible(false);
        AccessPage accessPage = new AccessPage(messageController);
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }
}
