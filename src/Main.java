import controller.MessageController;
import controller.UserController;
import view.HomePage;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        MessageController messageController = new MessageController(userController);
        HomePage homePage = new HomePage(messageController);
    }
}
