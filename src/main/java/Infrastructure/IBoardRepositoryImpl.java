/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Board;
import domain.Tarefa;

/**
 *
 * @author Usuario
 */

public class IBoardRepositoryImpl implements IBoardRepository{ //EQUIVALENTE A UM DAO
    Set<Board> boards = new HashSet<>();

    public IBoardRepositoryImpl() {
    }

    @Override
    public List<Board> getBoards() {
        return boards.stream().collect(Collectors.toList());
    }

    @Override
    public void criarBoard(Board board) {
         boards.add(board);
    }

    @Override
    public void deletarBoardPorId(Long boardId) {
        Board boardRecorded = boards.stream().filter(board -> board.getId().equals(boardId)).findFirst().orElse(null);
        boards.remove(boardRecorded);
    }

    @Override
    public void adicionarTarefaNaLista(Tarefa task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletarTarefadaLista(Tarefa task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tarefa> getTarefasDoBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
