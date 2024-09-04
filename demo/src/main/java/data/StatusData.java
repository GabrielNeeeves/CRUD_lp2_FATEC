package data;

import model.StatusModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatusData extends Conexao implements CRUD {

//    public StatusData() throws Exception{}

    @Override
    public boolean incluir(Object obj) throws SQLException {
        if(obj instanceof StatusModel) {
            StatusModel sm = (StatusModel) obj;
            String sql = "INSERT INTO tbstatus (descricao) VALUES (?)";
            try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
                ps.setString(1, sm.getDescricao());
                if(ps.executeUpdate() > 0) return true;
                else return false;
            }
        } else return false;
    }

    @Override
    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM tbstatus WHERE ID = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setInt(1, id);
            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public boolean atualizar(int id, Object obj) throws SQLException {
        if(obj instanceof StatusModel) {
            StatusModel st = (StatusModel) obj;
            String sql = "UPDATE tbstatus SET DESCRICAO = ? WHERE id = ?";
            try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
                ps.setString(1, st.getDescricao());
                ps.setInt(2, st.getId());
                int upt = ps.executeUpdate();
                if(upt != 0) return true;
                else return false;
            }
        } else return false;

    }

    @Override
    public ArrayList<Object> pesquisar(String pesquisa) throws SQLException {
        ArrayList<Object> dados = new ArrayList<>();
        return dados;
    }

    @Override
    public StatusModel pesquisar(int id) throws SQLException {
        StatusModel obj = new StatusModel();
        return obj;
    }

    //SELECT
    @Override
    public void select() throws Exception {
        String sql = "SELECT * FROM tbStatus";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                System.out.printf("""
                        ID: %s | DESCRIÇÃO: %s \n""",
                        rs.getInt(1),
                        rs.getString(2));
            }
        }
    }

}
