package controller;

import exception.MessageNotFoundException;
import jdk.jshell.execution.Util;
import model.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageController {
    private final List<Message> messages;
    private final UserController userController;

    public MessageController(UserController userController) {
        this.userController = userController;
        messages = new ArrayList<>();
        try{
            List<String> listToDecrypt = Utils.readInputFile("src/messages.data");
            for(String encryptedMessage: listToDecrypt){
                String decryptedMessage = Utils.decrypt(encryptedMessage);
                String[] items = decryptedMessage.split("-");
                Message message = new Message(items[0], items[1], items[2], userController.getUserByUsername(items[3]));
                messages.add(message);
            }

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }

    }

    public Message createMessage(String message_id, String content, String password, String receiverUsername){
        try{
            Message message = new Message(message_id,
                    content,
                    Utils.convertToHashedVersion(password),// store the hashed version of the password
                    userController.getUserByUsername(receiverUsername));
            messages.add(message);
            System.out.println(message);
            Utils.writeOutputFile(Utils.encrypt(message.toWriteOnFile()),"src/messages.data");// write on the file the encrypted version of the message values.
            return message;
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return null;
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
