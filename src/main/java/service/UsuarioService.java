/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Proprietario;
import domain.Usuario;
import infrastructure.GenericRepository;
import infrastructure.IUserRepositoryImpl;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class UsuarioService  extends GenericService{
    private final IUserRepositoryImpl iUserRepository;

    public UsuarioService(IUserRepositoryImpl iUserRepository) {
        super(new GenericRepository());
        this.iUserRepository = iUserRepository;
    }

    public Usuario findUsuarioComColecoes(UUID id) {
        return iUserRepository.findUsuarioComColecoes(id);
    }
    
    public Proprietario findProprietarioComColecoes(UUID id) {
        return iUserRepository.findProprietarioComColecoes(id);
    }
    
    public void promoverUsuarioParaProprietario(UUID id) {
        iUserRepository.promoverUsuarioParaProprietario(id);
    }
    
}
