package clock.UIElements.Button.toggleControlsState;

import clock.UIElements.Button.abstractButtons.ClockStateEditButton;
import clock.controllers.clockControls.clockControlsState.ClockControlsState;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

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
            this.clockControlsState.toggleClockControlState();
        });
    }
}
