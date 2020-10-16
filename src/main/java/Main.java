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
////        IDBRepository dbrepo = new PostgresRepository();
//        Connection dbrepo = PostgresRepository.getConnection();
//        String sql = "insert into users(username, password) " +
//                "values(?, ?)";
//        PreparedStatement stmt = dbrepo.prepareStatement(sql);
////        PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
//        stmt.setString(1, "Test");
//        stmt.setString(2, "123456");
//        stmt.execute();
//
//        String sql2 = "SELECT * FROM users WHERE id = " + 5 + " LIMIT 1";
////        Statement stmt2 = dbrepo.getConnection().createStatement();
//        Statement stmt2 = dbrepo.createStatement();
//        ResultSet rs = stmt2.executeQuery(sql2);
//        while (rs.next()) {
//            User user = new User(
//                    rs.getInt("id"),
//                    rs.getString("username"),
//                    rs.getString("password")
//            );
//            System.out.println(user.getUsername());
//        }
        IUserRepository userRepo = new UserRepository();
        User user = userRepo.getUserByUsername("Azatkali");
        System.out.println(user.getUsername());
    }
}
