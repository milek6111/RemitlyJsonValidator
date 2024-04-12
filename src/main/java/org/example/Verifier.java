package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Verifier {

    public static boolean verify(String JsonFilePath){
        JSONObject jsonObject = readFromFile(JsonFilePath);
        JSONObject policyDocument = (JSONObject) jsonObject.get("PolicyDocument");
        List<JSONObject> statements =  (List<JSONObject>) policyDocument.get("Statement");

        boolean asteriskChecker = true;
        for(JSONObject statement : statements){
            Object resource = statement.get("Resource");
            if(resource instanceof String){
                String value = (String) resource;
                asteriskChecker = (value.equals("*")) ? false : true;
            }
            else if(resource instanceof JSONArray){
                List<String> values = (List<String>) resource;

                for(String value : values){
                    if(value.equals("*")){
                        asteriskChecker = false;
                        break;
                    }
                }
            }

            if(!asteriskChecker){
                break;
            }
        }

        return asteriskChecker;
    }

    private static JSONObject readFromFile(String filePath){
        JSONParser jsonParser = new JSONParser();
        JSONObject returnValue = null;

        try (FileReader reader = new FileReader(filePath))
        {
            Object obj = jsonParser.parse(reader);

            returnValue = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

}
