package clock.controllers.clockControls.clockControlButtons.abstractButtons;

import clock.service.stateClock.statePatternClock.ProgrammableClock;
import clock.service.stateClock.statePatternClock.StateClock;
import javafx.scene.control.Button;


public abstract class ClockControlButton extends Button {

    protected StateClock clock;

    public ClockControlButton() {
        this.getStyleClass().add("editButton");
        this.clock = ProgrammableClock.getClock();
    }
}
