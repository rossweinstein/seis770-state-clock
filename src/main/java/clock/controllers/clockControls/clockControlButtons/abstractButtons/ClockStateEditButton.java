package clock.controllers.clockControls.clockControlButtons.abstractButtons;

public abstract class ClockStateEditButton extends ClockControlButton {

    protected void makeSureClockIsRunning() {
        if (!this.clock.isClockRunning()) {
            this.clock.run();
        }
    }
}
