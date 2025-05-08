/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity(name = "users")
public class User {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nome;
    private String cpf;
    
    @Temporal ( value = TemporalType.DATE )
    private Date birthDate;
    
    @Column
    private String cep;
    
    @OneToOne

}
