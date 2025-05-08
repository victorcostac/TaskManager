/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */

@Entity(name = "board")
public class Board {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Boolean status;
    @Column
    private User proprietario;
    
    @OneToMany(mappedBy = )
    private List<Task> taskList;
    
    
    public Board() {
    }

    public Board(String nome, String descricao, User proprietario,Boolean status) {
        this.taskList = new ArrayList<>();
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.proprietario = proprietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getProprietario() {
        return proprietario;
    }

    public void setProprietario(User proprietario) {
        this.proprietario = proprietario;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Board(String nome, String descricao, Boolean status, User proprietario, List<Task> taskList) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.proprietario = proprietario;
        this.taskList = taskList;
    }

    public Board(String nome, String descricao, Boolean status, User proprietario) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Board other = (Board) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        return Objects.equals(this.taskList, other.taskList);
    }

    
    
    
    @Override
    public String toString() {
        return null;
    }
    
}
