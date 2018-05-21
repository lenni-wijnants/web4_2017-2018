package db;

import domain.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageRepositoryStub {

    private ArrayList<ChatMessage> messages;

    public MessageRepositoryStub(){

        messages = new ArrayList<ChatMessage>();
        messages.add((new ChatMessage("jan@ucll.be", "billy@ucll.be", "woorden! hoera! numero uno")));
        messages.add((new ChatMessage("jan@ucll.be", "billy@ucll.be", "woorden! hoera! numero dos")));
        messages.add((new ChatMessage("jan@ucll.be", "billy@ucll.be", "woorden! hoera! numero tres")));

    }

    public void add(ChatMessage m){

        messages.add(m);
    }

    public List<ChatMessage> getMessages(){

        return messages;
    }

    public List<ChatMessage> getMessageFor(String userid){
        List<ChatMessage> messagesFor = new ArrayList<ChatMessage>();

        if(userid != null){

            for(ChatMessage m : getMessages()){

                if(m.getRecipient().equals(userid) || m.getSender().equals(userid)){

                    messagesFor.add(m);
                }
            }

        }

        return messagesFor;
    }

}
