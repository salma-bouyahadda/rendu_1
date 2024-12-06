import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon{
    public static  Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/gestion_evenements";
        String utilisateur = "root";
        String pass = "";
        return DriverManager.getConnection(url, utilisateur, pass);
        
    }
}

