package br.com.pi.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 6035003722282433431L;
    @Column (nullable = true)
    private String avaliacao;
    @Column (nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idAtendimento",nullable = true)
    private Integer id;
    @OneToOne
    @JoinColumn
    Marcacao marcacao = new Marcacao();
    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atendimento(String avaliacao, Date dataHora, Integer atendimentoId) {
        this.avaliacao = avaliacao;
        this.dataHora = dataHora;
        this.id = atendimentoId;
    }

    public Atendimento() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.avaliacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.avaliacao, other.avaliacao)) {
            return false;
        }
        return true;
    }

    public Marcacao getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(Marcacao marcacao) {
        this.marcacao = marcacao;
    }

}
