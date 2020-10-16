package services;

import domain.User;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepo = new UserRepository();

    @Override
    public void add(User user) {
        userRepo.add(user);
    }

    @Override
    public void remove(User user) {
        userRepo.remove(user);
    }

    @Override
    public void update(User user) {
        userRepo.update(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }

    @Override
    public User findUserByLogin(User data) {
        return userRepo.findUserByLogin(data);
    }
}
