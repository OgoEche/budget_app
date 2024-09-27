package budget_app.services;

import budget_app.data.UserDAO;
import budget_app.models.User;

public class UserService {
    private User user;
    private static  UserDAO userDAO = new UserDAO();

    public UserService(User user) {
        this.user = user;

    }

    public static int addUser(User userdata) {
        return userDAO.insertUser(userdata);
    }

    public static void updateUser(String user) {
        userDAO.selectUser();
    }

    public void deleteUser(String user) {

    }
}
