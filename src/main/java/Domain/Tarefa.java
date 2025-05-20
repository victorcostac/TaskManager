/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */
@Entity(name = "tarefa")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    
    @Column
    private String nome;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "responsavel_id" ) 
    private Usuario responsavel;
    
    @Column
    private String prioridade;
    
    @Column
    private String fase;
    
    @Temporal ( value = TemporalType.DATE )
    private Date dataVencimento; 
    
    @Column
    private String descricao;
    
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "board_id" ) 
    private Board board;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Tarefa(String nome, Usuario responsavel, String prioridade, String fase, Date dataVencimento, String descricao, Board board, Categoria categoria) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.fase = fase;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.board = board;
        this.categoria = categoria;
    }
    
}
