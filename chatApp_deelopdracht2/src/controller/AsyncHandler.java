package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;

public abstract class AsyncHandler extends RequestHandler {

    public String toJSON (String key, String val) {
        StringBuffer json = new StringBuffer();

        json.append("{ \""+ key + "\" : \"");
        json.append(val);
        json.append("\"}");

        return json.toString();
    }

    public String toJSONList(Collection<Object> list){

        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


}
