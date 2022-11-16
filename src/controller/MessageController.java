package controller;

import exception.MessageNotFoundException;
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
                messages.add(message);
                line = userText.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
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

    public List<Message> getAllMessages() {
        return messages;
    }

    public Message getMessageById(String id) {
        if (messages.size() == 0) {
            throw new MessageNotFoundException("Message could not found by id: " + id);
        }

        int index = -1;

        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getMessage_id().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new MessageNotFoundException("Message could not found by id: " + id);
        }

        return messages.get(index);
    }

    public UserController getUserController() {
        return userController;
    }
}
