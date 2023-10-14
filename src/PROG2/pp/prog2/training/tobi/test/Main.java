package pp.prog2.exercises.test;

/**
 * @author Paulina Pyczot
 * @date 22.06.2023
 **/

public class Main {
    public void start() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.getUser());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
