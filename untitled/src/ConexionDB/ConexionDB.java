package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB
{
    private static final String url = "jdbc:mysql://localhost:3306/CatalogoFunko";
    private static final String user = "root";
    private static final String password = "LucasCHA2001"; // Contraseña actualizar por la propia

    public static Connection getConnection(){
        Connection connection = null;
        try {
            System.out.println("Intentando conectar a la base de datos...");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return connection;
    }
}
