package clock.UIElements.Button.abstractButtons;

import clock.model.stateClock.clockStates.SecondsEditState;

public abstract class IncrementDecrementButton extends ClockControlButton {
    protected void pauseIfEditingSeconds() {
        if (this.clock.getClockState() instanceof SecondsEditState) {
            this.clock.pause();
        }
    }
}
