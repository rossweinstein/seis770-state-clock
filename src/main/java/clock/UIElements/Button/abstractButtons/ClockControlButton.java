package clock.UIElements.Button.abstractButtons;

import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
import javafx.scene.control.Button;


public abstract class ClockControlButton extends Button {

    protected StateClock clock;

    public ClockControlButton() {
        this.getStyleClass().add("editButton");
        this.clock = ProgrammableClock.getClock();
    }
}
