package sessao;

import dao.DAOUsuarioAluno;
import entidade.UsuarioAluno;

public class SessaoUsuarioAluno {

    public static void main(String[] args) {
        UsuarioAluno usuarioAluno = new UsuarioAluno();

        usuarioAluno.setNome("Claudio Denadai");
        usuarioAluno.setPerfil("Aluno");
        usuarioAluno.setSenha("12345");
        usuarioAluno.setStatus("Ativo");
        usuarioAluno.setTelefone("44 34226581");
        usuarioAluno.setCpf("000.111.222.333.44");
        usuarioAluno.setEmail("rubensvianna.rv@gmail.com");
        usuarioAluno.setMatricula("1234567");
        
        Sessao sessao = new Sessao();
        try {
            sessao.iniciarTransacao();
            DAOUsuarioAluno dao = new DAOUsuarioAluno();
            dao.setSessao(sessao.get());
            dao.salvar(usuarioAluno);
            
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}