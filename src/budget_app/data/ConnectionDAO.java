package budget_app.data;

import java.sql.*;


public class ConnectionDAO {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private static final String connectionString = "jdbc:mysql://localhost/budget_app?"
            + "user=root&password=251427"
            + "&useSSL=false&allowPublicKeyRetrieval=true";

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(connectionString);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        }
        return connection;
    }

    public static PreparedStatement runPreparedStatement(Connection conn, String isql) {
        try {
            preparedStatement = conn.prepareStatement(isql, Statement.RETURN_GENERATED_KEYS);
            return preparedStatement;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return preparedStatement;
    }
    
}
