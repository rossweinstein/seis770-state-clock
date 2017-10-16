package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.service.stateClock.statePatternClock.ProgrammableClock;
import clock.service.stateClock.statePatternClock.StateClock;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

public class NoEditControlsState implements ClockControlsState {

    private Button beginEditingClockBtn;
    private ClockControls clockControls;
    private StateClock clock;

    public NoEditControlsState(ClockControls clockControls) {
        this.clockControls = clockControls;
        this.setUpBeginEditingClockBtn();
        this.clock = ProgrammableClock.getClock();
    }

    private void setUpBeginEditingClockBtn() {
        this.beginEditingClockBtn = new Button("Edit Clock");
        this.beginEditingClockBtn.getStyleClass().add("editButton");
        this.beginEditingClockBtn.setOnAction( (event) -> {
            this.clock.nextClockEditState();
            this.toggleClockControlState();
        });
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
