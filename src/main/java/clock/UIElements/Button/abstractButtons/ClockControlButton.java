package clock.UIElements.Button.abstractButtons;

import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
import javafx.scene.control.Button;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public abstract class ClockControlButton extends Button {

    protected StateClock clock;

    public ClockControlButton() {
        this.getStyleClass().add("editButton");
        this.clock = ProgrammableClock.getClock();
    }
}
