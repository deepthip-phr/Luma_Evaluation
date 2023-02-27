package com.motivitylabs.DataManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingDatafromJson {
    public String ReadingData(String key) throws FileNotFoundException {
        Object obj = null;
        try {


            obj = new JSONParser().parse(new FileReader("C:/Users/Deepthi/LumaEvaluation/src/test/TestData/LumaData.json"));
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();
        }


        JSONObject jsonObject = (JSONObject) obj;
        String value = jsonObject.get(key).toString();
        return value;
    }
}
