/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Board;
import infrastructure.IBoardRepository;

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
    
    public void criarBoard(Board board){
        iBoardRepository.criarBoard(board);
    }
    
    public List<Board> getBoards(){
        return iBoardRepository.getBoards();
    }
    
    
    public void deletarBoardPorId(Long boardId){
        iBoardRepository.deletarBoardPorId(boardId);
    }
}
