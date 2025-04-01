/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Domain.Board;
import Infrastructure.IBoardRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class BoardService {
    private final IBoardRepository iBoardRepository;
    
    public BoardService(IBoardRepository iBoardRepository){
        this.iBoardRepository = iBoardRepository;
    }
    
    public void createBoard(Board board){
        iBoardRepository.createBoard(board);
    }
    
    public List<Board> getBoards(){
        return iBoardRepository.getBoards();
    }
    
    
    public void deleteBoardById(Long boardId){
        iBoardRepository.deleteBoardById(boardId);
    }
}
