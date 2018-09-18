
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Demo {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="123";
        Connection con=DriverManager.getConnection(url,username,password);

        Statement stat=con.createStatement();

    }
}
