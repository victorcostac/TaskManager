/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Domain.Tarefa;
import java.util.List;
import Infrastructure.ITarefaRepository;

/**
 *
 * @author Usuario
 */
public class TarefaService {
    private final ITarefaRepository iTaskRepository; //EQUIVALENTE A UM DAO
    
    public TarefaService(ITarefaRepository iTaskRepository){
        this.iTaskRepository = iTaskRepository;
    }
    
    public void criarTarefaPorId(Tarefa tarefa){
        iTaskRepository.criarTarefa(tarefa);
    }
    
    void deletarTarefaPorId(Long taskId){
        iTaskRepository.deletarTarefaPorId(taskId);
    }
    
    List<Tarefa> getTarefas(){
        return iTaskRepository.getTarefas();
    }
       
}
