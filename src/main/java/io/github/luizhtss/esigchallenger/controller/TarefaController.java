package io.github.luizhtss.esigchallenger.controller;

import io.github.luizhtss.esigchallenger.dao.TarefaDAO;
import io.github.luizhtss.esigchallenger.models.enums.Prioridade;
import io.github.luizhtss.esigchallenger.models.Tarefa;
import io.github.luizhtss.esigchallenger.models.enums.Situacao;
import io.github.luizhtss.esigchallenger.utils.FiltroTarefa;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class TarefaController implements Serializable {
    private Tarefa tarefa;
    private FiltroTarefa filtroTarefa;
    private List<String> pessoas;
    private List<Situacao> situacaoList;
    private TarefaDAO tarefaDAO;

    public TarefaController(){
        tarefa = new Tarefa();
        filtroTarefa = new FiltroTarefa();
        tarefaDAO = new TarefaDAO();
        setPessoas(Arrays.asList("João", "Antônio", "Maria", "José", "Pedro", "Ana", "Luiz", "Paulo", "Carlos", "Lucas"));
        situacaoList = Arrays.asList(Situacao.values());
    }

    public void cadastrar() {
        try {
            tarefaDAO.salvar(tarefa);
            tarefa = new Tarefa();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa cadastrada com sucesso!", null));
        }catch (Exception exception){
            exception.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar a tarefa. Por favor, tente novamente.", null));
        }
    }

    public void excluir(Tarefa tarefa){
        try {
            tarefaDAO.excluirTarefa(tarefa);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa excluída com sucesso!", null));
        }catch (Exception exception){
            exception.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir a tarefa. Por favor, tente novamente.", null));
        }
    }

    public void concluir(Tarefa tarefa){
        try {
            tarefa.setSituacao(Situacao.CONCLUIDA);
            tarefaDAO.editarTarefa(tarefa);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa concluída com sucesso!", null));
        }catch (Exception exception){
            exception.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao concluir a tarefa. Por favor, tente novamente.", null));
        }
    }

    public void editar(Tarefa tarefa){
        try {
            tarefaDAO.editarTarefa(tarefa);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarefa editada com sucesso!", null));
        }catch (Exception exception){
            exception.printStackTrace();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar a tarefa. Por favor, tente novamente.", null));
        }
    }

    public void selecionarTarefa(Tarefa tarefa){
        this.tarefa = tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefaDAO.listarTarefas(filtroTarefa);
    }

    public FiltroTarefa getFiltroTarefa() {
        return filtroTarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<String> getPessoas() {
        return pessoas;
    }

    public List<Situacao> getSituacaoList() {
        return situacaoList;
    }

    public void setPessoas(List<String> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Prioridade> getPrioridades() {
        return Arrays.asList(Prioridade.values());
    }
}
