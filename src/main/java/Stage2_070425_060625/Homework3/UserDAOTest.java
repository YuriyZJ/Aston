package Stage2_070425_060625.Homework3;

import Stage2_070425_060625.Homework2.dao.UserDAO;
import Stage2_070425_060625.Homework2.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserDAOTest{
    private UserDAO userDAO;


    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("test_database")
            .withUsername("test_postgres")
            .withPassword("test_Sql");


    @BeforeAll
    void setUp(){
        postgreSQLContainer.start();

        System.setProperty("TEST_URL", postgreSQLContainer.getJdbcUrl());
        System.setProperty("TEST_USERNAME", postgreSQLContainer.getUsername());
        System.setProperty("TEST_PASSWORD", postgreSQLContainer.getPassword());

        userDAO = new UserDAO();
    }

    @BeforeEach
    void cleanUp(){
        List<User> users = userDAO.getAllUsers();
        for (User user: users) {
            userDAO.deleteUser(user.getId());
        }
    }

    @Test
    void testAddUser(){
        User user = new User();
        user.setName("Alice1");
        user.setEmail("Ali@example1.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());

        userDAO.addUser(user);
        List<User> users = userDAO.getAllUsers();
        assertEquals(1, users.size());
        assertEquals("Alice1", users.get(0).getName());
        assertEquals("Ali@example1.com", users.get(0).getEmail());
        assertEquals(30, users.get(0).getAge());
    }

    @Test
    void testGetAllUsers(){
        User user = new User();
        user.setName("Alice2");
        user.setEmail("Ali@example2.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());

        userDAO.addUser(user);
        List<User> users = userDAO.getAllUsers();

        assertEquals(1, users.size());
    }

    @Test
    void testUpdateUser(){
        User user = new User();
        user.setName("Alice3");
        user.setEmail("Ali@example3.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());
        userDAO.addUser(user);

        User existingUser = userDAO.getAllUsers().get(0);
        existingUser.setName("AliceUpdate");
        userDAO.updateUser(existingUser);

        User updatedUser = userDAO.getAllUsers().get(0);
        assertEquals("AliceUpdate", updatedUser.getName());
        assertEquals("Ali@example3.com", updatedUser.getEmail());
        assertEquals(30, updatedUser.getAge());
    }

    @Test
    void testDeleteUser(){
        User user = new User();
        user.setName("Alice4");
        user.setEmail("Ali@example4.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());
        userDAO.addUser(user);

        User existingUser = userDAO.getAllUsers().get(0);
        userDAO.deleteUser(existingUser.getId());

        List<User> users = userDAO.getAllUsers();
        assertTrue(users.isEmpty());
    }
}
