/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

import domain.Tarefa;
import infrastructure.GenericRepository;
import infrastructure.ITarefaRepositoryImpl;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class TarefaService  extends GenericService {
    private final ITarefaRepositoryImpl iTaskRepository; //EQUIVALENTE A UM DAO
    
    public TarefaService(ITarefaRepositoryImpl iTaskRepository){
        super(new GenericRepository());
        this.iTaskRepository = iTaskRepository;
    }
    
    public void criarTarefaPorId(Tarefa tarefa){
        iTaskRepository.inserir(tarefa);
    }
    
    public void deletarTarefa(Class task){
        iTaskRepository.excluir(task);
    }    
    
    public List<Tarefa> getTarefas(Class classe){
        return iTaskRepository.listar(classe);
    }
    
    public List<Tarefa> listarTarefasPorBoard(UUID id) {
        return iTaskRepository.listarTarefasPorBoard(id);
    }
       
}
