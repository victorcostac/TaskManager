/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Domain.Task;
import Infrastructure.ITaskRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TaskService {
    private final ITaskRepository iTaskRepository; //EQUIVALENTE A UM DAO
    
    public TaskService(ITaskRepository iTaskRepository){
        this.iTaskRepository = iTaskRepository;
    }
    
    public void createTask(Task task){
        iTaskRepository.createTask(task);
    }
    
    void deleteTaskById(Long taskId){
        iTaskRepository.deleteTaskById(taskId);
    }
    
    List<Task> getTasks(){
        return iTaskRepository.getTasks();
    }
       
}
