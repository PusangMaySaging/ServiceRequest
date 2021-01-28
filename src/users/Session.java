package users;

public class Session {
    public int id;
    public String name;
    public String role;
    public boolean isAuth; 
   public Session(int id,String name,String role){
        this.id = id;
        this.name = name;
        this.role = role;
        isAuth = true;
    }
}
