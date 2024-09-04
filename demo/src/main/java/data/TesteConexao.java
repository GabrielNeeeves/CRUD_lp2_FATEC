package data;

import model.StatusModel;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {

        var conexao = new Conexao();
        var stData = new StatusData();

        StatusModel sm = new StatusModel();
        sm.setDescricao("Cancelado");

        try (Connection conn = conexao.getConexao()) {

//            stData.incluir(sm);
            stData.select(conn);

        } catch (SQLException e) {
            System.out.println("Erro na Main: "+e.getMessage());
        }
    }

}
