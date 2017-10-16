package clock.controllers;

import clock.service.stateClock.clockStates.EditClockState;
import clock.service.stateClock.clockStates.HoursEditState;
import clock.service.stateClock.clockStates.MinutesEditState;
import clock.service.stateClock.clockStates.SecondsEditState;
import clock.service.stateClock.statePatternClock.ProgrammableClock;
import clock.service.stateClock.statePatternClock.StateClock;
import io.reactivex.Observable;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class ClockTimeDisplay implements Initializable {

    @FXML private Text hours;
    @FXML private Text minutes;
    @FXML private Text seconds;

    private StateClock clock;
    private Observable<EditClockState> changingClockState;

    public ClockTimeDisplay() {
        this.clock = ProgrammableClock.getClock();
        this.clock.run();
    }

    private void highlightCurrentEditMode(EditClockState editState) {

        this.removedAllHighlighted();
        if (editState instanceof HoursEditState) {
            this.hours.getStyleClass().add("selected");
        } else if (editState instanceof MinutesEditState) {
            this.minutes.getStyleClass().add("selected");
        } else if (editState instanceof SecondsEditState){
            this.seconds.getStyleClass().add("selected");
        }
    }

    private void removedAllHighlighted() {
        this.hours.getStyleClass().removeAll("selected");
        this.minutes.getStyleClass().removeAll("selected");
        this.seconds.getStyleClass().removeAll("selected");
    }

    private void bindDisplayToStateClock() {
        Bindings.bindBidirectional(this.hours.textProperty(), this.clock.hoursProperty(),
                new NumberStringConverter(new DecimalFormat("00")));

        Bindings.bindBidirectional(this.minutes.textProperty(), this.clock.minutesProperty(),
                new NumberStringConverter(new DecimalFormat("00")));

        Bindings.bindBidirectional(this.seconds.textProperty(), this.clock.secondsProperty(),
                new NumberStringConverter(new DecimalFormat("00")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindDisplayToStateClock();
        this.changingClockState = this.clock.stateChange();
        this.changingClockState.subscribe( (editClockState) -> {
            this.highlightCurrentEditMode(editClockState);
        });
    }
}
