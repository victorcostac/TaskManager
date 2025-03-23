/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infrastructure;

import Domain.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class IUserRepositoryImpl implements IUserRepository{
    Set<User> users = new HashSet<>();
    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        User userRecorded  = users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
        users.remove(userRecorded);
    }

    @Override
    public List<User> getUsers() {
        return users.stream().collect(Collectors.toList());
    }

    @Override
    public void editUser(User user) {
        User editUser = users.stream().filter(u ->  u.getSsn().equals(user.getSsn())).findFirst().orElse(null);
        
        users.remove(editUser);
        
        if(editUser != null){
            editUser.setAddress(user.getAddress());
            editUser.setBirthDate(user.getBirthDate());
            editUser.setCity(user.getCity());
            editUser.setName(user.getName());
            editUser.setSsn(user.getSsn());
            editUser.setZip(user.getZip());
            users.add(editUser);
        }
    }
    
}
