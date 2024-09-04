package data;

import model.PessoaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public boolean atualizar(Object ob) throws Exception {
        PessoaModel pm = new PessoaModel();
        if(ob instanceof PessoaModel) {
            pm = (PessoaModel) ob;
        }
        String sql = "UPDATE tbPessoas SET nome = ?, email = ?, senha = ?, telefone = ?, endereco = ?";
        try(PreparedStatement ps = getConexao().prepareStatement(sql)) {
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
    public ArrayList<Object> pesquisar(String pes) throws Exception {
        ArrayList<Object> dados = new ArrayList<>();
        return dados;
    }

    @Override
    public Object pesquisar(int id) throws Exception {
        return new Object();
    }
}
