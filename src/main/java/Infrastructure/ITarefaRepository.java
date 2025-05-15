/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrastructure;

import Domain.Tarefa;
import java.util.List;

/**
 *
 * @author Usuário
 */
public interface ITarefaRepository { //EQUIVALENTE A UM DAO
    void criarTarefa(Tarefa task);
    void deletarTarefaPorId(Long taskId);
    List<Tarefa> getTarefas();
}
