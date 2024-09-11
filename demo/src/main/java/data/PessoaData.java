package data;

import model.PessoaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaData extends Conexao implements CRUD {

    @Override
    public boolean incluir(Object obj) throws Exception {
        PessoaModel pm = new PessoaModel();
        if(obj instanceof PessoaModel)
            pm = (PessoaModel) obj;
        String sql = "INSERT INTO tbPessoas (NOME, EMAIL, SENHA, TELEFONE, ENDERECO) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getEmail());
            ps.setString(3, pm.getSenha());
            ps.setString(4, pm.getTelefone());
            ps.setString(5, pm.getEndereco());

            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public boolean excluir(int id) throws Exception {
        String sql = "DELETE FROM tbPessoas WHERE ID = ?";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id);

            int upt = ps.executeUpdate();
            if(upt != 0) {
                System.out.println("Pessoa excluída");
                return true;
            }
            else return false;
        }
    }

    @Override
    public boolean atualizar(Object ob) throws Exception {
        PessoaModel pm = new PessoaModel();
        if(ob instanceof PessoaModel) {
            pm = (PessoaModel) ob;
        }
        String sql = "UPDATE tbPessoas SET nome = ?, email = ?, senha = ?, telefone = ?, endereco = ? WHERE id = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getEmail());
            ps.setString(3, pm.getSenha());
            ps.setString(4, pm.getTelefone());
            ps.setString(5, pm.getEndereco());
            ps.setInt(6, pm.getId());

            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }
    }

    public ArrayList<PessoaModel> pesquisar(String pesquisaNome) throws Exception {
        ArrayList<PessoaModel> dados = new ArrayList<>();

        String sql = "SELECT * FROM tbPessoas WHERE nome = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setString(1, pesquisaNome);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);
                String tel = rs.getString(5);
                String end = rs.getString(6);
                var pessoa = new PessoaModel(id, nome, email, senha, tel, end);
                dados.add(pessoa);
            }
        }
        return dados;
    }

    public Object pesquisar(int id) throws Exception {
        return new Object();
    }

    //SELECT
    public void selectPessoas(Connection conn) throws SQLException {
        String sql = "SELECT * FROM tbPessoas";

        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                System.out.printf("""
                        ID: %d | NOME: %s | EMAIL: %s | SENHA: %s | TEL: %s | END.: %s \n""",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        }
    }
}
