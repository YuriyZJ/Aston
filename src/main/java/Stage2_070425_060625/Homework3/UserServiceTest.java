package Stage2_070425_060625.Homework3;

import Stage2_070425_060625.Homework2.dao.UserDAO;
import Stage2_070425_060625.Homework2.model.User;
import Stage2_070425_060625.Homework2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class UserServiceTest{

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser(){
        User user = new User();
        user.setName("Alice1");
        user.setEmail("Alice1@gmail.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());

        userService.addUser(user);

        verify(userDAO, times(1)).addUser(user);
    }

    @Test
    void testListAllUsers(){
        when(userDAO.getAllUsers()).thenReturn(Collections.singletonList(new User()));

        userService.listAllUsers();

        verify(userDAO, times(1)).getAllUsers();
    }

    @Test
    void testUpdateUser(){
        User user = new User();
        user.setName("Alice3");
        user.setEmail("Alice3@gmail.com");
        user.setAge(30);
        user.setCreatedDate(LocalDateTime.now());

        userService.updateUsers(user);
        verify(userDAO, times(1)).updateUser(user);
    }

    @Test
    void testDeleteUser(){
        int userId = 1;

        userService.deleteUser(userId);

        verify(userDAO, times(1)).deleteUser(userId);
    }
}
