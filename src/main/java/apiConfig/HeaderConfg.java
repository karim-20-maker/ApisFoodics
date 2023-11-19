package apiConfig;
import java.util.HashMap;
import java.util.Map;


public class HeaderConfg {


    public Map<String, String> defaultHeaders(){
        Map<String, String> defalut = new HashMap<String, String>();
        defalut.put("Content-Type", "application/json");
        return defalut;

    }
    public Map<String, String> authHeader(String authToken){
        Map<String, String> defalut = new HashMap<String, String>();
        defalut.put("Authorization", "Bearer " + authToken);
        return defalut;

    }




}