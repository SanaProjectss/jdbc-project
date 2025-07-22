import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerServices {

    public static void addCustomer(String name, String email, String phone) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";

        String sql = "INSERT INTO customer (name, email, phone) VALUES ('"
                + name + "', '" + email + "', '" + phone + "')";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println(" Customer added  " + update);

    }
    public static void addAccount(int customerId, String accountNumber, double balance) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";

        String sql = "INSERT INTO account (customer_id, account_number, balance) VALUES ("
                + customerId + ", '" + accountNumber + "', " + balance + ")";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println(" Account added " + update);

    }
    public static void depositMoney(int accountId, double amount) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String sql = "UPDATE account SET balance = balance + " + amount + " WHERE id = " + accountId;

        int update = statement.executeUpdate(sql);
        System.out.println(" Account deposited " + update);

    }
    public static void withdrawMoney(int accountId, double amount) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String sql = "UPDATE account SET balance = balance - " + amount + " WHERE id = " + accountId;

        int update = statement.executeUpdate(sql);
        System.out.println(" Account withdrawn " + update);
    }
    public static void transferMoney(int from, int to, double amount) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String withdrawSql = "UPDATE account SET balance = balance - " + amount + " WHERE id = " + from;
        String depositSql = "UPDATE account SET balance = balance + " + amount + " WHERE id = " + to;

        int withdrawResult = statement.executeUpdate(withdrawSql);
        int depositResult = statement.executeUpdate(depositSql);
        System.out.println(" Account transferred " + withdrawResult);

    }

    public static void deleteAccount(int id) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "root";
        String password = "root";

        String sql = "DELETE FROM account WHERE id = " + id;

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        int update = statement.executeUpdate(sql);
        System.out.println("Account deleted");

    }

}
