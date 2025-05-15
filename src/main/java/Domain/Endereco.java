/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */
@Entity(name = "endereco")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String uf;


    public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

}
