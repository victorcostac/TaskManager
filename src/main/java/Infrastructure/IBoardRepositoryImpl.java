/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domain.Board;
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

/**
 *
 * @author Usuario
 */

public class IBoardRepositoryImpl extends GenericRepository implements IBoardRepository { // EQUIVALENTE A UM DAO

    public IBoardRepositoryImpl() {
    }

    @Override
    public void adicionarTarefaNaLista(Tarefa task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletarTarefadaLista(Tarefa task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tarefa> getTarefasDoBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Board> listarBoardsPorUsuario(UUID usuarioId) throws HibernateException {
        List<Board> lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Board> consulta = builder.createQuery(Board.class);
            Root<Board> tabela = consulta.from(Board.class);

            Predicate restricoes = builder.equal(tabela.get("proprietario").get("id"), usuarioId);

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

    public List<Board> pesquisarBoardsPorNome(String pesq) throws HibernateException {

        List lista = null;
        Session sessao = null;

        String lower = pesq.toLowerCase();

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Board.class);
            Root tabela = consulta.from(Board.class);

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
