package users;
import request.Request;
import storage.RequestList;

abstract public class User {
    public int id;
    public String username;
    public String password;
    public String name;
    static public RequestList requestList = new RequestList();
    public User(){

    }
    public User(int id,String username,String password,String name){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }
    abstract public String getRole();
}
