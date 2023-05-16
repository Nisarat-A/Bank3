import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankConnection {
    public static Connection connect(){
        String databaseURL = "jdbc:mysql://127.0.0.1:3306/bankapp";
        String username = "root" ;
        String password = "PASSwd12345";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(databaseURL, username, password);


        } catch (ClassNotFoundException e) {
            Logger.getLogger(BankConnection.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;}
}
