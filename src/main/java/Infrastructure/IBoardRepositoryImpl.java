/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import domain.Board;
import domain.Tarefa;
import java.util.List;

/**
 *
 * @author Usuario
 */

public class IBoardRepositoryImpl extends GenericRepository implements IBoardRepository{ //EQUIVALENTE A UM DAO

    public IBoardRepositoryImpl() {
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
