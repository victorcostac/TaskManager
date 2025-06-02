/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domain.Usuario;
import infrastructure.SqlImplementations.ConexaoHibernate;
import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 2023122760093
 */
public class GenericRepository implements IGenericRepository{

    @Override
    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            sessao.save(obj);            
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
       
        
    }
 
    @Override
    public void alterar(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            sessao.update(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }        
        
            
    }
    
        
    @Override
    public void excluir(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            sessao.delete(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }       
        
    }
      
    
    @Override
    public List listar(Class classe) throws HibernateException {
        
        List lista = null;        
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from( classe );
            lista = sessao.createQuery(consulta).getResultList();
            
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }

        return lista;
    }


    // -----------------------------------------------
    // Se não existir no banco retorna NULL
    // -----------------------------------------------
    @Override
    public <T> T get(Class<T> clazz, UUID id) throws HibernateException {
        Session sessao = null;
        try {
            ConexaoHibernate.getSessionFactory().getCache().evict(Usuario.class, id);
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            T entity = sessao.get(clazz, id);
            return entity;
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            if (sessao != null && sessao.isOpen()) {
                sessao.close();
            }
        }
    }
    
    
    
    public <T> T merge(T obj) throws HibernateException {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            T mergedObj = (T) sessao.merge(obj); // Usa merge
            sessao.getTransaction().commit();
            return mergedObj; // Retorna a instância gerenciada
        } catch (HibernateException ex) {
            if (sessao != null && sessao.getTransaction().isActive()) {
                sessao.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (sessao != null && sessao.isOpen()) {
                sessao.close();
            }
        }
    }

}
