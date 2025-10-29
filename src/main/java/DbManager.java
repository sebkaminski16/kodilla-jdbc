import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {
    INSTANCE;

    private final Connection connection;

    DbManager() {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        connectionProperties.put("password", "root");
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/learning_sql_again" +
                            "?serverTimeZone=Europe/Warsaw" +
                            "&useSSL=False&allowPublicKeyRetrieval=true", connectionProperties);
        } catch (SQLException sqlException) {
            throw new ExceptionInInitializerError(sqlException);
        }
    }

    public static DbManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
