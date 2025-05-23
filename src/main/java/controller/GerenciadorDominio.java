/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Board;
import domain.Usuario;
import infrastructure.GenericRepository;
import infrastructure.IBoardRepositoryImpl;
import infrastructure.ITarefaRepositoryImpl;
import infrastructure.IUserRepositoryImpl;
import infrastructure.SqlImplementations.ConexaoHibernate;

import java.util.List;

import org.hibernate.HibernateException;

import service.BoardService;
import service.GenericService;
import service.TarefaService;
import service.UserService;

/**
 *
 * @author Usuário
 */
public class GerenciadorDominio { // Gerenciador de domínio
    
    private final BoardService boardService;
    private final TarefaService tarefaService;
    private final UserService usuarioService;
    private final GenericService genericService;
    
    
    
    public GerenciadorDominio() throws java.lang.ExceptionInInitializerError, HibernateException{ //adicionar os throws depois  que fazer a integração com banco de dados
        IBoardRepositoryImpl iBoardRepository = new IBoardRepositoryImpl();
        boardService = new BoardService(iBoardRepository);
        IUserRepositoryImpl iUserdRepository = new IUserRepositoryImpl();
        usuarioService = new UserService(iUserdRepository);
        ITarefaRepositoryImpl iTaskRepository = new ITarefaRepositoryImpl();
        tarefaService = new TarefaService(iTaskRepository);
        GenericRepository genericRepository = new GenericRepository();
        genericService = new GenericService(genericRepository);

        ConexaoHibernate.getSessionFactory().openSession();

    }
    
    
    public void alterar(Object obj){
        genericService.alterar(obj);
    }
    
    public void criar(Object obj) {
        genericService.criar(obj);
    }
    
    public List<Board> listar(Class calsse){
        return genericService.listar(calsse);
    }
    
    public void  deletar(Object obj){
        boardService.deletarBoard(obj);
    } 
}
