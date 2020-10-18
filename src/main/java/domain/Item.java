package domain;

public class Item {
    private int id;
    private String name;
    private String category;
    private int price;

    public Item(){

    }

    public Item(int id, String name, String category, int price){
        setId(id);
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public Item(String name, String category, int price){
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
