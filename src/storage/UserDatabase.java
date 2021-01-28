package storage;

import users.User;
import users.Admin;
import users.Session;

public class UserDatabase<Type extends User> {
   private User[] users = new User[1000];
    int numberOfUser = 0;

    public UserDatabase(){
        this.users[numberOfUser] = new Admin(0,"admin","123","Ryan");
        numberOfUser = numberOfUser + 1; // default user on the database initialization , the ADMIN
    }
    public void add(Type user){
        this.users[numberOfUser] = user;// create new user
        numberOfUser = numberOfUser + 1;
    }
    public void printAllUsers(){
        for(User user: users){ // debugging purposes
            if(user == null) break;
            System.out.println(user.name + " " + user.getRole());
        }
    }
    public Session authUser(String username, String password){
        for(User user: users){
            if(user == null) break;
            if(user.username.equals(username) && user.password.equals(password)){
                return new Session(user.id, user.name,user.getRole());
            }
        }
        return null;
    
    }
    public User findById(int id){
        for(User user : users){
            if(user == null) break;
            if(user.id == id){
                return user;
            }
        }
        return null;
    }
}
