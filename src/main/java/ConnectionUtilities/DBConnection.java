package ConnectionUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final static String URL = "jdbc:mysql://localhost:3306/registros_led?serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}
