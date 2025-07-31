import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {
    INSTANCE;

    private final Connection connection;

    DbManager() {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "kodilla_user");
        connectionProperties.put("password", "kodilla_Pass123");
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kodilla_course" +
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
