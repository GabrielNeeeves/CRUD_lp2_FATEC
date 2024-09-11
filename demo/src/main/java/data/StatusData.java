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
            if(upt != 0) System.out.println("Status excluído");
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public boolean atualizar(Object obj) throws SQLException {
        if(obj instanceof StatusModel) {
            StatusModel st = (StatusModel) obj;
            String sql = "UPDATE tbstatus SET DESCRICAO = ? WHERE id = ?";
            try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
                ps.setString(1, st.getDescricao());
                ps.setInt(2, st.getId());
                int upt = ps.executeUpdate();
                if(upt != 0) {
                    System.out.println("Status atualizado");
                    return true;
                }
                else return false;
            }
        } else return false;

    }

    public ArrayList<StatusModel> pesquisar(String pesquisa) throws SQLException {
        ArrayList<StatusModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM tbStatus WHERE descricao LIKE ?";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, pesquisa+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt(1);
                String desc = rs.getString(2);
                StatusModel sm = new StatusModel(id, desc);

                lista.add(sm);
            }
            rs.close();
            return lista;
        }
    }

    public StatusModel pesquisar(int id) throws SQLException {
        StatusModel obj = new StatusModel();
        return obj;
    }

    //SELECT MEu
    public void select(Connection conn) throws SQLException {
        String sql = "SELECT * FROM tbstatus";
        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                int id = rs.getInt(1);
                String stts = rs.getString(2);
                System.out.printf("""
                        ID: %d | DESCRIÇÃO: %s \n""", id, stts);
            }
        }
    }

}
