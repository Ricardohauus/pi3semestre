package br.com.pi.controle;

import br.com.pi.dao.GenericDAO;
import br.com.pi.modelo.Horario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class HorarioBean implements Serializable {

    private static final long serialVersionUID = -7263592628030475398L;
    private Horario horario = new Horario();
    private List<Horario> horarios = new ArrayList<>();

    public HorarioBean() {
        horarios = new GenericDAO<>(Horario.class).listarTodos();        
    }

    public String salvar() {
        new GenericDAO<>(Horario.class).salvar(horario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Horario cadastrado com sucesso!"));
        horarios = new GenericDAO<>(Horario.class).listarTodos();
        horario = new Horario();
        return "horario_lista?faces-redirect=true";
    }

    public String editar(Horario horario) {
        this.horario = horario;
        return "formulario_horario?faces-redirect=true";
    }

    public void prepararExclusao(Horario horario) {
        this.horario = horario;
    }

    public String excluir(Horario horario) {
        new GenericDAO<>(Horario.class).excluir(horario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Horario Excluido"));
        horarios = new GenericDAO<>(Horario.class).listarTodos();
        return "horario_lista?faces-redirect=true";
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }


}
