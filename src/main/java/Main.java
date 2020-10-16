import domain.User;
import repositories.PostgresRepository;
import repositories.UserRepository;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IUserRepository;
import services.UserService;
import services.interfaces.IUserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        IUserRepository userRepo = new UserRepository();
        User loginUser = new User("Azatkali", "123456");
        User user = userRepo.findUserByLogin(loginUser);
//        User user = userRepo.getUserByUsername("Azatkali");
        System.out.println(user.getUsername() + " | " + user.getPassword());
    }
}
