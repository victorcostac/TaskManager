/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*; 
import lombok.*;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */
@Entity(name = "usuario") // Esta será o nome da única tabela
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // <<< MUDE A ESTRATÉGIA AQUI
@DiscriminatorColumn(name = "TIPO_ENTIDADE", discriminatorType = DiscriminatorType.STRING) // <<< ADICIONE A COLUNA DISCRIMINADORA
@DiscriminatorValue("USUARIO_BASE") // <<< VALOR PARA INSTÂNCIAS QUE SÃO APENAS Usuario
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Temporal(value = TemporalType.DATE)
    private Date dataNasc;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // Considere cascade se Endereco for dependente
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "responsavel", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Tarefa> tarefasDesignadas;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Board> boards;

    // O construtor customizado ainda é válido, mas com @SuperBuilder,
    // @AllArgsConstructor e @NoArgsConstructor, você tem flexibilidade.
    public Usuario(String nome, String cpf, Date dataNasc, Endereco endereco, List<Tarefa> tarefasDesignadas, List<Board> boards) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.tarefasDesignadas = tarefasDesignadas;
        this.boards = boards;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
