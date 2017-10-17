package sessao;

import dao.DAONivel;
import entidade.Nivel;

public class SessaoNivel {

    public static void main(String[] args) {
        Nivel nivel = new Nivel();
        
        nivel.setNomeNivel("Superior");
                
        Sessao sessao = new Sessao();
        try {
            sessao.iniciarTransacao();
            DAONivel dao = new DAONivel();
            dao.setSessao(sessao.get());
            dao.salvar(nivel);
            
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}