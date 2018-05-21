package controller;

import domain.ChatMessage;
import domain.Person;

import javax.el.ArrayELResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

public class GetMessagesHandler extends AsyncHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {


        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        if(person != null){

            ArrayList<Object> messages = new ArrayList<>();

            for(ChatMessage cm : getMessageService ().getMessagesFor(person)){

                messages.add(cm.getSender() + ": " + cm.getMessage());
            }

            return toJSONList(messages);

        }

        return toJSON("chatMessages", "");
    }
}
