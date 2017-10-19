package dao;

import entidade.UsuarioServidor;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOUsuarioServidor {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao){
            this.sessao = sessao;
    }
    
    public UsuarioServidor salvar(UsuarioServidor usuarioServidor) {
        sessao.persist(usuarioServidor);
        return usuarioServidor;
    }
    
    public UsuarioServidor alterar(UsuarioServidor usuarioServidor){
        return sessao.merge(usuarioServidor);
    }
    
    public void excluir (UsuarioServidor usuarioServidor){
        sessao.remove(usuarioServidor);
    }
    
    public UsuarioServidor buscar (Class c, Long id){
        return sessao.find(UsuarioServidor.class, id);
    }
    
    public List<UsuarioServidor> buscar(){
        return sessao.createQuery("from UsuarioServidor").getResultList();
    }
}