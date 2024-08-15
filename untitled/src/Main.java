import ConexionDB.gestionFunko;
import POJO.Funko;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        //Test database
        gestionFunko gestion = new gestionFunko();
        gestion.testConexion();

    }
}