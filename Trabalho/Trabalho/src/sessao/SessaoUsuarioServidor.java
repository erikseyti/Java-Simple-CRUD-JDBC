package sessao;

import dao.DAOUsuarioServidor;
import entidade.UsuarioServidor;

public class SessaoUsuarioServidor {

    public static void main(String[] args) {
        UsuarioServidor usuarioServidor = new UsuarioServidor();

        usuarioServidor.setNome("Rubens Vianna");
        usuarioServidor.setPerfil("Aluno");
        usuarioServidor.setSenha("12345");
        usuarioServidor.setStatus("Ativo");
        usuarioServidor.setTelefone("44 34226581");
        usuarioServidor.setCpf("000.111.222.333.44");
        usuarioServidor.setEmail("rubensvianna.rv@gmail.com");
        usuarioServidor.setSetor("Administrativo");
        usuarioServidor.setSiape("meu siape");
        
        Sessao sessao = new Sessao();
        try {
            sessao.iniciarTransacao();
            DAOUsuarioServidor dao = new DAOUsuarioServidor();
            dao.setSessao(sessao.get());
            dao.salvar(usuarioServidor);
            
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}