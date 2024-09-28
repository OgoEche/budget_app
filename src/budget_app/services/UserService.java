package budget_app.services;

import budget_app.data.UserDAO;
import budget_app.models.Transaction;
import budget_app.models.User;

import java.util.logging.Logger;

public class UserService {

    private final Logger logger = Logger.getLogger(UserService.class.getName());

    private User user;
    private static  UserDAO userDAO = new UserDAO();

    public UserService(User user) {
        this.user = user;

    }

    public static int addUser(User userdata) {
        return userDAO.insertUser(userdata);
    }

    public static void updateUser(User user, int userId) {
        userDAO.updateUser(user, userId);
    }

    public void deleteUser(String user) {

    }

    public static int addUserTransaction(Transaction transaction) {
        return userDAO.insertUserTransaction(transaction);
    }
}
