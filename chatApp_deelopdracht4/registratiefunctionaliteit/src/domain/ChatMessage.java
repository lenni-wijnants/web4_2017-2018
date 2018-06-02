package domain;

public class ChatMessage {

    private String recipient;
    private String sender;
    private String message;

    public ChatMessage(String recipient, String sender, String message) {
        this.recipient = recipient;
        this.sender = sender;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
