package request;

public class Request {
    public int idOfUser;
    public static int id;
    public String nameOfUser;
    public String description;
    private boolean isAccepted = false;

    public Request(int idOfUser, String nameOfUser, String description){
        this.idOfUser = idOfUser;
        Request.id = Request.id + 1;
        this.nameOfUser = nameOfUser;;
        this.description = description;

    }
    public void setAccepted(boolean val){
        this.isAccepted = val;
    }
}
