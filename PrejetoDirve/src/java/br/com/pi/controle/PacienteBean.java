package br.com.pi.controle;

import br.com.pi.dao.GenericDAO;
import br.com.pi.modelo.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PacienteBean implements Serializable {
    private static final long serialVersionUID = -7263592628030475398L;
    private Paciente paciente = new Paciente();
    private List<Paciente> pacientes = new ArrayList<>();
    
    public PacienteBean() {
        pacientes = new GenericDAO<>(Paciente.class).listarTodos();
    }

    public String salvar() {
        if (verificar()) {
            new GenericDAO<>(Paciente.class).salvar(paciente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente Cadastrado com sucesso!"));
            pacientes = new GenericDAO<>(Paciente.class).listarTodos();
            paciente = new Paciente();
            return "paciente_lista?faces-redirect=true";
        } else {
            return "formulario_paciente?faces-redirect=true";
        }
    }

    public boolean verificar() {
        boolean retorno = true;
        if (paciente.getNome().equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome Não Informado", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            retorno = false;
        }
        if (paciente.getCpf().equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Não Informado", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            retorno = false;
        }
        return retorno;
    }

    public String novoCliente() {
        paciente = new Paciente();
        return "formulario_paciente?faces-redirect=true";
    }

    public String editar(Paciente paciente) {
        this.paciente = paciente;

        return "formulario_paciente?faces-redirect=true";
    }

    public void prepararExclusao(Paciente paciente) {
        this.paciente = paciente;

    }

    public String excluir(Paciente paciente) {

        new GenericDAO<>(Paciente.class).excluir(paciente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Paciente Excluido"));
        pacientes = new GenericDAO<>(Paciente.class).listarTodos();
        return "paciente_lista?faces-redirect=true";
    }

    public String buscarCpf(String cpf) {
        new GenericDAO<>(Paciente.class).obterPorCpf(paciente.getCpf());

        return cpf;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
