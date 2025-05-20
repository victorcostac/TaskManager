/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.util.List;

import domain.Tarefa;

/**
 *
 * @author Usuário
 */
public interface ITarefaRepository { //EQUIVALENTE A UM DAO
    void criarTarefa(Tarefa tarefa);
    void deletarTarefaPorId(Long tarefaId);
    List<Tarefa> getTarefas();
}
