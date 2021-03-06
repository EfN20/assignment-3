package services.interfaces;

import domain.Item;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public interface IItemService {
    void add(Item item);
    void remove(Item item);

    Item getItemById(int id);

    Item getItemByName(String name);

    Queue<Item> getItemsByCategory(String category);

    Map<Integer, String> getCategoriesOfItems();

    Set<Item> getAllItems();
}
