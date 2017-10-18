package clock.controllers.clockControls.clockControlButtons.toggleControlsStateButtons;

import clock.controllers.clockControls.clockControlButtons.abstractButtons.ClockStateEditButton;
import clock.controllers.clockControls.clockControlsState.ClockControlsState;

public class ReturnToNoEditStateBtn extends ClockStateEditButton {

    private ClockControlsState clockControlsState;

    public ReturnToNoEditStateBtn(ClockControlsState clockControlsState) {
        this.clockControlsState = clockControlsState;
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText(" End ");
        this.setOnAction((event) -> {
            this.makeSureClockIsRunning();
            this.clock.resetToNoEditClockEditState();
            this.setText("Edit Hours");
            this.clockControlsState.toggleClockControlState();
        });
    }
}
