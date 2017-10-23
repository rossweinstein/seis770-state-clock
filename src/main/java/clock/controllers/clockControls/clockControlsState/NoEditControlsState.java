package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.UIElements.Button.toggleControlsState.BeginEditingClockBtn;
import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

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
        this.clockControls.setClockControlsEditState(this.clockControls.getEditState());
    }

    @Override
    public List<Node> getAllChildren() {
        return Arrays.asList(this.beginEditingClockBtn);
    }
}
