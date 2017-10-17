package dao;

import entidade.Nivel;
import java.util.List;
import javax.persistence.EntityManager;

public class DAONivel {

    private EntityManager sessao;

    public void setSessao(EntityManager sessao) {
        this.sessao = sessao;
    }

    public Nivel salvar(Nivel nivel) {
        sessao.persist(nivel);
        return nivel;
    }

    public Nivel alterar(Nivel nivel) {
        return sessao.merge(nivel);
    }

    public void excluir(Nivel nivel) {
        sessao.remove(nivel);
    }

    public Nivel buscar(Class c, Long id) {
        return sessao.find(Nivel.class, id);
    }

    public List<Nivel> buscar() {
        return sessao.createQuery("from Nivel").getResultList();
    }
}
