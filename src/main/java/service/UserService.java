/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Usuario;
import infrastructure.IUserRepositoryImpl;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserService {
    private final IUserRepositoryImpl iUserRepository;

    public UserService(IUserRepositoryImpl iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    
    public void criarUsuario(Usuario user){
        iUserRepository.inserir(user);
    }
    
    public List<Usuario> getUsuarios(){
        return iUserRepository.listar(Usuario.class);
    }
    
    public void editarUsuario(Usuario user){
        iUserRepository.alterar(user);
    }
    
}
