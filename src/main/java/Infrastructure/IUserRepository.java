/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Infrastructure;

import Domain.User;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUserRepository {
    void createUser(User user);
    void deleteUserById(Long userId);
    List<User> getUsers();
    void editUser(User user);
}
