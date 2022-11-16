package view;

import controller.MessageController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MessageRegister {
    private MessageController messageController;
    private final JFrame frame;
    private final JComboBox<String> userMenu;
    public MessageRegister(MessageController messageController) {
        setMessageController(messageController);

        frame = new JFrame("Register Form");
        frame.setSize(1000, 1000);

        // Message Codename Part
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

        userMenu = new JComboBox<String>(usernames);
        userMenu.setBounds(150, 40, 200, 30);
        frame.add(userMenu);
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }
}
