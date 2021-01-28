package users;

import request.Request;

public class Customer extends User{
    public final String ROLE = "CUSTOMER";
    public Customer(int id,String username,String password,String name){
        super(id,username,password,name);
    }
    public String getRole(){
        return this.ROLE;
    }
}
