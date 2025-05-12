/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 2023122760093
 */
@Entity(name = "proprietario")
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario extends Usuario{
    
    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)
    private List<Board> boardsDesignados;
    
}
