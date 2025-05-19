/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Domain.Board;
import Domain.Usuario;
import Infrastructure.IBoardRepository;
import Infrastructure.IBoardRepositoryImpl;
import Infrastructure.ITarefaRepositoryImpl;
import Infrastructure.IUserRepository;
import Infrastructure.IUserRepositoryImpl;
import java.util.List;
import service.BoardService;
import service.TarefaService;
import service.UserService;
import Infrastructure.ITarefaRepository;

/**
 *
 * @author Usuário
 */
public class GerenciadorDominio { // Gerenciador de domínio
    
    private final BoardService boardService;
    private final TarefaService tarefaService;
    private final UserService usuarioService;
    
    
    
    public GerenciadorDominio(){ //adicionar os throws depois  que fazer a integração com banco de dados
        IBoardRepository iBoardRepository = new IBoardRepositoryImpl();
        boardService = new BoardService(iBoardRepository);
        IUserRepository iUserdRepository = new IUserRepositoryImpl();
        usuarioService = new UserService(iUserdRepository);
        ITarefaRepository iTaskRepository = new ITarefaRepositoryImpl();
        tarefaService = new TarefaService(iTaskRepository);
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
    
    public void  deletarBoardPorId(Long boardId){
        boardService.deletarBoardPorId(boardId);
    } 
}
