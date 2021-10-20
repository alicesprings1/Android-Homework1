package hk.edu.cuhk.iems5722.a1_1155164941;

public class Message {
    private String message;
    private String time;

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public Message(String message, String time){
        this.message=message;
        this.time=time;
    }
}
