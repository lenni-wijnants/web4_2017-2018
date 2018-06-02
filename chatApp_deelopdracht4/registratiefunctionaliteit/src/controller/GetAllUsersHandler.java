package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAllUsersHandler extends AsyncHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        PersonService service = getPersonService();

        // fake json (should be replaced by making json of current status of stub or db)
        // { \"id\": 3, \"name\": \"Greetje Jongen\" }

        String users = "[ ";
        for(Person p: service.getPersons()){

            users+= "{ \"email\": \"" + p.getUserId() + "\" ," +
                    "\"firstname\": \"" + p.getFirstName() + "\" ," +
                    "\"lastname\": \"" + p.getLastName() + "\" ," +
                    "\"gender\": \"" + p.getGender() + "\" ," +
                    "\"age\": " + p.getAge() + "}";

            if(service.getPersons().indexOf(p) != service.getPersons().size() - 1){

                users += ",";
            }
        }

        users += " ]";

        // setting the response type to json
        response.setContentType("application/json");
        // setting the CORS request, CrossOriginResourceSharing
        // so that this url/response is accessible in another domain (our angular application for example)
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            System.out.println(users);
            response.getWriter().write(users);
        } catch (IOException e) {
            System.out.println("Probleem met alluser json in response te steken.");
        }


        return "";
    }
}
