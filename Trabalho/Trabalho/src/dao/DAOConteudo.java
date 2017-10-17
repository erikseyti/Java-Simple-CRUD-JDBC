package dao;

import entidade.Conteudo;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOConteudo {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao){
            this.sessao = sessao;
    }
    
    public Conteudo salvar(Conteudo conteudo) {
        sessao.persist(conteudo);
        return conteudo;
    }
    
    public Conteudo alterar(Conteudo conteudo){
        return sessao.merge(conteudo);
    }
    
    public void excluir (Conteudo conteudo){
        sessao.remove(conteudo);
    }
    
    public Conteudo buscar (Class c, int id){
    return sessao.find(Conteudo.class, id);
    }
    
    public List<Conteudo> buscar(){
        return sessao.createQuery("from Conteudo").getResultList();
    }
}