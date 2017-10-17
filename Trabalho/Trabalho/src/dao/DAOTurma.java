package dao;

import entidade.Turma;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOTurma {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao){
            this.sessao = sessao;
    }
    
    public Turma salvar(Turma turma) {
        sessao.persist(turma);
        return turma;
    }
    
    public Turma alterar(Turma turma){
        return sessao.merge(turma);
    }
    
    public void excluir (Turma turma){
        sessao.remove(turma);
    }
    
    public Turma buscar (Class c, int id){
    return sessao.find(Turma.class, id);
    }
    
    public List<Turma> buscar(){
        return sessao.createQuery("from Turma").getResultList();
    }
}