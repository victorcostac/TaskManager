/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Task {
    
    private String taskId; 
    private String name;
    private String responsible;
    private String Priority;
    private String upstreamPhase;
    private Date dueDate; 
    private String description;
    private Boolean isOwner;

    public Boolean IsOwner() {
        return isOwner;
    }

    public void IsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String Priority) {
        this.Priority = Priority;
    }

    public String getUpstreamPhase() {
        return upstreamPhase;
    }

    public void setUpstreamPhase(String upstreamPhase) {
        this.upstreamPhase = upstreamPhase;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Task(String taskId, String name, String responsible, String Priority, String upstreamPhase,Date dueDate, String description) {
        this.taskId = taskId;
        this.name = name;
        this.responsible = responsible;
        this.Priority = Priority;
        this.dueDate = dueDate;
        this.description = description;
        this.upstreamPhase = upstreamPhase;
    }
    
    
    public static class TaskBuilder{
        private String taskId;
        private String name;
        private String responsible;
        private String Priority;
        private String upstreamPhase;
        private Date dueDate;
        private String description;
        
        public static TaskBuilder builder() {
            return new TaskBuilder();
        }

        public TaskBuilder name(String name) {
            this.name = name;
            return this;
        }
    
        public TaskBuilder taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }
        
        public TaskBuilder responsible(String responsible) {
            this.responsible = responsible;
            return this;
        }
        
        public TaskBuilder priority(String Priority) {
            this.Priority = Priority;
            return this;
        }
        
        public TaskBuilder upstreamPhase(String upstreamPhase) {
            this.upstreamPhase = upstreamPhase;
            return this;
        }
        
        public TaskBuilder dueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        
        public TaskBuilder decription(String description) {
            this.description = description;
            return this;
        }
        
        public Task build() {
            return new Task(this.taskId, this.name, this.responsible, this.Priority, this.upstreamPhase, this.dueDate, this.description);
        }

    }
   
}
