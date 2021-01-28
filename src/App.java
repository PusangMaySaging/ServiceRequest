import users.Customer;
import users.Admin;
import users.User;
import request.Request;
import storage.RequestList;
import storage.UserDatabase;
import java.util.Scanner;

public class App {
    Session session;
    static UserDatabase<User> userDB = new UserDatabase<>();
    static Scanner input = new Scanner(System.in);
    static int registrationID = 1;
    static boolean isAppRunning = true;
    public static void main(String[] args) throws Exception {
       
   
        do{

        int menu = 0;
        System.out.print("Press 1 to Sign Up and 2 to Sign In: ");
        menu = input.nextInt();

        switch (menu) {
            case 1:
            initializeRegistrationForm(); 
            break;
            case 2:
            initializeLoginForm(); 
            break;
            default:
            System.out.println("Invalid option");
        }
    }
    while(isAppRunning);

        
    }
    public static void initializeRegistrationForm(){
        System.out.print("Enter username: ");
        String username = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
        System.out.print("Enter name: ");
        String name = input.next();
        userDB.add(new Customer(registrationID,username,password,name));
        registrationID = registrationID + 1;
    }

    public static void initializeLoginForm(){
        System.out.print("Enter username: ");
        String username = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
    }
}
class Session{
    int id;
    String name;
    String role;
    Session(int id,String name,String role){
        this.id = id;
        this.name = name;
        this.role = role;
    }
}




   // userDB.add(new Customer(1,"Kyle"));
       // userDB.add(new Customer(2,"Gelo"));
        //Customer customerOne = (Customer) userDB.findById(1);
        //Customer customerTwo = (Customer) userDB.findById(2);
     
        //..customerOne.createRequest(new Request(customerOne.id,customerOne.name,"I am requesting for replacement of new Tire"));
        //customerOne.createRequest(new Request(customerTwo.id,customerTwo.name,"I am requesting for replacement of WindShield"));
        //User.requestList.createRequest(new Request(customerOne.id,customerOne.name,"I am requesting for replacement of new Tire"));
        //User.requestList.createRequest(new Request(customerTwo.id,customerTwo.name,"I am requesting for replacement of WindShield"));
       // User.requestList.viewAllRequest();
        //User.requestList.viewRequestByCurrentUserId(2);

        //userDB.printAllUsers();