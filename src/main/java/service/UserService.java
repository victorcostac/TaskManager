/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Usuario;
import infrastructure.IUserRepository;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    
    public void criarUsuario(Usuario user){
        iUserRepository.criarUsuario(user);
    }
    
    public List<Usuario> getUsuarios(){
        return iUserRepository.getUsuarios();
    }
    
    public void deletarUsuarioPorId(Long userId){
        iUserRepository.deletarUsuarioPorId(userId);
    }
    
    public void editarUsuario(Usuario user){
        iUserRepository.editarUsuario(user);
    }
    
}
