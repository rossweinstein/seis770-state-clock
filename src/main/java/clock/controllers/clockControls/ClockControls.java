package clock.controllers.clockControls;

import clock.controllers.clockControls.clockControlsState.ClockControlsState;
import clock.controllers.clockControls.clockControlsState.EditControlsState;
import clock.controllers.clockControls.clockControlsState.NoEditControlsState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public class ClockControls implements Initializable {

    @FXML
    private HBox clockControls;
    private ClockControlsState controlsEditState;

    public ClockControls() {
        this.controlsEditState = new NoEditControlsState(this);
    }

    public void setClockControlsEditState(ClockControlsState nextClockControlsState) {
        this.clockControls.getChildren().clear();
        this.clockControls.getChildren().addAll(nextClockControlsState.getAllChildren());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.clockControls.getChildren().addAll(this.controlsEditState.getAllChildren());
    }
}
