package storage;

import users.User;
import users.Admin;

public class UserDatabase<Type extends User> {
   private User[] users = new User[1000];
    int numberOfUser = 0;

    public UserDatabase(){
        this.users[numberOfUser] = new Admin(0,"admin","123","Ryan");
        numberOfUser = numberOfUser + 1;
    }
    public void add(Type user){
        this.users[numberOfUser] = user;
        numberOfUser = numberOfUser + 1;
    }
    public void printAllUsers(){
        for(User user: users){
            if(user == null) break;
            System.out.println(user.name + " " + user.getRole());
        }
    }
    public String authUser(String username, String password){
        for(User user: users){
            if(user != null && (user.username.equals(username)&&user.password.equals(password))){
                return user.getRole(); 
            }else{
                break;
            }
        }
        return "NULL";
    
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
