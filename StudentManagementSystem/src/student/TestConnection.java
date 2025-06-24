package student;
import java.sql.Connection;
import java.sql.SQLException;
public class TestConnection {
	public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}


