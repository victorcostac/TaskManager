/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Board {
    private Long id;
    private List<Task> taskList;
    private String name;
    private String description;
    private Boolean status;
    private String owner;
    private static Long idCount = 1L;
    public Board() {
    }

    public Board(String name, String description, String owner,Boolean status) {
        this.id = countId(Board.idCount);
        this.taskList = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.status = status;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }
    
    private static Long countId(Long id){
           return idCount++;
    }
    
    
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void inserNewTask(Task task){
      this.taskList.add(task);
    }
    
    public void deleteTask(Task task){
        this.taskList.remove(task);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    private String verifyStatus(Boolean status){
        if(status.equals(Boolean.TRUE)){
            return "active";
        }else{
            return "unactive";
        }
    }
    
    public  Object[] getData(){
        return new Object[]{this.id,this.name, this.description,  this.owner, verifyStatus(this.status)};
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
