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
    static int requestID = 1;
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
            break;
            case 2: 
            initializeChangeStatusForm();
            break;
            case 3:
            session.isAuth = false;
            break;
            default:
            System.out.println("Invalid Option");
        }
       }
       while(session.isAuth);
    }
    public static void initializeCustomerDashboard(){
        int choice = 0;
        do{
            System.out.print("1 to View your Request, 2 to Make a Request,3 View Remarked Request, 4 to Logout : ");
            choice = input.nextInt();
            switch(choice){
                case 1: 
                User.requestList.viewRequestByCurrentUserId(session.id);
                break;
                case 2: 
                initializeRequestForm();
                break;
                case 3: 
                User.requestList.viewRemarkedRequestByCurrentUserId(session.id);
                break;
                case 4:
                session.isAuth = false;
                break;
                default:
                System.out.println("Invalid Option");
            }
        }
        while(session.isAuth);
    }
    public static void initializeRequestForm(){
        input.nextLine();// fix cursor jump
        System.out.print("Enter your request description: ");
        String description = input.nextLine();
        User.requestList.createRequest(new Request(requestID,session.id, session.name, description));
        requestID = requestID + 1;
    }  
    public static void initializeChangeStatusForm(){
        // fix cursor jump
        int id = 0;
        System.out.print("Enter ID of request to be fulfilled: ");
        id = input.nextInt();
        input.nextLine();
        boolean isRecordExisted = User.requestList.contains(id);
        if(isRecordExisted){
            System.out.println("Enter message: ");
            String message = input.nextLine();
            System.out.println("Enter ticket: ");
            String ticket = input.nextLine();
            User.requestList.changeRequestStatus(id, message, ticket);
        }
        else{
            System.out.println("no records existed with id of : " + id);
        }

    } 

}



