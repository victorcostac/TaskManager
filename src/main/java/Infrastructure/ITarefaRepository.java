/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Usuário
 */
public interface ITarefaRepository { //EQUIVALENTE A UM DAO
    List listarTarefasPorBoard(UUID id);
}
