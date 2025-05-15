/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*; 
import lombok.*;
import org.hibernate.annotations.Type;

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
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Temporal ( value = TemporalType.DATE )
    private Date dataNasc;
    
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    @OneToMany (mappedBy = "responsavel", fetch = FetchType.LAZY) 
    private List<Tarefa> tarefasDesignadas;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Board> boards;
    
    public Usuario(String nome, String cpf, Date dataNasc, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.tarefasDesignadas = tarefasDesignadas;
        this.boards = boards;
    }
}
