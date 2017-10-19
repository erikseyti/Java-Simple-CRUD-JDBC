package sessao;

import dao.DAOCurso;
import dao.DAONivel;
import entidade.Curso;
import entidade.Nivel;

public class SessaoCurso {

    public static void main(String[] args) {
        Curso curso = new Curso();   
        Nivel nivel = new Nivel();
        
        DAONivel daoNivel = new DAONivel();
        DAOCurso dao = new DAOCurso();
        
        Sessao sessao = new Sessao();
        daoNivel.setSessao(sessao.get());
        dao.setSessao(sessao.get());
        
        curso.setNomeCurso("TADS");
        curso.setPeriodo("3 anos");
        
                
        try {
            sessao.iniciarTransacao();    
            nivel = daoNivel.buscar(Nivel.class,1L);
            curso.setNivel(nivel);
            
            dao.salvar(curso);
            sessao.confirmaTransacao();
            
        } catch (Exception e) {
            e.printStackTrace();
            sessao.cancelarTransacao();
        }
    }
}