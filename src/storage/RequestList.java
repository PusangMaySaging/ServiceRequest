package storage;

import request.Remark;
import request.Request;


public class RequestList {
    private Request[] requests = new Request[1000];
    private int numberOfRequest = 0;

    public void createRequest(Request request) {
        requests[this.numberOfRequest] = request; 
        this.numberOfRequest = this.numberOfRequest + 1;
    }
    public void changeRequestStatus(int id,String message,String ticket){
        for(int i = 0; i < numberOfRequest; i++){
            if(requests[i].id == id){
                requests[i].setStatus(true);
                requests[i].setRemark(new Remark(requests[i].description, message, ticket));
            }
        }
        
    }
    public boolean contains(int id){
        
        for(Request request: requests){
            if(request == null) break;
            if(request.id == id){
                return true;
            }
        }
        return false;
    }
    public void viewAllRequest(){
        boolean isThereExistedRecord = false;
        System.out.println("Id \t Description \t\t Status");
        for(Request request : requests){
            if(request == null) break;
            String requestStatus = request.getStatus() ?  "Fulfilled" : "On-Going";
            System.out.println(request.id + "\t" + request.description + "\t" + requestStatus);
            isThereExistedRecord = true;
        }
        if(!isThereExistedRecord){
            System.out.println("No request existed");
        }
    }
    public void viewRequestByCurrentUserId(int currentUserId){
        boolean isThereExistedRecord = false;
        System.out.println("Id \t Description \t\t Status");
        for(Request request : requests){
            if(request == null) break;
            if(request.idOfUser == currentUserId){
                String requestStatus = request.getStatus() ?  "Fulfilled" : "On-Going";
                System.out.println(request.id + "\t" + request.description + "\t" + requestStatus);
                isThereExistedRecord = true;
            }
        }
        if(!isThereExistedRecord){
            System.out.println("No request existed");
        }
    }
    public void viewRemarkedRequestByCurrentUserId(int currentUserId){
        boolean isThereExistedRecord = false;
        for(Request request : requests){
            if(request == null) break;
            if((request.idOfUser == currentUserId) && (request.getStatus()) && (request.remark != null)){
                isThereExistedRecord = true;
                System.out.println("Reported Problem: " + request.remark.userReportDesription);
                System.out.println("Administrator's Message: " + request.remark.message);
                System.out.println("Your Ticket Number: : " + request.remark.ticket);
                System.out.println("_____________________________________________________");
            }
        }
        if(!isThereExistedRecord){
            System.out.println("No request existed");
        }
    }

}
