/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrastructure;

import Domain.Board;
import Domain.Task;
import java.util.List;

/**
 *
 * @author Usuário
 */
public interface ITaskRepository { //EQUIVALENTE A UM DAO
    void createTask(Task task);
    void deleteTaskById(Long taskId);
    List<Task> getTasks();
}
