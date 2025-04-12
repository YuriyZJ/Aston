package Stage2_070425_060625.Homework2.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

//Настройка подключения к БД

public class DatabaseConfig {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/my_database");
        config.setUsername("postgres");
        config.setPassword("Sql");
        config.setMaximumPoolSize(10);

        ds = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
