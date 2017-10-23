package clock.UIElements.Button.abstractButtons;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public abstract class ClockStateEditButton extends ClockControlButton {

    protected void makeSureClockIsRunning() {
        if (!this.clock.isClockRunning()) {
            this.clock.run();
        }
    }
}
