package storage;

import request.Request;

public class RequestList {
    private Request[] requests = new Request[1000];
    private int numberOfRequest = 0;

    public void createRequest(Request request) {
        requests[this.numberOfRequest] = request; 
        this.numberOfRequest = this.numberOfRequest + 1;
    }
    public void viewAllRequest(){
        boolean isThereExistedRecord = false;
        for(Request request : requests){
            if(request == null) break;
            System.out.println(request.idOfUser + "\t" + request.description);
            isThereExistedRecord = true;
        }
        if(!isThereExistedRecord){
            System.out.println("No request existed");
        }
    }
    public void viewRequestByCurrentUserId(int currentUserId){
        boolean isThereExistedRecord = false;
        System.out.println("Id \t Description");
        for(Request request : requests){
            if(request == null) break;
            if(request.idOfUser == currentUserId){
                System.out.println(request.idOfUser + "\t" + request.description + " ");
                isThereExistedRecord = true;
            }
        }
        if(!isThereExistedRecord){
            System.out.println("No request existed");
        }
    }

}
