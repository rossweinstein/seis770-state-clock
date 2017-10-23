package clock.UIElements.Button.abstractButtons;

public abstract class ClockStateEditButton extends ClockControlButton {

    protected void makeSureClockIsRunning() {
        if (!this.clock.isClockRunning()) {
            this.clock.run();
        }
    }
}
