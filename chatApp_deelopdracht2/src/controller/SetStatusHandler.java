package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetStatusHandler extends AsyncHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String newStatus = (String)request.getParameter("status");
        Person person = (Person) request.getSession().getAttribute("user");
        person.setStatus(newStatus);
        getPersonService().updatePersons(person);

        return "";
    }
}
