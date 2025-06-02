/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author 2023122760093
 */
@Entity // <<< @Entity é suficiente, o nome da tabela é herdado da classe pai
@DiscriminatorValue("PROPRIETARIO") // <<< VALOR PARA INSTÂNCIAS QUE SÃO Proprietario
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor // Lombok gerará um construtor para os campos desta classe (boardsDesignados)
@NoArgsConstructor  // Necessário para JPA e Lombok
@SuperBuilder       // Permite construção fluida com campos da superclasse
public class Proprietario extends Usuario {

    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Board> boardsDesignados;

    // O construtor customizado ainda é válido.
    // Com @SuperBuilder, você também pode usar o padrão builder.
    public Proprietario(String nome, String cpf, Date dataNasc, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards, List<Board> boardsDesignados) {
        super(nome, cpf, dataNasc, endereco, tarefasDesignadas, boards);
        this.boardsDesignados = boardsDesignados;
    }
    
    @Override
    public String toString(){
        return getNome();
    
    }
    


}
