/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Domain.User;
import Infrastructure.IUserRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserController {
    private final IUserRepository iUserRepository;

    public UserController(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    
    public void createUser(User user){
        iUserRepository.createUser(user);
    }
    
    public List<User> getUser(){
        return iUserRepository.getUsers();
    }
    
    public void deleteUser(Long userId){
        iUserRepository.deleteUserById(userId);
    }
    
    public void editUser(User user){
        iUserRepository.editUser(user);
    }
}
