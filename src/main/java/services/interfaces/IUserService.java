package services.interfaces;

import domain.User;

public interface IUserService {
    void add(User user);
    void remove(User user);
    void update(User User);

    User getUserById(int id);

    User getUserByUsername(String username);

    User findUserByLogin(User data);


}
