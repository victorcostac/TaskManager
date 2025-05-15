/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Infrastructure;

import Domain.Board;
import Domain.Tarefa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IBoardRepository { //EQUIVALENTE A UM DAO
    
    void criarBoard(Board board);
    void deletarBoardPorId(Long boardId);
    List<Board> getBoards();
    void adicionarTarefaNaLista(Tarefa task);
    void deletarTarefadaLista(Tarefa task);
    List<Tarefa> getTarefasDoBoard(Board board);
    
}
