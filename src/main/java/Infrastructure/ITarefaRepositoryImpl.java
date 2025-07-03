/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domain.Tarefa;
import infrastructure.SqlImplementations.ConexaoHibernate;
import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ITarefaRepositoryImpl extends GenericRepository implements ITarefaRepository {

    @Override
    public List<Tarefa> listarTarefasPorBoard(UUID boardId) throws HibernateException {
        List<Tarefa> lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Tarefa> consulta = builder.createQuery(Tarefa.class);
            Root<Tarefa> tabela = consulta.from(Tarefa.class);

            Predicate restricoes = builder.equal(tabela.get("board").get("id"), boardId);

            consulta.where(restricoes);

            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null && sessao.isOpen()) {
                sessao.close();
            }
        }

        return lista;
    }

    public List<Tarefa> pesquisarTarefasPorNome(String pesq) throws HibernateException {

        List lista = null;
        Session sessao = null;

        String lower = pesq.toLowerCase();

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Tarefa.class);
            Root tabela = consulta.from(Tarefa.class);

            // Restrições
            Predicate restricoes = null;
            restricoes = builder.like(builder.lower(tabela.get("nome")), '%' + lower + '%');

            consulta.where(restricoes);

            // Executar a query
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }

        return lista;

    }

}
