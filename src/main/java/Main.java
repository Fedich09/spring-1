import config.AppConfig;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("Bob");
        User user1 = new User();
        user1.setName("Alice");
        userService.add(user);
        userService.add(user1);
        System.out.println(userService.listUsers());
    }
}
