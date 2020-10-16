package repositories;

import domain.User;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IUserRepository;

import javax.ws.rs.BadRequestException;
import java.sql.*;

public class UserRepository implements IUserRepository {
//    private IDBRepository dbrepo = new PostgresRepository();
//    Connection dbrepo = PostgresRepository.getConnection();

    @Override
    public void add(User entity) {
        try{
            String sql = "insert into users(username, password) " +
                    "values(?, ?)";
//            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            PreparedStatement stmt = PostgresRepository.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getUsername());
            stmt.setString(2, entity.getPassword());
            stmt.execute();
        } catch (SQLException ex){
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        String sql = "Update users set ";
        if(entity.getPassword() != null){
            sql += "password = ?, ";
        }
        if(entity.getUsername() != null){
            sql += "username = ?, ";
        }

        sql = sql.substring(0, sql.length() - 2);
        sql += "where id = ?";

        try{
            int i = 1;
//            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            PreparedStatement stmt = PostgresRepository.getConnection().prepareStatement(sql);
            if(entity.getPassword() != null){
                stmt.setString(i++, entity.getPassword());
            }
            if(entity.getUsername() != null){
                stmt.setString(i++, entity.getUsername());
            }
            stmt.setString(i++, String.valueOf(entity.getId()));

        } catch (SQLException ex){
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void remove(User entity) {
        String sql = "Delete from users where id = " + entity.getId();
        try {
//            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            PreparedStatement stmt = PostgresRepository.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex){
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public User queryOne(String sql) {
        try {
//            Statement stmt = dbrepo.getConnection().createStatement();
            Statement stmt = PostgresRepository.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = " + id + " LIMIT 1";
        return queryOne(sql);
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = '" + username + "' LIMIT 1";
        return queryOne(sql);
    }

    @Override
    public User findUserByLogin(User data) {
        String sql = "SELECT * FROM users WHERE username = '" + data.getUsername() + "' AND password = '" + data.getPassword() + "'";
        return queryOne(sql);
    }

}
