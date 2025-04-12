package Stage2_070425_060625.Homework2.service;

import Stage2_070425_060625.Homework2.dao.UserDAO;
import Stage2_070425_060625.Homework2.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void createTable(String tableName, String columns) {
        try {
            userDAO.createTable(tableName, columns);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try{
           userDAO.addUser(user);
            System.out.println("User added successfully" + user.getName());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listAllUsers() {
        try {
            List<User> listAllUsers = userDAO.getAllUsers();
            System.out.println("List:");
            for (User user : listAllUsers) {
                System.out.println(user.getName() + " " + user.getEmail() + " " + user.getAge() + " " + user.getCreatedDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsers(User user) {
        try{
            userDAO.updateUser(user);
            System.out.println("User updated successfully" + user.getName());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try{
            userDAO.deleteUser(id);
            System.out.println("User deleted successfully" + id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
