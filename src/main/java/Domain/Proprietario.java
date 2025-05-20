/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author 2023122760093
 */
@Entity(name = "proprietario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
public class Proprietario extends Usuario{
    
    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)                                                                              
    private List<Board> boardsDesignados;

    public Proprietario(String nome, String cpf, Date dataNasc, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards, List<Board> boardsDesignadas) {
        super(nome, cpf, dataNasc, endereco, tarefasDesignadas, boards);
        this.boardsDesignados = boardsDesignadas;
    }

}
