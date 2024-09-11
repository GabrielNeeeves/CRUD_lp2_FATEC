package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conn;

    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String usuario = "ganeves"; //postgres(note) ganeves(PC)
    static String pass = "rootadmin";

    public static Connection getConexao() throws SQLException {
        try {
            conn = DriverManager.getConnection(url, usuario, pass);
        } catch(SQLException e) {
            System.out.println("Erro "+e.getSQLState());
        } finally {
            return conn;
        }
    }

}
