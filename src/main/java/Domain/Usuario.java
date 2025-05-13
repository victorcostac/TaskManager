/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*; 
import lombok.*;

/**
 *
 * @author Usuario
 */
@Entity(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance ( strategy = InheritanceType.JOINED )
public class Usuario implements Serializable {

    public Usuario(String nome, String cpf, Date birthDate, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards) {
        this.nome = nome;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.endereco = endereco;
        this.tarefasDesignadas = tarefasDesignadas;
        this.boards = boards;
    }

    
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Temporal ( value = TemporalType.DATE )
    private Date birthDate;
    
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    @OneToMany (mappedBy = "responsavel") 
    private List<Tarefa> tarefasDesignadas;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Board> boards;

}
