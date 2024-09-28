package budget_app.data;

import budget_app.models.Transaction;
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
    private final String updateUserSql = """
            update users set firstname=? where user_id=?""";

    private final String insertUserTranxSql = """
            insert into transactions (user_id,account_id,category_id,
            currency,amount,transaction_type,notes) values (?,?,?,?,?,?,?)
            """;

    public void updateUser(User user, int user_id) {
        try (var conn = ConnectionDAO.getConnection();
             var pstmt = ConnectionDAO.runPreparedStatement(conn, updateUserSql)) {

            pstmt.setString(1, user.firstname());
            pstmt.setInt(2, user_id);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertUser(User user) {

        try (var conn = ConnectionDAO.getConnection();
             var pstmt = ConnectionDAO.runPreparedStatement(conn, insertUserSql)) {

            pstmt.setString(1, user.username());
            pstmt.setString(2, user.firstname());
            pstmt.setString(3, user.lastname());
            pstmt.setString(4, user.email());

            pstmt.executeUpdate();
            var resultSet = pstmt.getGeneratedKeys();
            return resultSet.next() ? resultSet.getInt(1) : 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectUser() {
        try (var conn = ConnectionDAO.getConnection();
             var pstmt = ConnectionDAO.runPreparedStatement(conn, selectUserSql)) {

            var resultSet = pstmt.executeQuery();
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

    public int insertUserTransaction(Transaction transaction) {

        try (var conn = ConnectionDAO.getConnection();
             var pstmt = ConnectionDAO.runPreparedStatement(conn, insertUserTranxSql)) {

            pstmt.setInt(1, transaction.userId());
            pstmt.setInt(2,transaction.accountId());
            pstmt.setInt(3,transaction.categoryId());
            pstmt.setString(4,transaction.currency());
            pstmt.setBigDecimal(5,transaction.amount());
            pstmt.setString(6,transaction.transType());
            pstmt.setString(7,transaction.notes());

            pstmt.executeUpdate();
            var resultSet = pstmt.getGeneratedKeys();
            return resultSet.next() ? resultSet.getInt(1) : 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
