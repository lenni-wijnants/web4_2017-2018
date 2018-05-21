package controller;

import domain.BlogPost;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/blog")
public class BlogEndpoint {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private static HashSet<String> blogPosts = new HashSet();

    @OnOpen
    public void onOpen(Session session){

        for(String blogPost: blogPosts){

            try {
                session.getBasicRemote().sendText(blogPost);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session){

        blogPosts.add(message);

        sendMessageToAll(message);
    }

    @OnClose
    public void onClose(Session session){

        sessions.remove(session);
    }

    private void sendMessageToAll(String message){
        for(Session s : sessions){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
