package request;

public class Remark {
    public String userReportDesription;
    public String message;
    public String ticket;
    public Remark(String userReportDesription, String message,String ticket){
        this.userReportDesription = userReportDesription;
        this.message = message;
        this.ticket = ticket;
    }
}
