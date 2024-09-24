package guru.qa.niffler.service;

import guru.qa.niffler.data.dao.UserdataUserDAO;
import guru.qa.niffler.data.dao.impl.UserdataUserDAOJdbc;
import guru.qa.niffler.data.entity.user.UserEntity;

import java.util.Optional;
import java.util.UUID;

public class UserDbClient {

    private final UserdataUserDAO userDAO = new UserdataUserDAOJdbc();

    public UserEntity create(UserEntity user) {
        return userDAO.create(user);
    }

    public Optional<UserEntity> findById(UUID id) {
        return userDAO.findById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public void delete(UserEntity user) {
        userDAO.delete(user);
    }
}
