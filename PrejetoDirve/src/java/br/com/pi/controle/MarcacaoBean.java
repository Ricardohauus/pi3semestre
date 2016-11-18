package br.com.pi.controle;

import br.com.pi.dao.GenericDAO;
import br.com.pi.modelo.Marcacao;
import br.com.pi.modelo.Medico;
import br.com.pi.modelo.Paciente;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MarcacaoBean implements Serializable {

    private static final long serialVersionUID = -7263592628030475398L;
    
    private Marcacao marcacao = new Marcacao();
    private List<Medico> medicosList = new ArrayList<>();
    private List<Paciente> pacienteList = new ArrayList<>();
    private List<Marcacao> marcacoes = new ArrayList<>();

    public MarcacaoBean() {
        marcacoes = new GenericDAO<>(Marcacao.class).listarTodos();
        pacienteList = new GenericDAO<>(Paciente.class).listarTodos();
        medicosList = new GenericDAO<>(Medico.class).listarTodos();
    }

    public String salvar() {
        new GenericDAO<>(Marcacao.class).salvar(marcacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta marcada com sucesso!"));
        marcacoes = new GenericDAO<>(Marcacao.class).listarTodos();
        marcacao = new Marcacao();
        return "marcacao_lista?faces-redirect=true";
    }

    public String novoMarcacao() {
        marcacao = new Marcacao();
        return "formulario_marcacao?faces-redirect=true";
    }

    public String editar(Marcacao marcacao) {
        this.marcacao = marcacao;
        return "formulario_marcacao?faces-redirect=true";
    }

    public String excluir(Marcacao marcacao) {
        new GenericDAO<>(Marcacao.class).excluir(marcacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Marcação Cancelada"));
        marcacoes = new GenericDAO<>(Marcacao.class).listarTodos();
        return "marcacao_lista?faces-redirect=true";
    }
    
    private String cpfCliente;

    public Marcacao getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(Marcacao marcacao) {
        this.marcacao = marcacao;
    }

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes) {
        this.marcacoes = marcacoes;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public List<Medico> getMedicosList() {

        return medicosList;
    }

    public void setMedicosList(List<Medico> medicosList) {
        this.medicosList = medicosList;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }
    public String getDataAtual() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
       public String getHoraAtual() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }
}
