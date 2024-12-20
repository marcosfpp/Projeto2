package academia;

/**
 *
 * @author Dheniel
 * @since 19/12/2024 21:00 PM
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/academia";
    public static final String USUARIO = "root";
    public static final String SENHA = "";

    public Connection getConexao() {
        try {
            return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
