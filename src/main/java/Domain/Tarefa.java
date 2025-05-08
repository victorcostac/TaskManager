/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Usuario
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; 
    
    @Column
    private String nome;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "responsavel_id" ) 
    private User responsavel;
    
    @Column
    private String prioridade;
    
    @Column
    private String fase;
    
    @Temporal ( value = TemporalType.DATE )
    private Date dataVencimento; 
    
    @Column
    private String descricao;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "board_id" ) 
    private Board board;
    
    
}
