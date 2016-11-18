package br.com.pi.controle;

import br.com.pi.dao.GenericDAO;
import br.com.pi.modelo.Atendimento;
import br.com.pi.modelo.Marcacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
/* Recomendo pelo PrimeFaces, Quando Está utilizando uma 
tela ele cria um Bean, quando sair dessa tela e ir para outra tela, 
ele destroi esse Bean */
public class AtendimentoBean implements Serializable {

    private static final long serialVersionUID = -7263592628030475398L;
    /*Esse número é utilizado para saber se o objeto que estamos recuperando 
    é de uma versão “compatível” com a versão da classe que foi utilizada quando serializamos o objeto: 
    em outras palavras, os arquivos .class não precisam ser necessariamente os mesmos para que o 
    processo de serialização ocorra com sucesso.      
     */
    private Atendimento atendimento = new Atendimento();
    private List<Atendimento> atendimentos = new ArrayList<>();
    private List<Marcacao> marcacoesList = new ArrayList<>();

    public AtendimentoBean() {
        atendimentos = new GenericDAO<>(Atendimento.class).listarTodos();
        marcacoesList = new GenericDAO<>(Marcacao.class).listarTodos();
    }

    public String salvar() {
        if (verificar()) {
            new GenericDAO<>(Atendimento.class).salvar(atendimento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atendimento cadastrado com sucesso!"));
            atendimentos = new GenericDAO<>(Atendimento.class).listarTodos();
            atendimento = new Atendimento();
            return "atendimento_lista?faces-redirect=true";

        } else {
            return "/index?faces-redirect=true";
        }
    }

    public String novoAtendimento() {
        atendimento = new Atendimento();
        return "formulario_atendimento?faces-redirect=true";
    }

    public String editar(Atendimento atendimento) {
        this.atendimento = atendimento;
        return "formulario_atendimento?faces-redirect=true";
    }

    public String excluir(Atendimento atendimento) {
        new GenericDAO<>(Atendimento.class).excluir(atendimento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Atendimento Cancelado"));
        atendimentos = new GenericDAO<>(Atendimento.class).listarTodos();
        return "atendimento_lista?faces-redirect=true";
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public List<Marcacao> getMarcacoesList() {
        return marcacoesList;
    }

    public void setMarcacoesList(List<Marcacao> marcacoesList) {
        this.marcacoesList = marcacoesList;
    }
    //Método de 
    public boolean verificar() {
        
        boolean retorno = true;

        if (atendimento.getAvaliacao().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Avaliação Nao Informada", "Por Favor, Informe!"));
            retorno = false;
        }
        if (atendimento.getDataHora() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Horário Não Informado", "Por Favor, Informe!"));
            retorno = false;
        }
        return retorno;

    }

}
