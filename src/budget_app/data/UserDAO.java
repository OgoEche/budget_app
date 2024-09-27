package budget_app.data;

import budget_app.models.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    // private Connection conn = ConnectionDAO.getConnection();
    private final String insertUserSql = """
            insert into users (username,firstname,lastname,email) values (?,?,?,?)
            """;
    private final String selectUserSql = """
            select * from users
            """;

    public int insertUser(User user) {

        try (var conn = ConnectionDAO.getConnection();
             var stmt = ConnectionDAO.runPreparedStatement(conn, insertUserSql)) {

            stmt.setString(1,user.username());
            stmt.setString(2,user.firstname());
            stmt.setString(3,user.lastname());
            stmt.setString(4,user.email());

            stmt.executeUpdate();
            var resultSet = stmt.getGeneratedKeys();
            return resultSet.next() ? resultSet.getInt(1) : 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectUser() {
        try (var conn = ConnectionDAO.getConnection();
             var stmt = ConnectionDAO.runPreparedStatement(conn, selectUserSql)) {

            var resultSet = stmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                System.out.println(resultSet.getString("username") + ", " +
                        resultSet.getString("firstname") + ", " +
                        resultSet.getString("lastname") + ", " +
                        resultSet.getString("email"));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
