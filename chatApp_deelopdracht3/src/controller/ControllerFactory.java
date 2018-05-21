package controller;

import domain.MessageService;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService model, MessageService messageModel) {
        return createHandler(key, model, messageModel);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService model, MessageService messageModel) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
	    	handler.setMessageModel(messageModel);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}



}
