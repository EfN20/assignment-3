package repositories;


import repositories.interfaces.IDBRepository;

import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresRepository implements IDBRepository {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String connStr = "jdbc:postgresql://localhost:8081/java_assignment_3";
            return DriverManager.getConnection(connStr, "postgres", "159753");
        } catch (SQLException | ClassNotFoundException ex) {
//            throw new ServerErrorException("Cannot connect to DB: " + ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
        }
        return null;
    }


//    private static Connection connection = null;
//    private static final String DRIVER_NAME = "org.postgresql.Driver";
//    static {
//        String url = "jdbc:postgresql://localhost:8081/java_assignment_3";
//        String user = "postgres";
//        String pass = "159753";
//        try {
//            Class.forName(DRIVER_NAME);
//            connection = DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() {
//        return connection;
//    }

}
