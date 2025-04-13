package Stage2_070425_060625.Homework2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

//Хранение данных пользователя
@Entity //помечает класс как сущность БД. Он должен иметь конструктор безаргументов и быть открытым для наследования или наследоваться от другого класса.
@Table(name = "usersAston") //задает имя таблицы (по умолчанию совпадает с именем класса)
public class User {

    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент (зависит от БД), используется в сочетании с @Id и указывает, что значение первичного ключа будет генерироваться автоматически.
    private int id;

    private String name;
    private String email;
    private int age;

    @Column(name = "created_at") //задает имя колонки
    private LocalDateTime createdDate = LocalDateTime.now();

    public User() { }

    public User(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.createdDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
