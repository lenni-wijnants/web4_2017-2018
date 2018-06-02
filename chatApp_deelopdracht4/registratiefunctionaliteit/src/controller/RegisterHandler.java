package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler extends SyncHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination="index.jsp";

        if(request.getParameter("password").equals(request.getParameter("secondpassword"))){

            String userid = request.getParameter("email");
            String password = request.getParameter("password");
            String lastName = request.getParameter("lastname");
            String firstName = request.getParameter("firstname");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));

            Person person = new Person(userid, password, firstName, lastName, Role.USER, gender, age);
            getPersonService().addPerson(person);
        }


        return destination;
    }
}
