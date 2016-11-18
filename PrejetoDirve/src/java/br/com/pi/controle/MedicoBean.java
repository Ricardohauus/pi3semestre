package br.com.pi.controle;

import br.com.pi.dao.GenericDAO;

import br.com.pi.modelo.Medico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MedicoBean implements Serializable {

    private static final long serialVersionUID = -7263592628030475398L;

    private Medico medico = new Medico();
    private List<Medico> medicos = new ArrayList<>();   

    public MedicoBean() {
        medicos = new GenericDAO<>(Medico.class).listarTodos();

    }

    public boolean verificar() {
        boolean retorno = true;
        if (medico.getNome().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "NOME", "Não Informado"));
            retorno = false;
        }
        if (medico.getCrm().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CRM", "Não Informado"));
            retorno = false;
        }
        return retorno;
    }

    public String salvar() {
        if (this.verificar()) {
            new GenericDAO<>(Medico.class).salvar(medico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medico cadastrado com sucesso!"));
            medicos = new GenericDAO<>(Medico.class).listarTodos();
            medico = new Medico();
            return "medico_lista?faces-redirect=true";
        } else {
            return "/index?faces-redirect=true";
        }      
    }

    public String novoMedico() {
        medico = new Medico();
        return "formulario_medico?faces-redirect=true";
    }

    public String editar(Medico medico) {
        this.medico = medico;
        return "formulario_medico?faces-redirect=true";
    }

    public void prepararExclusao(Medico medico) {
        this.medico = medico;

    }

    public String excluir(Medico medico) {
        new GenericDAO<>(Medico.class).excluir(medico);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Medico Excluido!"));
        medicos = new GenericDAO<>(Medico.class).listarTodos();
        return "medico_lista?faces-redirect=true";
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

}
