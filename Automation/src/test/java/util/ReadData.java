package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;


public class ReadData {


    public static String getValue(String key) {
        String value=null;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/test/resources/errorMessages/errorMessages.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject)obj;
            value = (String) jsonObject.get(key);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

}
