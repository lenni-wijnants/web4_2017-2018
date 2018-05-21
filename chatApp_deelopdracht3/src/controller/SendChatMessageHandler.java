package controller;

import domain.ChatMessage;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendChatMessageHandler extends AsyncHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String message = request.getParameter("chatmessage");
        String recipient = request.getParameter("recipient");

        Person sender = (Person)request.getSession().getAttribute("user");

        if(sender.hasFriend(recipient)){

            ChatMessage newMessage = new ChatMessage(recipient,sender.getUserId(),message);
            getMessageService().add(newMessage);
        }

        return "";
    }
}
