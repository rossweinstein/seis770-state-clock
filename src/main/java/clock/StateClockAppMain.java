package clock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StateClockAppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent stateClockApp = FXMLLoader.load(getClass().getResource("/fxml/StateClockAppRoot.fxml"));

        Scene clockApp = new Scene(stateClockApp);
        clockApp.getStylesheets().add("/css/ClockAppStyles.css");

        primaryStage.setTitle("SEIS 770 State Pattern Clock");
        primaryStage.setScene(clockApp);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
