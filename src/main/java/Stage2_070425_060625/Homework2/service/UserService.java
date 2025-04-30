package Stage2_070425_060625.Homework2.service;

import Stage2_070425_060625.Homework2.dao.UserDAO;
import Stage2_070425_060625.Homework2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

//Отвечает за логику работы с пользователями, для взаимодействия между Main и UserDAO, абстрагирует вызовы к UserDAO
public class UserService {
    private final UserDAO userDAO;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        logger.info("Attempt to add a user: {}", user.getName());
        userDAO.addUser(user);
        logger.info("User added successfully: {}", user.getName());
    }

    public void listAllUsers() {
        logger.info("A list of all users has been requested");
        List<User> listAllUsers = userDAO.getAllUsers();
        logger.info("Получено {} пользователей", listAllUsers.size());
        for (User user : listAllUsers) {
            System.out.println(user.getName() + " " + user.getEmail() + " " + user.getAge() + " " + user.getCreatedDate());
        }
    }

    public void updateUsers(User user) {
        logger.info("Attempt to update a user: {}", user.getName());
        userDAO.updateUser(user);
        logger.info("User updated successfully: {}", user.getName());
    }

    public void deleteUser(int id) {
        logger.info("Attempt to delete a user: {}", id);
        userDAO.deleteUser(id);
        logger.info("User deleted successfully: {}", id);
    }
}
