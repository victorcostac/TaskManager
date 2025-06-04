/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Board;
import infrastructure.GenericRepository;
import infrastructure.IBoardRepositoryImpl;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class BoardService extends GenericService{
    private final IBoardRepositoryImpl iBoardRepository;
    
    /**
     *
     * @param iBoardRepository
     */
    public BoardService(IBoardRepositoryImpl iBoardRepository){
        super(new GenericRepository());
        this.iBoardRepository = iBoardRepository;
    }
    
    public void criarBoard(Board board){
        iBoardRepository.inserir(board);
    }
    
    public List<Board> listar(){
        return iBoardRepository.listar(Board.class);
    }
    
    public void deletarBoard(Object board) {
        iBoardRepository.excluir(board);
    }
    
    public List<Board> listarBoardsPorUsuario(UUID usarioId) {
        return iBoardRepository.listarBoardsPorUsuario(usarioId);
    }

}
