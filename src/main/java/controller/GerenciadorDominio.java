/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Board;
import domain.Proprietario;
import domain.Tarefa;
import domain.Usuario;
import infrastructure.GenericRepository;
import infrastructure.IBoardRepositoryImpl;
import infrastructure.ITarefaRepositoryImpl;
import infrastructure.IUserRepositoryImpl;
import infrastructure.SqlImplementations.ConexaoHibernate;

import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;

import service.BoardService;
import service.GenericService;
import service.TarefaService;
import service.UsuarioService;

/**
 *
 * @author Usuário
 */
public class GerenciadorDominio { // Gerenciador de domínio
    
    private final BoardService boardService;
    private final TarefaService tarefaService;
    private final UsuarioService usuarioService;
    private final GenericService genericService;
    
    
    
    public GerenciadorDominio() throws java.lang.ExceptionInInitializerError, HibernateException{ //adicionar os throws depois  que fazer a integração com banco de dados
        IBoardRepositoryImpl iBoardRepository = new IBoardRepositoryImpl();
        boardService = new BoardService(iBoardRepository);
        IUserRepositoryImpl iUserdRepository = new IUserRepositoryImpl();
        usuarioService = new UsuarioService(iUserdRepository);
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
    
    public List<Object> listar(Class classe){
        return genericService.listar(classe);
    }
    
    public void  deletar(Object obj){
        boardService.deletarBoard(obj);
    } 
    
    public Object get(Class classe, UUID id){
        return genericService.get(classe,id);
    }
    
    
    public Usuario findUsuarioComColecoes(UUID id) {
        return usuarioService.findUsuarioComColecoes(id);
    }
    
    public Proprietario findProprietarioComColecoes(UUID id) {
        return usuarioService.findProprietarioComColecoes(id);
    }
    
    public void promoverUsuarioParaProprietario(UUID id) {
        usuarioService.promoverUsuarioParaProprietario(id);
    }
    
    public List<Board> listarBoardsPorUsuario(UUID id) {
        return boardService.listarBoardsPorUsuario(id);
    }
    
    public List<Tarefa> listarTarefasPorBoard(UUID id) {
        return tarefaService.listarTarefasPorBoard(id);
    }
}
