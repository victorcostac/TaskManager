package Infrastructure.SqlImplementations;

import java.util.List;

import Domain.Usuario;
import Infrastructure.IUserRepository;

public class IUserRepositorySqlImpl implements IUserRepository{

    @Override
    public void createUser(Usuario user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public void deleteUserById(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

    @Override
    public List<Usuario> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public void editUser(Usuario user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }

}
