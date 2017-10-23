package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.UIElements.Button.changeClockState.ChangeClockEditStateBtn;
import clock.UIElements.HBox.IncrementDecrementTimeBtnHBox;
import clock.UIElements.Button.toggleControlsState.ReturnToNoEditStateBtn;
import clock.model.stateClock.statePatternClock.ProgrammableClock;
import clock.model.stateClock.statePatternClock.StateClock;
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
        this.clockControls.setClockControlsEditState(new NoEditControlsState(this.clockControls));
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
