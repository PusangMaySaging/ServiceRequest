package request;

public class Request {
    public int id;
    public int idOfUser;
    public String nameOfUser;
    public String description;
    private boolean status = false;
    public Remark remark;
    public Request(int id,int idOfUser, String nameOfUser, String description){
        this.id = id;
        this.idOfUser = idOfUser;
        this.nameOfUser = nameOfUser;;
        this.description = description;

    }
    public void setStatus(boolean val){
        this.status = val;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setRemark(Remark remark){
        this.remark = remark;
    }
    
}
