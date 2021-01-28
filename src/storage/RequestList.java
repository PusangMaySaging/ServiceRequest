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
        for(Request request : requests){
            if(request == null) break;
            System.out.println(request.idOfUser + " " + request.description);
        }
    }
    public void viewRequestByCurrentUserId(int currentUserId){
        for(Request request : requests){
            if(request == null) break;
            if(request.idOfUser == currentUserId){
                System.out.println(request.idOfUser + " " + request.description);
            }
        }
    }

}
