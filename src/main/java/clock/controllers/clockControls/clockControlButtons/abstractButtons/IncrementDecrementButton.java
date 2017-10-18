package clock.controllers.clockControls.clockControlButtons.abstractButtons;

import clock.service.stateClock.clockStates.SecondsEditState;

public abstract class IncrementDecrementButton extends ClockControlButton {
    protected void pauseIfEditingSeconds() {
        if (this.clock.getClockState() instanceof SecondsEditState) {
            this.clock.pause();
        }
    }
}
