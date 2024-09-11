package data;

import model.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoData extends Conexao implements CRUD {

    @Override
    public boolean incluir(Object obj) throws Exception {
        ProdutoModel prodModel = new ProdutoModel();
        if(obj instanceof ProdutoModel) {
            prodModel = (ProdutoModel) obj;
        }
        String sql = "INSERT INTO tbProduto (DESCRICAO, PRECO, QUANTIDADE, IDSTATUS) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setString(1, prodModel.getDescricao());
            ps.setDouble(2, prodModel.getPreco());
            ps.setInt(3, prodModel.getQuantidade());
            ps.setInt(4, prodModel.getStatus());

            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }

    }

    @Override
    public boolean excluir(int idDel) throws Exception {
        String sql = "DELETE FROM tbProduto WHERE id = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setInt(1, idDel);

            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        ProdutoModel prodModel = new ProdutoModel();
        if(obj instanceof ProdutoModel) {
            prodModel = (ProdutoModel) obj;
        }
            String sql = "UPDATE tbProduto SET descricao = ?, preco = ?, quantidade = ?, idStatus = ? WHERE id = ?";
            try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
                ps.setString(1, prodModel.getDescricao());
                ps.setDouble(2, prodModel.getPreco());
                ps.setInt(3, prodModel.getQuantidade());
                ps.setInt(4, prodModel.getStatus());
                ps.setInt(5, prodModel.getId());

                int upt = ps.executeUpdate();
                if(upt != 0) return true;
                else return false;
        }
    }

    //SELECT
    public void selectProd(Connection conn) throws Exception {
        String sql = "SELECT * FROM tbProduto";
        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                System.out.printf("""
                        ID: %d | DESCRIÇÃO: %s | PREÇO: %s | QUANTIDADE: %s | STATUS: %d \n""",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        }
    }
}
