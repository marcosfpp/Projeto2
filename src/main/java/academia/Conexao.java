package academia;

/**
 * Classe para estabelecimento de conexao com o banco de dados.
 * @author Marcus Vinícius, Marcos Felipe, Dheniel Rodrigues, Kaua Luiz
 * since 25/12/2024 at 14:08 PM
 */
import java.sql.Connection;
import java.sql.DriverManager;


 /**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * 
 * As informações de conexão, como URL, usuário e senha, são configuradas nesta classe.
 */
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
