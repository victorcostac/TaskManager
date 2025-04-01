/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Domain.Board;
import Domain.User;
import Infrastructure.IBoardRepository;
import Infrastructure.IBoardRepositoryImpl;
import Infrastructure.ITaskRepository;
import Infrastructure.ITaskRepositoryImpl;
import Infrastructure.IUserRepository;
import Infrastructure.IUserRepositoryImpl;
import java.util.List;
import service.BoardService;
import service.TaskService;
import service.UserService;

/**
 *
 * @author Usuário
 */
public class DomainManager { // Gerenciador de domínio
    
    private final BoardService boardService;
    private final TaskService taskService;
    private final UserService userService;
    
    
    
    public DomainManager(){ //adicionar os throws depois  que fazer a integração com banco de dados
        IBoardRepository iBoardRepository = new IBoardRepositoryImpl();
        boardService = new BoardService(iBoardRepository);
        IUserRepository iUserdRepository = new IUserRepositoryImpl();
        userService = new UserService(iUserdRepository);
        ITaskRepository iTaskRepository = new ITaskRepositoryImpl();
        taskService = new TaskService(iTaskRepository);
    }
    
    public List<User> getUsers(){
        return userService.getUsers();
    }
    
    public void createUser(User user){
        userService.createUser(user);
    }
    
    public void createBoard(Board board) {
        boardService.createBoard(board);
    }
    
    public List<Board> getBoards(){
        return boardService.getBoards();
    }
    
    public void  deleteBoardById(Long boardId){
        boardService.deleteBoardById(boardId);
    } 
}
