package lesufcg.almoxarifadovirtual.modelo.autenticacao;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Token")
@Table(name = "tb_token")
public class Token {

    private final int HORA_EM_MILISEGUNDOS = 3600000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String chave;

    @Column
    private Date expirationDate;

    @Column(unique = true)
    private Long usuarioId;

    public Token(Long usuarioId){
        setExpirationDate(new Date());
        getExpirationDate().setTime(System.currentTimeMillis() + HORA_EM_MILISEGUNDOS);
        setChave(UUID.randomUUID().toString());
        setUsuarioId(usuarioId);
    }

    public Token() {
    }

    public String getChave() {
        return chave;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}