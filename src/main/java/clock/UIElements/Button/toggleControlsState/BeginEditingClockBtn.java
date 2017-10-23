package clock.UIElements.Button.toggleControlsState;

import clock.UIElements.Button.abstractButtons.ClockControlButton;
import clock.controllers.clockControls.clockControlsState.ClockControlsState;


public class BeginEditingClockBtn extends ClockControlButton {

    private ClockControlsState clockControlsState;

    public BeginEditingClockBtn(ClockControlsState clockControlsState) {
        super();
        this.clockControlsState = clockControlsState;
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText("Edit Clock");
        this.setOnAction((event) -> {
            this.clock.nextClockEditState();
            this.clockControlsState.toggleClockControlState();
        });
    }
}