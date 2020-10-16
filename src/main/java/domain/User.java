package domain;

public class User {
    private int id;
    private static int id_gen = 1;
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }


    public User(int id, String username, String password){
        setId(id);
        setUsername(username);
        setPassword(password);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void generateId(){
        this.id = id_gen++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
