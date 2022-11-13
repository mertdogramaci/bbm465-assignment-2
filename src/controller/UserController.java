package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final List<User> users;

    public UserController() {
        users = new ArrayList<>();

        File userFile = new File("users.data");
        try {
            BufferedReader userText = new BufferedReader(new FileReader(userFile));
            String line = userText.readLine();
            while (line != null) {
                String[] items = line.split("-");
                User user = new User(items[0], items[1]);
                users.add(user);
                line = userText.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return users;
    }
}
