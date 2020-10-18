package repositories;

import domain.Item;
import repositories.interfaces.IItemRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ItemRepository extends ItemCRUD implements IItemRepository {

    @Override
    public Item getItemById(int id) {
        String sql = "select * from items where id = " + id + " limit 1";
        return queryOne(sql);
    }

    @Override
    public Item getItemByName(String name) {
        String sql = "select * from items where name = '" + name + "' limit 1";
        return queryOne(sql);
    }

    @Override
    public Queue<Item> getItemsByCategory(String category) {
        try{
            String sql = "select * from items where category ='" + category + "'";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Queue<Item> items = new LinkedList<>();
            while(rs.next()){
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("price")
                );
                items.add(item);
            }
            return items;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, String> getCategoriesOfItems() {
        try{
            String sql = "select distinct(category) from items";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Map<Integer, String> categories = new LinkedHashMap<>();
            int i = 1;
            while(rs.next()){
                categories.put(i++, rs.getString("category"));
            }
            return categories;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Item> getAllItems() {
        try{
            String sql = "select * from items";
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Set<Item> items = new LinkedHashSet<>();
            while(rs.next()){
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("price")
                );
                items.add(item);
            }
            return items;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
