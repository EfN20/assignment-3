package repositories.interfaces;

import domain.User;

public interface IUserRepository extends IEntityRepository<User> {
    User getUserById(int id);

    User getUserByUsername(String username);

    User findUserByLogin(User data);
}
