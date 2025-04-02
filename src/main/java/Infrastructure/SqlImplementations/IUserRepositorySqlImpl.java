package Infrastructure.SqlImplementations;

import java.util.List;

import Domain.User;
import Infrastructure.IUserRepository;

public class IUserRepositorySqlImpl implements IUserRepository{

    @Override
    public void createUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public void deleteUserById(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public void editUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }

}
