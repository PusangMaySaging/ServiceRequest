import users.Customer;
import users.Admin;
import users.User;
import users.Session;
import request.Request;
import storage.RequestList;
import storage.UserDatabase;
import java.util.Scanner;

public class App {
    static Session session;
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
        session = userDB.authUser(username,password);
        if(session != null){
                if(session.role == "ADMIN"){
                    initializeAdminDashboard();
                }
                else{
                    initializeCustomerDashboard();
                }
        }       
        else{
            System.out.println("Invalid Username or Password");
        }
    }
    public static void initializeAdminDashboard(){
        int choice = 0;
        do{
        System.out.print("1 to View Request, 2 to Accept Request, 3 to Logout : ");
        choice = input.nextInt();
        switch(choice){
            case 1:
            User.requestList.viewAllRequest();
            case 2: 
            break;
            case 3:
            session.isAuth = false;
        }
       }
       while(session.isAuth);
    }
    public static void initializeCustomerDashboard(){
        int choice = 0;
        do{
            System.out.print("1 to View your Request, 2 to Make a Request, 3 to Logout : ");
            choice = input.nextInt();
            switch(choice){
                case 1: 
                User.requestList.viewRequestByCurrentUserId(session.id);
                break;
                case 2: 
                initializeRequestForm();
                break;
                case 3:
                session.isAuth = false;
                
            }
        }
        while(session.isAuth);
    }
    public static void initializeRequestForm(){
        input.nextLine();// fix cursor jump
        System.out.print("Enter your request description: ");
        String description = input.nextLine();
        User.requestList.createRequest(new Request(session.id, session.name, description));
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