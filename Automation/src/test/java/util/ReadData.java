package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import stepdefs.StepDefinitions;

public class ReadData {
    final static Logger logger = Logger.getLogger(StepDefinitions.class);

    public static String getValue(String key) {
        String value=null;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/test/resources/testData/testdata.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject)obj;
            value = (String) jsonObject.get(key);

            logger.info("Key :"+key + " Value : "+ value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

}
