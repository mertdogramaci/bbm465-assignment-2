package model;

public class Message {
    private String message_id;
    private String content;
    private String password;    // TODO: Should be String or not?
    private User receiver;

    public Message(String message_id, String content, String password, User receiver) {
        setMessage_id(message_id);
        setContent(content);
        setPassword(password);
        setReceiver(receiver);
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    @Override
    public String toString() {
        return "Message{" +
                "message_id='" + message_id + '\'' +
                ", content='" + content + '\'' +
                ", password='" + password + '\'' +
                ", receiver=" + receiver +
                '}';
    }
    public String toWriteOnFile(){
        return message_id+"-"+content+"-"+password+"-"+receiver.getUsername();
    }
}
