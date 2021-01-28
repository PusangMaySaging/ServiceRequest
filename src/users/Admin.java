package users;
import request.Request;

public class Admin extends User{
    public final String ROLE = "ADMIN";
    public Admin(){

    }
    public Admin(int id,String username,String password,String name){
        super(id,username,password,name);
    }
 
	public String getRole(){
        return this.ROLE;
    }    
}




