package sessao;

import dao.DAOCurso;
import dao.DAOTurma;
import entidade.Curso;
import entidade.Turma;

public class SessaoTurma {

    public static void main(String[] args) {
        Turma turma = new Turma();     
        Curso curso = new Curso();
        
        DAOTurma daoTurma = new DAOTurma();
        DAOCurso daoCurso = new DAOCurso();
        
        Sessao sessao = new Sessao();
        daoTurma.setSessao(sessao.get());
        daoCurso.setSessao(sessao.get());
        
        turma.setAno(2015);
        
        try {
            sessao.iniciarTransacao();
            curso = daoCurso.buscar(Curso.class, 1L);
            turma.setCurso(curso);               
                    
            daoTurma.salvar(turma);
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}