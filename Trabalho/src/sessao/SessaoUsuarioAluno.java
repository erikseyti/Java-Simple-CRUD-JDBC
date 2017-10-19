package sessao;

import dao.DAOCurso;
import dao.DAOUsuarioAluno;
import entidade.Curso;
import entidade.UsuarioAluno;

public class SessaoUsuarioAluno {
    public static void main(String[] args) {
        UsuarioAluno usuarioAluno = new UsuarioAluno();
        Curso curso = new Curso();
        
        DAOUsuarioAluno daoUsuarioAluno = new DAOUsuarioAluno();
        DAOCurso daoCurso = new DAOCurso();
        
        Sessao sessao = new Sessao();
        daoUsuarioAluno.setSessao(sessao.get());
        daoCurso.setSessao(sessao.get());

        usuarioAluno.setNome("Claudio Anderson Denadai");
        usuarioAluno.setPerfil("Aluno");
        usuarioAluno.setSenha("12345");
        usuarioAluno.setStatus("Ativo");
        usuarioAluno.setTelefone("44 3422-2222");
        usuarioAluno.setCpf("000.111.222.333.44");
        usuarioAluno.setEmail("claudiodenadai@gmail.com");
        usuarioAluno.setMatricula("1234567");
        
        try {
            sessao.iniciarTransacao();
            
            curso = daoCurso.buscar(Curso.class,1L);
            usuarioAluno.setCurso(curso);
            
            daoUsuarioAluno.salvar(usuarioAluno);
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}