package Stage2_070425_060625.Homework2.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

//Настройку и управление пулом соединений к БД
public class DatabaseConfig {
    private static final HikariConfig config = new HikariConfig(); //Объект в который передаем параметры (URL, логин, пароль, размер пула)
    private static final HikariDataSource ds; //Пул соединений

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/my_database");
        config.setUsername("postgres");
        config.setPassword("Sql");
        config.setMaximumPoolSize(10);

        ds = new HikariDataSource(config); //создаётся сам пул на основе конфига
    }

    //Метод позволяет получить пул соединений (DataSource) из других классов (например, в DAO). Это и есть основная точка входа
    public static DataSource getDataSource() {
        return ds;
    }
}
