/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Infrastructure;

import Domain.Board;
import Domain.Task;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IBoardRepository { //EQUIVALENTE A UM DAO
    
    void createBoard(Board board);
    void deleteBoardById(Long boardId);
    List<Board> getBoards();
    void addTaskToBoardList(Task task);
    void deleteTaskFromBoardList(Task task);
    List<Task> getTasksfromBoard(Board board);
    
}
