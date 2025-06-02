/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domain.Proprietario;
import domain.Usuario;
import infrastructure.SqlImplementations.ConexaoHibernate;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author Usuario
 */
public class IUserRepositoryImpl extends GenericRepository implements IUserRepository {

    public Usuario findUsuarioComColecoes(UUID id) {
        Usuario usuario = null;
        Session session = null; // Ou EntityManager em JPA
        Transaction tx = null;

        try {
            // Substitua pela sua forma de obter a Session/EntityManager
            session = ConexaoHibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Passo 1: Buscar a entidade Usuario principal
            usuario = session.get(Usuario.class, id); // Simples 'get'

            if (usuario != null) {
                // Passo 2: Inicializar as coleções explicitamente.
                // Isso fará com que o Hibernate execute consultas separadas para cada coleção,
                // mas somente se elas não tiverem sido carregadas ainda e a sessão estiver ativa.
                if (usuario.getTarefasDesignadas() != null) {
                    Hibernate.initialize(usuario.getTarefasDesignadas());
                }
                if (usuario.getBoards() != null) {
                    Hibernate.initialize(usuario.getBoards());
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Logar o erro ou relançar uma exceção customizada
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }
    
    
        public Proprietario findProprietarioComColecoes(UUID id) {
        Proprietario proprietario = null;
        Session session = null; // Ou EntityManager em JPA
        Transaction tx = null;

        try {
            // Substitua pela sua forma de obter a Session/EntityManager
            session = ConexaoHibernate.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Passo 1: Buscar a entidade Usuario principal
            proprietario = session.get(Proprietario.class, id); // Simples 'get'

            if (proprietario != null) {
                // Passo 2: Inicializar as coleções explicitamente.
                // Isso fará com que o Hibernate execute consultas separadas para cada coleção,
                // mas somente se elas não tiverem sido carregadas ainda e a sessão estiver ativa.
                if (proprietario.getTarefasDesignadas() != null) {
                    Hibernate.initialize(proprietario.getTarefasDesignadas());
                }
                if (proprietario.getBoards() != null) {
                    Hibernate.initialize(proprietario.getBoards());
                }
                if (proprietario.getBoardsDesignados()!= null) {
                    Hibernate.initialize(proprietario.getBoardsDesignados());
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Logar o erro ou relançar uma exceção customizada
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return proprietario;
    }

    public void promoverUsuarioParaProprietario(UUID usuarioId) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Usando Native SQL para atualizar a coluna discriminadora
            // Certifique-se que 'usuario' é o nome correto da sua tabela
            // e 'TIPO_ENTIDADE' o nome correto da sua coluna discriminadora.
            String sql = "UPDATE usuario SET TIPO_ENTIDADE = 'PROPRIETARIO' WHERE id = :id";
            Query query = sessao.createNativeQuery(sql);
            query.setParameter("id", usuarioId.toString()); // UUIDs geralmente são passados como String para uuid-char
            query.executeUpdate();

            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null && sessao.getTransaction().isActive()) {
                sessao.getTransaction().rollback();
            }
            throw ex; // Re-lança a exceção para ser tratada externamente
        } finally {
            if (sessao != null && sessao.isOpen()) {
                sessao.close();
            }
        }
    }
}
