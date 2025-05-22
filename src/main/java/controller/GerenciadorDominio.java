/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Board;
import domain.Usuario;
import infrastructure.IBoardRepositoryImpl;
import infrastructure.ITarefaRepositoryImpl;
import infrastructure.IUserRepositoryImpl;
import infrastructure.SqlImplementations.ConexaoHibernate;

import java.util.List;

import org.hibernate.HibernateException;

import service.BoardService;
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
    
    
    
    public GerenciadorDominio() throws java.lang.ExceptionInInitializerError, HibernateException{ //adicionar os throws depois  que fazer a integração com banco de dados
        IBoardRepositoryImpl iBoardRepository = new IBoardRepositoryImpl();
        boardService = new BoardService(iBoardRepository);
        IUserRepositoryImpl iUserdRepository = new IUserRepositoryImpl();
        usuarioService = new UserService(iUserdRepository);
        ITarefaRepositoryImpl iTaskRepository = new ITarefaRepositoryImpl();
        tarefaService = new TarefaService(iTaskRepository);

        ConexaoHibernate.getSessionFactory().openSession();

    }
    
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    
    public void criarUsuario(Usuario user){
        usuarioService.criarUsuario(user);
    }
    
    public void criarBoard(Board board) {
        boardService.criarBoard(board);
    }
    
    public List<Board> getBoards(){
        return boardService.getBoards();
    }
    
    public void  deletarBoard(Board board){
        boardService.deletarBoard(board);
    } 
}
