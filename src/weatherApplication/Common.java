package weatherApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Karolina Pasierbiewicz
 */
public class Common extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Common.class.getResource("Template.fxml"));
        Parent layout = fxmlLoader.load();
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("weatherApplication/style.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
