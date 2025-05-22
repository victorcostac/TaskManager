/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infrastructure;

import java.util.List;

import domain.Board;
import domain.Tarefa;

/**
 *
 * @author Usuario
 */
public interface IBoardRepository { //EQUIVALENTE A UM DAO
    
    void adicionarTarefaNaLista(Tarefa task);
    void deletarTarefadaLista(Tarefa task);
    List<Tarefa> getTarefasDoBoard(Board board);
    
}
