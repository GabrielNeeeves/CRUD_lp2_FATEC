package data;

import model.PessoaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaData extends Conexao implements CRUD {

    @Override
    public boolean incluir(Object obj) throws Exception {
        PessoaModel pm = new PessoaModel();
        if(obj instanceof PessoaModel)
            pm = (PessoaModel) obj;
        String sql = "INSERT INTO tbPessoas VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, pm.getId());
            ps.setString(2, pm.getNome());
            ps.setString(3, pm.getEmail());
            ps.setString(4, pm.getSenha());
            ps.setString(5, pm.getTelefone());
            ps.setString(6, pm.getEndereco());

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
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public boolean atualizar(int id, Object ob) throws Exception {
        PessoaModel pm = new PessoaModel();
        if(ob instanceof PessoaModel) {
            pm = (PessoaModel) ob;
        }
        String sql = "UPDATE tbPessoas SET nome = ?, email = ?, senha = ?, telefone = ?, endereco = ? WHERE ID = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getEmail());
            ps.setString(3, pm.getSenha());
            ps.setString(4, pm.getTelefone());
            ps.setString(5, pm.getEndereco());
            ps.setInt(6, id);

            int upt = ps.executeUpdate();
            if(upt != 0) return true;
            else return false;
        }
    }

    @Override
    public ArrayList<Object> pesquisar(String pes) throws Exception {
        ArrayList<Object> dados = new ArrayList<>();
        return dados;
    }

    @Override
    public Object pesquisar(int id) throws Exception {
        return new Object();
    }

    //SELECT
    @Override
    public void select() throws Exception {
        String sql = "SELECT * FROM tbPessoas";
        try(PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                System.out.printf("""
                        ID: %d | NOME: %s | EMAIL: %s | SENHA: %s | TELEFONE: %s | ENDEREÇO: %s\n""",
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
