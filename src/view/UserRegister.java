package view;

import controller.MessageController;
import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.util.List;
import java.util.LinkedList;

public class UserRegister {
    private final JFrame frame;
    private final JTextField username;
    private final JTextField userPassword;
    private UserController userController;
    private MessageController messageController;

    public UserRegister(MessageController messageController){
        setUserController(messageController.getUserController());
        setMessageController(messageController);

        frame = new JFrame("Message View");
        frame.setSize(400, 500);

        // Username Part
        JLabel codename = new JLabel("Username");
        codename.setBounds(20, 40, 300, 30);
        codename.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(codename);

        username = new JTextField(20);
        username.setBounds(150, 40, 200, 30);
        frame.add(username);

        // User Password Part
        JLabel password = new JLabel("User Password");
        password.setBounds(20, 80, 300, 30);
        password.setFont(new Font("PMN Caecilia Sans Head Black", Font.BOLD, 12));
        frame.add(password);

        userPassword = new JTextField(20);
        userPassword.setBounds(150, 80, 200, 30);
        frame.add(userPassword);

        // Create Button Part
        JButton createButton = new JButton("REGISTER");
        createButton.setBounds(180, 120, 100, 30);
        frame.add(createButton);

        createButton.addActionListener(e -> onCreateUser(username.getText(),userPassword.getText()));

        // Home Button Part
        JButton homeButton = new JButton("HOME");
        homeButton.setBounds(180, 160, 100, 30);
        frame.add(homeButton);

        homeButton.addActionListener(e -> onHome());

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void onCreateUser(String username, String userPassword){
        if((username.length()<1) || (userPassword.length()<1)){
            JOptionPane.showMessageDialog(frame, "Please enter valid password or username!","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(check(username)){
            userController.createUser(username,userPassword);
            onHome();
        }else{
            JOptionPane.showMessageDialog(frame, "This username has been used! Please change your username!","ERROR",JOptionPane.ERROR_MESSAGE);
            this.username.setText("");
        }

    }

    private void onHome() {
        frame.setVisible(false);
        HomePage homePage = new HomePage(messageController);
    }

    private boolean check(String username){
        List<User> users = userController.getAllUsers();
        for(User user : users){
            if (user.getUsername().equals(username)) return false;
        }
        return true;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
    public void setMessageController(MessageController messageController){
        this.messageController = messageController;
    }
}
