package data;

import model.StatusModel;

import java.util.ArrayList;

public interface CRUD {

    public boolean incluir(Object obj) throws Exception;

    public boolean excluir(int id) throws Exception;

    public boolean atualizar(Object obj) throws Exception;

    public ArrayList<Object> pesquisar(String pesquisa) throws Exception;

    public Object pesquisar(int id) throws Exception;

}
