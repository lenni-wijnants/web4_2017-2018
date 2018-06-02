package domain;

import db.MessageRepositoryStub;

import java.util.List;

public class MessageService {

    private MessageRepositoryStub stub;

    public MessageService(){

        stub = new MessageRepositoryStub();
    }

    public void add(ChatMessage m){

        stub.add(m);
    }

    public List<ChatMessage> getMessages(){

        return stub.getMessages();
    }

    public List<ChatMessage> getMessagesFor(String userid){
        return stub.getMessageFor(userid);
    }

    public List<ChatMessage> getMessagesFor(Person p){

        return stub.getMessageFor(p.getUserId());
    }
}
