package controller;

import exception.UserNotFoundException;
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

    public User getUserByUsername(String username) {
        if (users.size() == 0) {
            throw new UserNotFoundException("User could not found by username: " + username);
        }

        int index = -1;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new UserNotFoundException("User could not found by username: " + username);
        }

        return users.get(index);
    }
}
