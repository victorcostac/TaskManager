/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrastructure;

import Domain.Board;
import Domain.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class IBoardRepositoryImpl implements IBoardRepository{ //EQUIVALENTE A UM DAO
    Set<Board> boards = new HashSet<>();

    public IBoardRepositoryImpl() {
    }
    
    
    @Override
    public void addTaskToBoardList(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTaskFromBoardList(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void createBoard(Board board) {
        boards.add(board);
    }

    @Override
    public void deleteBoardById(Long boardId) {
        Board boardRecorded = boards.stream().filter(board -> board.getId().equals(boardId)).findFirst().orElse(null);
        boards.remove(boardRecorded);
    }

    @Override
    public List<Board> getBoards() {
        return boards.stream().collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksfromBoard(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
