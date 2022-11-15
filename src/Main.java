import controller.MessageController;
import view.HomePage;

public class Main {
    public static void main(String[] args) {
        MessageController messageController = new MessageController();
        HomePage homePage = new HomePage(messageController);
    }
}