package clock.controllers;

import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
import io.reactivex.Observable;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Observable<String> changingClockState;

    public ClockTimeDisplay() {
        this.clock = ProgrammableClock.getClock();
        this.clock.run();
    }

    private void highlightCurrentEditMode(String editState) {
        this.removedAllHighlighted();
        this.applyHighlightToCurrentActiveEditDigit(editState);
    }

    private void applyHighlightToCurrentActiveEditDigit(String editState) {
        if (editState.equals("HoursEditState")) {
            this.hours.getStyleClass().add("selected");
        } else if (editState.equals("MinutesEditState")) {
            this.minutes.getStyleClass().add("selected");
        } else if (editState.equals("SecondsEditState")){
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
        this.changingClockState.subscribe( (editClockState) ->
            this.highlightCurrentEditMode(editClockState)
        );
    }
}
