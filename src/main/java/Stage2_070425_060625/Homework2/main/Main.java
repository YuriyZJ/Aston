package Stage2_070425_060625.Homework2.main;

import Stage2_070425_060625.Homework2.model.User;
import Stage2_070425_060625.Homework2.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Меню:");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Обновить пользователя");
            System.out.println("4. Удалить пользователя");
            System.out.println("5. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Возраст: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    user.setAge(age);
                    userService.addUser(user);
                }
                case 2 -> {
                    userService.listAllUsers();
                }
                case 3 -> {
                    System.out.print("ID пользователя для обновления: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Новое имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Новый email: ");
                    String email = scanner.nextLine();
                    System.out.print("Новый возраст: ");
                    int age = scanner.nextInt();

                    User user = new User();
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);
                    user.setAge(age);
                    userService.updateUsers(user);
                }
                case 4 -> {
                    System.out.print("ID пользователя для удаления: ");
                    int id = scanner.nextInt();
                    userService.deleteUser(id);
                }
                case 5 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный ввод. Введите данные повторно");
            }
        }

/*      //Тест 1
        UserService userService = new UserService();

        String tableName = "usersAston";
        String columns = "id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), age INT, createdDate TIMESTAMP";

        userService.addUser(new User(1, "Alice", "ALi@example.com", 30));
        userService.listAllUsers();*/

/*        //Тест 2
        UserService userService = new UserService();
        // создаю таблицу
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя новой таблицы (например: usersAston):");
        String tableName = scanner.nextLine();
        System.out.println("Введите структуру колонок (например: id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), age INT, createdDate TIMESTAMP): ");
        String columns = scanner.nextLine();
        scanner.close();

        //Hibernate не использует порядок полей в конструкторе или классе, чтобы расставить порядок колонок в таблице.
        //Он просто генерирует SQL с полями в алфавитном или логически-предопределённом порядке, или в том порядке, как они попали в метамодель.
        //Что бы создать таблицу в нужном порядке, тогда необходимо явно указать SQL через @Column и создать схему вручную
        userService.addUser(new User(1, "David", "Dav@gmail.com", 25));
        userService.addUser(new User(2, "Ibrahim", "Ibr@gmail.com",26));
        userService.addUser(new User(3, "Kate", "Kat@gmail.com",30));
        userService.addUser(new User(4, "Mask","Mas@gmail.com", 50));
        userService.addUser(new User(5, "Tramp","Tra@gmail.com", 70));

        userService.listAllUsers();
        System.out.println("После всех операций");

        userService.updateUsers(new User(2, "Ivan Update", "Ivan@gmail.com",100));

        userService.deleteUser(4);

        userService.listAllUsers();*/
    }
}
