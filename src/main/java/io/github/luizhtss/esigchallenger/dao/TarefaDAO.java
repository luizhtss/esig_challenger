package io.github.luizhtss.esigchallenger.dao;

import io.github.luizhtss.esigchallenger.models.Tarefa;
import io.github.luizhtss.esigchallenger.utils.FiltroTarefa;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TarefaDAO {

    private EntityManagerFactory entityManagerFactory;


    public TarefaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public void salvar(Tarefa tarefa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tarefa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void excluirTarefa(Tarefa tarefa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            if (!entityManager.contains(tarefa)) {
                // Se a entidade não está no estado "managed", busca-a do banco de dados
                tarefa = entityManager.find(Tarefa.class, tarefa.getNumero());
            }

            entityManager.remove(tarefa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void editarTarefa(Tarefa tarefa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tarefa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void concluirTarefa(Tarefa tarefa) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tarefa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public List<Tarefa> listarTarefas(FiltroTarefa filtro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder jpql = new StringBuilder("SELECT t FROM Tarefa t WHERE 1=1");
        boolean numeroSolicitado = filtro.getNumero() != null;
        boolean tituloDescricaoSolicitado = !StringUtils.isBlank(filtro.getTituloDescricao());
        boolean responsavelSolicitado = filtro.getResponsavel() != null;
        boolean situacaoSolicitada = filtro.getSituacao() != null;
        boolean deadlineSolicitado = filtro.getDeadline() != null;


        if (numeroSolicitado) {
            jpql.append(" AND t.numero = :numero");
        }

        if (tituloDescricaoSolicitado) {
            jpql.append(" AND (LOWER(t.titulo) LIKE LOWER(:titulo) OR LOWER(t.descricao) LIKE LOWER(:descricao))");
        }

        if (responsavelSolicitado) {
            jpql.append(" AND t.responsavel = :responsavel");
        }

        if (situacaoSolicitada) {
            jpql.append(" AND t.situacao = :situacao");
        }

        if (deadlineSolicitado){
            jpql.append(" AND t.deadline = :deadline");
        }

        TypedQuery<Tarefa> query = entityManager.createQuery(jpql.toString(), Tarefa.class);

        if (numeroSolicitado) {
            query.setParameter("numero", filtro.getNumero());
        }

        if (tituloDescricaoSolicitado) {
            query.setParameter("titulo", "%" + filtro.getTituloDescricao() + "%");
            query.setParameter("descricao", "%" + filtro.getTituloDescricao() + "%");
        }

        if (responsavelSolicitado) {
            query.setParameter("responsavel", filtro.getResponsavel());
        }

        if (situacaoSolicitada) {
            query.setParameter("situacao", filtro.getSituacao());
        }

        if (deadlineSolicitado){
            query.setParameter("deadline", filtro.getDeadline());
        }

        return query.getResultList();
    }
}

