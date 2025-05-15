/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.experimental.SuperBuilder;
import lombok.*;

/**
 *
 * @author 2023122760093
 */
@Entity(name = "proprietario")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper=true)
public class Proprietario extends Usuario{
    
    public Proprietario(String nome, String cpf, Date birthDate, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards, List<Board> boardsDesignadas) {
        super(nome, cpf, birthDate, endereco, tarefasDesignadas, boards);
        this.boardsDesignados = boardsDesignadas;
    }

    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)                                                                              
    private List<Board> boardsDesignados;
    
}
