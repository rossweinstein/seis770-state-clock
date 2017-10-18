package clock.controllers.clockControls.clockControlButtons.incrementDecrementTimeButtons;

import clock.controllers.clockControls.clockControlButtons.abstractButtons.IncrementDecrementButton;

/**
 * Created by Pamela on 10/17/17.
 */
public class IncrementTimeBtn extends IncrementDecrementButton {

    public IncrementTimeBtn() {
        super();
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText("+");
        this.setOnAction( (event) -> {
            this.pauseIfEditingSeconds();
            this.clock.incrementTime();
        });
    }
}
