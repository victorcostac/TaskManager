/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

import domain.Tarefa;
import infrastructure.ITarefaRepository;
import infrastructure.ITarefaRepositoryImpl;

/**
 *
 * @author Usuario
 */
public class TarefaService {
    private final ITarefaRepositoryImpl iTaskRepository; //EQUIVALENTE A UM DAO
    
    public TarefaService(ITarefaRepository iTaskRepository){
        this.iTaskRepository = (ITarefaRepositoryImpl) iTaskRepository;
    }
    
    public void criarTarefaPorId(Tarefa tarefa){
        iTaskRepository.inserir(tarefa);
    }
    
    void deletarTarefa(Class task){
        iTaskRepository.excluir(task);
    }    
    
    List<Tarefa> getTarefas(Class classe){
        return iTaskRepository.listar(classe);
    }
       
}
