package data;

import model.StatusModel;

import java.util.ArrayList;
import java.util.List;

public interface CRUD {

    boolean incluir(Object obj) throws Exception;

    boolean excluir(int id) throws Exception;

    boolean atualizar(int id, Object obj) throws Exception;

    ArrayList<Object> pesquisar(String pesquisa) throws Exception;

    Object pesquisar(int id) throws Exception;

    //SELECT
    void select() throws Exception;

}
