package dao;

import entidade.UsuarioAluno;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOUsuarioAluno {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao){
            this.sessao = sessao;
    }
    
    public UsuarioAluno salvar(UsuarioAluno usuarioAluno) {
        sessao.persist(usuarioAluno);
        return usuarioAluno;
    }
    
    public UsuarioAluno alterar(UsuarioAluno usuarioAluno){
        return sessao.merge(usuarioAluno);
    }
    
    public void excluir (UsuarioAluno usuarioAluno){
        sessao.remove(usuarioAluno);
    }
    
    public UsuarioAluno buscar (Class c, Long id){
    return sessao.find(UsuarioAluno.class, id);
    }
    
    public List<UsuarioAluno> buscar(){
        return sessao.createQuery("from UsuarioAluno").getResultList();
    }
}