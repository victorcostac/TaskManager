/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Domain.User;
import Infrastructure.IUserRepository;
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
    
    public void createUser(User user){
        iUserRepository.createUser(user);
    }
    
    public List<User> getUsers(){
        return iUserRepository.getUsers();
    }
    
    public void deleteUser(Long userId){
        iUserRepository.deleteUserById(userId);
    }
    
    public void editUser(User user){
        iUserRepository.editUser(user);
    }
    
}
