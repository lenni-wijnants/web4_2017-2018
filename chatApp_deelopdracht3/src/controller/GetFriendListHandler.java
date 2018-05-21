package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

public class GetFriendListHandler extends AsyncHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response){

        // gebruiker die ingelogd is uit session halen

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        if(person != null){


            // van die gebruiker vriendenlijst opvragen

            Collection<Person> friendList = person.getFriendList();
            // vriendenlijst terug geven

            Collection<Object> friendListNames = new ArrayList<>();
            for(Person p : friendList) {

                friendListNames.add(p.getUserId() + " (" + p.getStatus() + ")");
            }

            return toJSONList(friendListNames);

        }

        return toJSON("friendlist", "");
    }
}
