package controller;

import exception.UserNotFoundException;
import model.User;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final List<User> users;

    public UserController() {
        users = new ArrayList<>();
        try{
            List<String> listToDecrypt = Utils.readInputFile("src/users.data");
            for(String encryptedUser: listToDecrypt){
                String decryptedUser = Utils.decrypt(encryptedUser);
                String[] items = decryptedUser.split("-");
                User user = new User(items[0],items[1]);
                users.add(user);
            }

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
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

    public void createUser(String username,String userPassword){
        try{
            User user = new User(username, Utils.convertToHashedVersion(userPassword));// store the hashed version of the password)
            users.add(user);
            Utils.writeOutputFile(Utils.encrypt(user.toWriteOnFile()),"src/users.data");// write on the file the encrypted version of the message values.

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
