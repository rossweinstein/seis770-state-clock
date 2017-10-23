package clock.UIElements.Button.abstractButtons;

import clock.model.stateClock.clockStates.SecondsEditState;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public abstract class IncrementDecrementButton extends ClockControlButton {
    protected void pauseIfEditingSeconds() {
        if (this.clock.getClockState() instanceof SecondsEditState) {
            this.clock.pause();
        }
    }
}
