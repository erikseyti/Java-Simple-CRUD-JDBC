package sessao;

import banco.Fabrica;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Sessao {
    private EntityManager sessao;
    private EntityTransaction transacao;

    public Sessao() {
        sessao = Fabrica.get().createEntityManager();
        transacao = sessao.getTransaction();
    }
    
    public void iniciarTransacao(){
        transacao.begin();
    }
    
    public void confirmaTransacao(){
        transacao.commit();
    }
    
    public void cancelarTransacao(){
        transacao.rollback();
    }
    
    public EntityManager get(){
        return sessao;
    }
}