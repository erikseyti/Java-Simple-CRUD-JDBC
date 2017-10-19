package entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conteudo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConteudo;
    private String texto;
    private String imagem;
    private String tipo;
    private String dataPostagem;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioServidor usuarioServidor;

    public Long getIdConteudo() {
        return idConteudo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(String dataPostagem) {
        this.dataPostagem = dataPostagem;
    }   

    public UsuarioServidor getUsuarioServidor() {
        return usuarioServidor;
    }

    public void setUsuarioServidor(UsuarioServidor usuarioServidor) {
        this.usuarioServidor = usuarioServidor;
    }
}