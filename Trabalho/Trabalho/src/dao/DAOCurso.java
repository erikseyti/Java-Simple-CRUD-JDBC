package dao;

import entidade.Curso;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOCurso {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao){
            this.sessao = sessao;
    }
    
    public Curso salvar(Curso curso) {
        sessao.persist(curso);
        return curso;
    }
    
    public Curso alterar(Curso curso){
        return sessao.merge(curso);
    }
    
    public void excluir (Curso curso){
        sessao.remove(curso);
    }
    
    public Curso buscar (Class c, Long id){
    return sessao.find(Curso.class, id);
    }
    
    public List<Curso> buscar(){
        return sessao.createQuery("from Curso").getResultList();
    }
}