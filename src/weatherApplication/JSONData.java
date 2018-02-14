package weatherApplication;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;


/**
 * Created by Karolina Pasierbiewicz
 */
public class JSONData extends Weather {

    private String nameCityJson = "";
    private String idCity = "";

    public String getNameCityJson() {
        return nameCityJson;
    }

    public void setNameCityJson(String nameCityJson) {
        this.nameCityJson = nameCityJson;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public JSONData(String cityName) {
        super(cityName);
    }

    public String jsonReadFromFile() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        try {
            Object object = jsonParser.parse(new FileReader("src/city.list.json"));
            JSONArray jsonArray = (JSONArray) object;
            JSONObject jsonObject;

            for (long index = 0; index <= 209578; index++) {
                jsonObject = (JSONObject) jsonArray.get(Math.toIntExact(index));
                nameCityJson = jsonObject.get("name").toString();

               if (nameCityJson.equals(this.getCityName())) {

                   idCity = jsonObject.get("id").toString();
                   break;
               }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return idCity;
    }
}
