package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.controllers.clockControls.clockControlButtons.clockStateChangeButtons.ChangeClockEditStateBtn;
import clock.controllers.clockControls.clockControlButtons.incrementDecrementTimeButtons.IncrementDecrementTimeBtnHBox;
import clock.controllers.clockControls.clockControlButtons.toggleControlsStateButtons.ReturnToNoEditStateBtn;
import clock.service.stateClock.statePatternClock.ProgrammableClock;
import clock.service.stateClock.statePatternClock.StateClock;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;

public class EditControlsState implements ClockControlsState{

    private Button changeClockEditStateBtn;
    private Button returnToNoEditStateBtn;
    private HBox incrementDecrementTimeBtnHBox;

    private ClockControls clockControls;
    private StateClock clock;

    public EditControlsState(ClockControls clockControls) {
        this.clockControls = clockControls;
        this.clock = ProgrammableClock.getClock();
        this.setUpAllButtons();
    }

    @Override
    public void toggleClockControlState() {
        this.clockControls.setClockControlsEditState(this.clockControls.getNoEditState());
    }

    @Override
    public List<Node> getAllChildren() {
        return Arrays.asList(this.incrementDecrementTimeBtnHBox, this.changeClockEditStateBtn, this.returnToNoEditStateBtn);
    }

    private void setUpAllButtons() {
        this.changeClockEditStateBtn = new ChangeClockEditStateBtn();
        this.returnToNoEditStateBtn = new ReturnToNoEditStateBtn(this);
        this.incrementDecrementTimeBtnHBox = new IncrementDecrementTimeBtnHBox();
    }
}
