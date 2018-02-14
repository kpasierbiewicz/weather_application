package weatherApplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.controlsfx.control.textfield.TextFields;
import org.json.JSONException;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karolina Pasierbiewicz
 */
public class TemplateController extends CityNameList implements Initializable {

    // labelka podpięcia z inerfejsem
    @FXML
    private Label errorInformation;
    @FXML
    private TextField localCityname;
    @FXML
    private TextField cityName;

    @FXML
    private Label actualyLocalTemperature;
    @FXML
    private Label localTemperature1;
    @FXML
    private Label localTemperature2;
    @FXML
    private Label localTemperature3;
    @FXML
    private Label localTemperature4;
    @FXML
    private Label localTemperature5;

    @FXML
    private Label localDate1;
    @FXML
    private Label localDate2;
    @FXML
    private Label localDate3;
    @FXML
    private Label localDate4;
    @FXML
    private Label localDate5;

    @FXML
    private ImageView actualyImage;
    @FXML
    private ImageView localImage1;
    @FXML
    private ImageView localImage2;
    @FXML
    private ImageView localImage3;
    @FXML
    private ImageView localImage4;
    @FXML
    private ImageView localImage5;

    @FXML
    private Label rightTemperature;
    @FXML
    private Label temperature1;
    @FXML
    private Label temperature2;
    @FXML
    private Label temperature3;
    @FXML
    private Label temperature4;
    @FXML
    private Label temperature5;


    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;

    @FXML
    private ImageView rightImage;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;

    @FXML
    public void showInformationWeather() throws JSONException, ParseException, IOException {

        String localCity = localCityname.getText();
        String goCity = cityName.getText();

        if (!localCity.isEmpty()) {

            localCity = String.valueOf(localCity.substring(0,1)).toUpperCase() + String.valueOf(localCity.substring(1,
                    localCity.length()))
                    .toLowerCase();

            JSONData jsonData = new JSONData(localCity);
            Weather weather = new Weather(jsonData.jsonReadFromFile());
            weather.getWeatherInfo();

            if(weather.getDate(1) != null) {
                actualyLocalTemperature.setText(String.valueOf(weather.getTemperature(0)) + " ºC");
                localTemperature1.setText(String.valueOf(weather.getTemperature(1)) + " ºC");
                localTemperature2.setText(String.valueOf(weather.getTemperature(9)) + " ºC");
                localTemperature3.setText(String.valueOf(weather.getTemperature(17)) + " ºC");
                localTemperature4.setText(String.valueOf(weather.getTemperature(25)) + " ºC");
                localTemperature5.setText(String.valueOf(weather.getTemperature(38)) + " ºC");

                localDate1.setText(weather.getDate(1));
                localDate2.setText(weather.getDate(9));
                localDate3.setText(weather.getDate(17));
                localDate4.setText(weather.getDate(25));
                localDate5.setText(weather.getDate(38));

                File file = new File("src/images/" + String.valueOf(weather.getIcon(0)) + ".png");
                Image image = new Image(file.toURI().toString());
                actualyImage.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(1)) + ".png");
                image = new Image(file.toURI().toString());
                localImage1.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(9)) + ".png");
                image = new Image(file.toURI().toString());
                localImage2.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(17)) + ".png");
                image = new Image(file.toURI().toString());
                localImage3.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(25)) + ".png");
                image = new Image(file.toURI().toString());
                localImage4.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(38)) + ".png");
                image = new Image(file.toURI().toString());
                localImage5.setImage(image);
            } else {
                errorInformation.setText("Błąd Połączenia");
            }
        }

        if (!goCity.isEmpty()) {

            goCity = String.valueOf(goCity.substring(0,1)).toUpperCase() + String.valueOf(goCity.substring(1,
                    goCity.length()))
                    .toLowerCase();

            JSONData jsonData = new JSONData(goCity);
            Weather weather = new Weather(jsonData.jsonReadFromFile());
            weather.getWeatherInfo();

            if (weather.getDate(1) != null) {

                rightTemperature.setText(String.valueOf(weather.getTemperature(0)) + " ºC");
                temperature1.setText(String.valueOf(weather.getTemperature(1)) + " ºC");
                temperature2.setText(String.valueOf(weather.getTemperature(9)) + " ºC");
                temperature3.setText(String.valueOf(weather.getTemperature(17)) + " ºC");
                temperature4.setText(String.valueOf(weather.getTemperature(25)) + " ºC");
                temperature5.setText(String.valueOf(weather.getTemperature(38)) + " ºC");

                date1.setText(weather.getDate(1));
                date2.setText(weather.getDate(9));
                date3.setText(weather.getDate(17));
                date4.setText(weather.getDate(25));
                date5.setText(weather.getDate(38));

                File file = new File("src/images/" + String.valueOf(weather.getIcon(0)) + ".png");
                Image image = new Image(file.toURI().toString());
                rightImage.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(1)) + ".png");
                image = new Image(file.toURI().toString());
                image1.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(9)) + ".png");
                image = new Image(file.toURI().toString());
                image2.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(17)) + ".png");
                image = new Image(file.toURI().toString());
                image3.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(25)) + ".png");
                image = new Image(file.toURI().toString());
                image4.setImage(image);

                file = new File("src/images/" + String.valueOf(weather.getIcon(38)) + ".png");
                image = new Image(file.toURI().toString());
                image5.setImage(image);
            } else {
                errorInformation.setText("Błąd Połączenia");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextFields.bindAutoCompletion(localCityname, possibleSuggestions);
        TextFields.bindAutoCompletion(cityName, possibleSuggestions);
    }
}
