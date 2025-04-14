package Stage2_070425_060625.Homework2.dao;

import Stage2_070425_060625.Homework2.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

//Отвечает за выполнение SQL-запросов (этот слой изолирует логику работы с БД от остального кода.)
public class UserDAO {
    private final SessionFactory sessionFactory; //Создал фабрику сессий
    private static final Logger logger = LogManager.getLogger(UserDAO.class);

    public UserDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory(); // создали текущую сессию
    }

    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) { //Открыл новую сессию Hibernate
            transaction = session.beginTransaction(); //Начинаем транзакцию
            session.save(user); // Добавили User
            transaction.commit(); // Фиксируем транзакцию
            logger.info("User added successfully: {}", user.getName());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Если произойдёт исключение — откатываем изменения
            logger.error("Error when adding a user: " + e.getMessage(), e);
        }
    }

    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            List<User> users = session.createQuery("from User", User.class).list();
            logger.info("Получено {} пользователей из базы данных", users.size());
            return users;
        } catch (Exception e) {
            logger.error("Ошибка при получении всех пользователей: " + e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void updateUser(User updatedUser) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            User existingUser = session.get(User.class, updatedUser.getId());
            if (existingUser != null) {
                existingUser.setName(updatedUser.getName());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setAge(updatedUser.getAge());
                existingUser.setCreatedDate(updatedUser.getCreatedDate());
            }

            transaction.commit();
            logger.info("User updated successfully: {}", updatedUser.getName());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Error when updating a user: " + e.getMessage(), e);
        }
    }

    public void deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) session.remove(user);
            transaction.commit();
            logger.info("User deleted successfully: {}", user.getName());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            logger.error("Error when deleting a user: " + e.getMessage(), e);
        }
    }

/*      // через JDBC
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
    }*/
}
