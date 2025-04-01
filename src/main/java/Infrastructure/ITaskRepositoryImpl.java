/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrastructure;

import Domain.Board;
import Domain.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Usuário
 */
public class ITaskRepositoryImpl implements ITaskRepository{ //EQUIVALENTE A UM DAO
    Set<Task> tasks = new HashSet<>();
    @Override
    public void createTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        Task taskRecord = tasks.stream().filter(task -> task.getTaskId().equals(taskId)).findFirst().orElse(null);
        tasks.remove(taskRecord);
    }

    @Override
    public List<Task> getTasks() {
        return tasks.stream().collect(Collectors.toList());
    }
    
}
