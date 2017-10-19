package sessao;

import dao.DAOCurso;
import dao.DAOUsuarioServidor;
import entidade.Curso;
import entidade.UsuarioServidor;

public class SessaoUsuarioServidor {

    public static void main(String[] args) {
        UsuarioServidor usuarioServidor = new UsuarioServidor();
        Curso curso = new Curso();
        DAOCurso daoCurso = new DAOCurso();

        usuarioServidor.setNome("João Paulo de Barros");
        usuarioServidor.setPerfil("Estagiário");
        usuarioServidor.setSenha("1234567");
        usuarioServidor.setStatus("Ativo");
        usuarioServidor.setTelefone("44 34223333");
        usuarioServidor.setCpf("000.111.222.333.44");
        usuarioServidor.setEmail("joaopaulobarros@gmail.com");
        usuarioServidor.setSetor("Administrativo");
        usuarioServidor.setSiape("1720650");
        
        Sessao sessao = new Sessao();
        try {
            sessao.iniciarTransacao();
            DAOUsuarioServidor daoUsuarioServidor = new DAOUsuarioServidor();
            daoUsuarioServidor.setSessao(sessao.get());
            daoCurso.setSessao(sessao.get());
                       
            curso = daoCurso.buscar(Curso.class,1L);
            usuarioServidor.setCurso(curso);
            
            daoUsuarioServidor.salvar(usuarioServidor);
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}