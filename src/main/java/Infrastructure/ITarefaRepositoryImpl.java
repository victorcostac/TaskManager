/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Tarefa;

/**
 *
 * @author Usuário
 */

public class ITarefaRepositoryImpl implements ITarefaRepository{ //EQUIVALENTE A UM DAO
    Set<Tarefa> tarefas = new HashSet<>();
    @Override
    public void criarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public void deletarTarefaPorId(Long tarefaId) {
        Tarefa TarefaRecord = tarefas.stream().filter(tarefa -> tarefa.getId().equals(tarefaId)).findFirst().orElse(null);
        tarefas.remove(TarefaRecord);
    }

    @Override
    public List<Tarefa> getTarefas() {
        return tarefas.stream().collect(Collectors.toList());
    }
    
}
