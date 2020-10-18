package services;

import domain.Item;
import repositories.ItemRepository;
import services.interfaces.IItemService;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ItemService implements IItemService {
    private ItemRepository itemRepo = new ItemRepository();


    @Override
    public void add(Item item) {
        itemRepo.add(item);
    }

    @Override
    public void remove(Item item) {
        itemRepo.remove(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemRepo.getItemById(id);
    }

    @Override
    public Item getItemByName(String name) {
        return itemRepo.getItemByName(name);
    }

    @Override
    public Queue<Item> getItemsByCategory(String category) {
        return itemRepo.getItemsByCategory(category);
    }

    @Override
    public Map<Integer, String> getCategoriesOfItems() {
        return itemRepo.getCategoriesOfItems();
    }

    @Override
    public Set<Item> getAllItems() {
        return itemRepo.getAllItems();
    }
}
