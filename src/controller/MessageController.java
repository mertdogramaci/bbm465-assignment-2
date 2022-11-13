package controller;

import model.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MessageController {
    private final List<Message> messages;
    private final UserController userController;

    public MessageController() {
        userController = new UserController();
        messages = new ArrayList<>();

        File userFile = new File("messages.data");
        try {
            BufferedReader userText = new BufferedReader(new FileReader(userFile));
            String line = userText.readLine();
            while (line != null) {
                String[] items = line.split("-");
                Message message = new Message(items[0], items[1], items[2], userController.getUserByUsername(items[3]));
                System.out.println(message);
                messages.add(message);
                line = userText.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message createMessage(String message_id, String content, String password, String receiverUsername) {
        Message message = new Message(message_id,
                content,
                password,
                userController.getUserByUsername(receiverUsername));
        messages.add(message);
        return message;
    }
}
