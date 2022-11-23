package view;

import controller.MessageController;

import javax.swing.*;

public class MessagePage {
    private final JFrame frame;
    private MessageController messageController;

    public MessagePage(String messageId, MessageController messageController) {
        setMessageController(messageController);

        frame = new JFrame("Message");
        frame.setSize(500, 500);

        StringBuilder message = new StringBuilder("");
        for (int i = 0; i < messageController.getMessageById(messageId).getContent().length(); i++) {
            if (i % 60 == 0) {
                message.append("\n").append(messageController.getMessageById(messageId).getContent().charAt(i));
            } else {
                message.append(messageController.getMessageById(messageId).getContent().charAt(i));
            }
        }

        JTextArea messageArea = new JTextArea(String.valueOf(message));
        messageArea.setBounds(50, 50, 400, 300);
        messageArea.setEditable(false);
        frame.add(messageArea);

        JButton viewButton = new JButton("Return");
        viewButton.setBounds(150, 400, 200, 30);
        frame.add(viewButton);

        viewButton.addActionListener(e -> onReturn());

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
