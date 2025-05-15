/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */

@Entity(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Boolean status;
    
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Tarefa> tarefas;    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuario_board",
        joinColumns = @JoinColumn(name = "board_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;
    
}
