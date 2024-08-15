package ConexionDB;

import POJO.Funko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gestionFunko
{
    public void testConexion() {
        String sql = "SELECT * FROM Funkos LIMIT 1";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Conexión a la tabla Funkos es exitosa, primer Funko encontrado: " + resultSet.getString("nombre"));
            } else {
                System.out.println("Conexión a la tabla Funkos es exitosa, pero no se encontraron registros.");
            }

        } catch (SQLException error) {
            System.err.println("Error al acceder a la tabla Funkos: " + error.getMessage());
        }
    }

    public List<Funko> getFunkos(){
        List<Funko> funkos = new ArrayList<>();
        String sql = "SELECT * FROM Funkos";

        try(Connection connection = ConexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Funko funko = new Funko();
                funko.setId(resultSet.getInt("id"));
                funko.setNombre(resultSet.getString("nombre"));
                funko.setCategoria(resultSet.getString("categoria"));
                funko.setFranquicia(resultSet.getString("franquicia"));
                funko.setActivo(resultSet.getBoolean("activo"));
                funkos.add(funko);
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return funkos;
    }
}
