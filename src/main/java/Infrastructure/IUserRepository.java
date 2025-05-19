/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Infrastructure;

import Domain.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUserRepository { //EQUIVALENTE A UM DAO
    void criarUsuario(Usuario usuario);
    void deletarUsuarioPorId(Long userId);
    List<Usuario> getUsuarios();
    void editarUsuario(Usuario usuario);
}
