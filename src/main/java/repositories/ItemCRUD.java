package repositories;

import domain.Item;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IEntityRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemCRUD implements IEntityRepository<Item> {
    protected IDBRepository dbrepo = new PostgresRepository();

    @Override
    public void add(Item entity) {
        try{
            String sql = "insert into items(name, category, price) " +
                    "values(?, ?, ?)";

            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getCategory());
            stmt.setInt(3, entity.getPrice());
            stmt.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Item entity) {

    }

    @Override
    public void remove(Item entity) {
        try {
            String sql = "delete from items where id = " + entity.getId();
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Item queryOne(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return new Item(
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("price")
                );
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
