package sessao;

import dao.DAOConteudo;
import dao.DAOUsuarioServidor;
import entidade.Conteudo;
import entidade.UsuarioServidor;

public class SessaoConteudo {

    public static void main(String[] args) {
        Conteudo conteudo = new Conteudo();
        UsuarioServidor userServidor = new UsuarioServidor();
        
        DAOConteudo daoConteudo = new DAOConteudo();
        DAOUsuarioServidor daoUsuario = new DAOUsuarioServidor();
                
        Sessao sessao = new Sessao();
        
        daoConteudo.setSessao(sessao.get());
        daoUsuario.setSessao(sessao.get());
        
        conteudo.setDataPostagem("05/10/2017");
        conteudo.setImagem("c:/imagem.jpg");
        conteudo.setTexto("Bom dia queridos alunos!!!");
        conteudo.setTipo("Recado");   
        
        try {
            sessao.iniciarTransacao();
            userServidor = daoUsuario.buscar(UsuarioServidor.class, 1L);     
                
            conteudo.setUsuarioServidor(userServidor);
            daoConteudo.salvar(conteudo);
            
            sessao.confirmaTransacao();
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}