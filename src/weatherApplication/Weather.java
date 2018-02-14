package weatherApplication;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

/**
 * Created by Karolina Pasierbiewicz
 */
public class Weather {

    private static String KEY_ID = "b6907d289e10d714a6e88b30761fae22";
    private static String ADRRESS_WEBSITE = "http://openweathermap.org/data/2.5/forecast?id=";
    private String cityName;
    private int[] temperatures = new int[40];
    private String[] icons = new String[40];
    private String[] date = new String[40];
    public boolean statusServer = true;
    public Weather(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    class WeatherInfo {

        public String doInBackground() {
            try {

                URL url = new URL(ADRRESS_WEBSITE + cityName + "&appid=" + KEY_ID);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                String apiDetail = "";
                char current;

                while (data != -1) {
                    current = (char)data;
                    apiDetail += current;
                    data = inputStreamReader.read();
                }
                return apiDetail;

            } catch(Exception ex) {

                //ex.printStackTrace();
                //return null;
            }
            return null;
        }
    }

    public void getWeatherInfo() throws JSONException, FileNotFoundException {

         WeatherInfo weatherInfo = new WeatherInfo();

         String weatherApiDetails = weatherInfo.doInBackground();
         if (weatherApiDetails != null) {
             JSONObject jsonObject = new JSONObject(weatherApiDetails);

             int actualyTemperature = 0;
             String actualyIcon = "";
             String actualyDate = "";
             for (int i = 0; i < 39; i++) {

                 actualyTemperature = jsonObject.getJSONArray("list").getJSONObject(i).getJSONObject("main").getInt
                         ("temp");

                 temperatures[i] = actualyTemperature;

                 actualyDate = jsonObject.getJSONArray("list").getJSONObject(i).getString
                         ("dt_txt");

                 date[i] = actualyDate.substring(0, 10);

                 actualyIcon = jsonObject.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject
                         (0).getString("icon");

                 icons[i] = actualyIcon;

             }
         } else if (weatherApiDetails == null){
             statusServer = false;
         }

    }

    public int getTemperature(int n) {

        return temperatures[n];
    }

    public String getIcon(int n) {

        return icons[n];
    }

    public String getDate(int n) {

        return date[n];
    }

}
