import controller.UserController;
import view.MessageBoxGUI;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        System.out.println(userController.getAllUsers());
        MessageBoxGUI messageBoxGUI = new MessageBoxGUI();
    }
}