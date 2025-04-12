package Stage2_070425_060625.Homework2.main;

import Stage2_070425_060625.Homework2.model.User;
import Stage2_070425_060625.Homework2.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // создаю таблицу
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя новой таблицы: users");
        String tableName = scanner.nextLine();

        System.out.println("Введите структуру колонок (например: id INT, name VARCHAR(100), age INT, city VARCHAR(100), salary DECIMAL:");
        String columns = scanner.nextLine();

            /*Запрос на создание
    CREATE TABLE users (
            id INT PRIMARY KEY,
            name VARCHAR(100),
            email VARCHAR(100),
            age INT,
            createdDate TIMESTAMP
    );*/

        userService.createTable(tableName, columns);

        scanner.close();

        // отрабатываю все методы
        userService.addUser(new User(1, "David", "Dav@gmail.com", 25, 10.04.));
        userService.addUser(new User(2, "Ibrahim", "Ibr@gmail.com",26, "Minsk"));
        userService.addUser(new User(3, "Kate", "Kat@gmail.com",30, "New York"));
        userService.addUser(new User(4, "Mask","Mas@gmail.com", 50, "Capitoliy"));
        userService.addUser(new User(5, "Tramp","Tra@gmail.com", 70, "Home"));

        userService.listAllUsers();
        System.out.println();

        userService.updateUsers(new User(3, "Ivan Update", 30, "Labrador", 10000));

        userService.deleteUser(4);

        userService.listAllUsers();
    }
}
