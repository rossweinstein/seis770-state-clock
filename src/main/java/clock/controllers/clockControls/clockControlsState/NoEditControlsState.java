package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.UIElements.Button.toggleControlsState.BeginEditingClockBtn;
import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public class NoEditControlsState implements ClockControlsState {

    private Button beginEditingClockBtn;
    private ClockControls clockControls;
    private StateClock clock;

    public NoEditControlsState(ClockControls clockControls) {
        this.beginEditingClockBtn = new BeginEditingClockBtn(this);
        this.clockControls = clockControls;
        this.clock = ProgrammableClock.getClock();
    }

    @Override
    public void toggleClockControlState() {
        this.clockControls.setClockControlsEditState(new EditControlsState(this.clockControls));
    }

    @Override
    public List<Node> getAllChildren() {
        return Arrays.asList(this.beginEditingClockBtn);
    }
}
