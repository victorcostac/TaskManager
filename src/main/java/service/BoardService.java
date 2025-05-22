/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Board;
import infrastructure.IBoardRepositoryImpl;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class BoardService {
    private final IBoardRepositoryImpl iBoardRepository;
    
    public BoardService(IBoardRepositoryImpl iBoardRepository){
        this.iBoardRepository = iBoardRepository;
    }
    
    public void criarBoard(Board board){
        iBoardRepository.inserir(board);
    }
    
    public List<Board> getBoards(Class obg){
        return iBoardRepository.listar(obg);
    }
    
    public void deletarBoard(Object board) {
        iBoardRepository.excluir(board);
    }

}
