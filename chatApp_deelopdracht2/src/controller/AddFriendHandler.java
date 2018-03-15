package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriendHandler extends AsyncHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        PersonService service = getPersonService();

        String newFriendId = (String)request.getParameter("friendId");
        Person person = (Person) request.getSession().getAttribute("user");

        Person newFriend = service.getPerson(newFriendId);

        if(!person.getFriendList().contains(newFriend) && service.getPersons().contains(newFriend)){

            person.addFriend(newFriend);
            service.updatePersons(person);
        }

        return "";
    }
}
