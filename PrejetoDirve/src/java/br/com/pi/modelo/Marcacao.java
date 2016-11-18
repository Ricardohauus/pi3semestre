package br.com.pi.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Marcacao implements Serializable {

    private static final long serialVersionUID = 6035003722282433431L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAMarcacao", nullable = true)
    private Integer id;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Medico medicoId = new Medico();

    @ManyToOne
    @JoinColumn(nullable = true, name = "Paciente_Marcacao")
    private Paciente pacienteId = new Paciente();

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Marcacao other = (Marcacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Marcacao() {
    }

    public Marcacao(Integer marcacaoId, Date dataHora) {
        this.id = marcacaoId;
        this.dataHora = dataHora;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        //  this.dataHora = Date.parse(this.dia)Date.parse("ÁS")+(Date.parse(this.horario));
        this.dataHora = dataHora;
    }

    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

}
