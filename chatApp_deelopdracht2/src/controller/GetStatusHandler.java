package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

public class GetStatusHandler extends AsyncHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        // gebruiker die ingelogd is uit session halen

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        if(person != null){


            // van die gebruiker status en vriendenlijst opvragen

            String status = person.getStatus();

            // status terug geven

            return toJSON("status", status);

        }

        return toJSON("status", "Offline");
    }


}
