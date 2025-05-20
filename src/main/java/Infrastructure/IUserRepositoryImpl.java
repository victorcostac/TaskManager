/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infrastructure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Usuario;

/**
 *
 * @author Usuario
 */

public class IUserRepositoryImpl implements IUserRepository{ //EQUIVALENTE A UM DAO
    Set<Usuario> users = new HashSet<>();
    @Override
    public void criarUsuario(Usuario user) {
        users.add(user);
    }

    @Override
    public void deletarUsuarioPorId(Long userId) {
        Usuario userRecorded  = users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
        users.remove(userRecorded);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return users.stream().collect(Collectors.toList());
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        Usuario editUser = users.stream().filter(u ->  u.getCpf().equals(usuario.getCpf())).findFirst().orElse(null);
        
        users.remove(editUser);
        
        if(editUser != null){
            editUser.setEndereco(usuario.getEndereco());
            editUser.setDataNasc(usuario.getDataNasc());
            editUser.setNome(usuario.getNome());
            editUser.setCpf(usuario.getCpf());
            users.add(editUser);
        }
    }
    
}
