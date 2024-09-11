package data;

public interface CRUD {

    public boolean incluir(Object obj) throws Exception;
    public boolean excluir(int id) throws Exception;
    public boolean atualizar(Object obj) throws Exception;
}
