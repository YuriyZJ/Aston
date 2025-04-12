package Stage2_070425_060625.Homework2.dao;

import Stage2_070425_060625.Homework2.config.DatabaseConfig;
import Stage2_070425_060625.Homework2.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void createTable(String tableName, String columns) throws SQLException {
        String sql = "CREATE TABLE " + tableName + " (" + columns + ")";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
            System.out.println("Таблица '" + tableName + "' создана успешно!");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (id, name, email, age, createdDate) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getAge());
            ps.setTimestamp(5, Timestamp.valueOf(user.getCreatedDate()));
            ps.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age"),
                        rs.getTimestamp("createdDate").toLocalDateTime()));
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?,  age = ?, createdDate = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getAge());
            ps.setTimestamp(4, Timestamp.valueOf(user.getCreatedDate()));
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
