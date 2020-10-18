import domain.Item;
import domain.User;
import repositories.ItemRepository;
import repositories.PostgresRepository;
import repositories.UserRepository;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IItemRepository;
import repositories.interfaces.IUserRepository;
import services.UserService;
import services.interfaces.IUserService;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        IUserRepository userRepo = new UserRepository();
        User loginUser = new User("Azatkali", "123456");
        User user = userRepo.findUserByLogin(loginUser);
//        User user = userRepo.getUserByUsername("Azatkali");
        System.out.println(user.getUsername() + " | " + user.getPassword());

        ItemRepository itemRepo = new ItemRepository();
//        Item item = itemRepo.getItemByName("Iron man");
//        System.out.println(item.getName() + " | " + item.getPrice());
//        System.out.println();
//
//        Set<Item> s = itemRepo.getAllItems();
//        Iterator<Item> iterator = s.iterator();
//        while (iterator.hasNext()){
//            Item item1 = iterator.next();
//            System.out.println(item1.getName() + " | " + item1.getPrice());
//        }
//        System.out.println();
        Map<Integer, String> ct = itemRepo.getCategoriesOfItems();
        for(Map.Entry<Integer, String> e : ct.entrySet()){
            System.out.println(e.getKey() + " | " + e.getValue());
        }
    }
}
